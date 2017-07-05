package spring.txQ6;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.SQLException;

@Transactional
public class AccountTransactionService {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(propagation=Propagation.REQUIRED,rollbackFor = SQLException.class)
    public void updateTransactionTable(String senderName,String receiverName,double amount)
    {



        String sql = "INSERT INTO account_transaction1 (sender,receiver,balance_transferred)VALUES(?,?,?)";
        int status =   jdbcTemplate.update(sql, new Object[]{
                senderName, receiverName,amount
        });


    }

}
