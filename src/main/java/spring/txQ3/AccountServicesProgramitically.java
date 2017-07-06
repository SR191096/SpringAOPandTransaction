package spring.txQ3;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import spring.txQ2.UserAccount;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountServicesProgramitically {
    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager transactionManager;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    void addEntry(UserAccount userAccount)
    {
        String sql = "INSERT INTO user_account (name,balance)VALUES(?,?)";
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {

            jdbcTemplate.update( sql, userAccount.getName(), userAccount.getBalance());

            // Get the latest student id to be used in Marks table

            transactionManager.commit(status);
        }
        catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }

    }

    public UserAccount getData(String name)
    {

        String sql = "SELECT * FROM user_account WHERE name = ?";

        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {

           UserAccount user = jdbcTemplate.queryForObject(sql, new Object[]{name}, new RowMapper<UserAccount>() {
                @Override
                public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserAccount userAccount = new UserAccount(rs.getString("name"),rs.getDouble("balance"));

                    return userAccount;
                }
            });
            transactionManager.commit(status);
            // Get the latest student id to be used in Marks table
            return user;

        }
        catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }

    }

}
