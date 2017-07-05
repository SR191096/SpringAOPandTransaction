package spring.txQ4;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.txQ2.AccountServices;
import spring.txQ2.UserAccount;

@Transactional
@Component
public class TransactionServices {

   private AccountServices accountServices;

    public AccountServices getAccountServices() {
        return accountServices;
    }

    public void setAccountServices(AccountServices accountServices) {
        this.accountServices = accountServices;
    }

    @Transactional(propagation = Propagation.NEVER)
        void transactAmount(String senderName , String recieverName,double amount)
        {
                UserAccount sender = accountServices.getData(senderName);
            UserAccount reciever = accountServices.getData(recieverName);
            if(checkBalance(sender.getBalance(),reciever.getBalance()))
            {
                accountServices.update(senderName,sender.getBalance()-amount);
                accountServices.update(recieverName,reciever.getBalance()+amount);
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
