package spring.txQ2;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountServices {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     void addEntry(UserAccount userAccount)
    {
        String sql = "INSERT INTO user_account (name,balance)VALUES(?,?)";
     int status =   jdbcTemplate.update(sql, new Object[]{
                userAccount.getName(), userAccount.getBalance()
        });
        statusCall(status);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public UserAccount getData(String name)
    {

        String sql = "SELECT * FROM user_account WHERE name = ?";
        return (UserAccount)jdbcTemplate.queryForObject(sql, new Object[]{name}, new RowMapper<UserAccount>() {
            @Override
            public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserAccount userAccount = new UserAccount(rs.getString("name"),rs.getDouble("balance"));
                return userAccount;
            }
        });

    }

    public void delete(String name)
    {
        String sql = "DELETE FROM user_account WHERE name = ?";
      int status =  jdbcTemplate.update(sql,new Object[]{name});
        statusCall(status);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void update(String name , double updatedBalance)
    {
        String sql = "UPDATE user_account SET balance = ? WHERE name = ?";
        int status = jdbcTemplate.update(sql,new Object[]{updatedBalance,name});
        statusCall(status);
    }

    private void statusCall(int status)
    {
        if(status>0)
        {
            System.out.println("Execution Successful..!!");
        }
        else
        {
            System.out.println("Execution Unsuccessful..!!");
        }
    }
}
