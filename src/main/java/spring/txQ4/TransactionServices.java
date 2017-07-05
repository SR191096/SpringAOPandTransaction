package spring.txQ4;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.txQ2.AccountServices;
import spring.txQ2.UserAccount;
import spring.txQ6.AccountTransactionService;

import java.io.IOException;

@Transactional
@Component
public class TransactionServices {

   private AccountServices accountServices;
   private AccountTransactionService accountTransactionService;

    public AccountTransactionService getAccountTransactionService() {
        return accountTransactionService;
    }

    public void setAccountTransactionService(AccountTransactionService accountTransactionService) {
        this.accountTransactionService = accountTransactionService;
    }

    public AccountServices getAccountServices() {
        return accountServices;
    }

    public void setAccountServices(AccountServices accountServices) {
        this.accountServices = accountServices;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
        void transactAmount(String senderName , String recieverName,double amount)
        {
                UserAccount sender = accountServices.getData(senderName);
            UserAccount reciever = accountServices.getData(recieverName);
            if(checkBalance(sender.getBalance(),amount))
            {
                accountServices.update(senderName,sender.getBalance()-amount);
                accountServices.update(recieverName,reciever.getBalance()+amount);
                accountTransactionService.updateTransactionTable(senderName,recieverName,amount);
                System.out.println(" Account Balance Updated..!!");
            }
            else
            {
                System.out.println("Insufficient Account Balance..!!");
            }
        }


        private boolean checkBalance(double initial , double todeduct)
        {
            if(initial>todeduct)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

}
