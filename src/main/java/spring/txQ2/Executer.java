package spring.txQ2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Executer {
    public static void main(String[] args) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring-tx-config.xml");
        AccountServices accountServices =applicationContext.getBean(AccountServices.class);
        UserAccount userAccount1 = new UserAccount("Ram",25000.56);
        UserAccount userAccount2 = new UserAccount("Leela",27540.80);
        accountServices.addEntry(userAccount1);
        accountServices.addEntry(userAccount2);
        accountServices.update("Leela",45000);
       UserAccount userAccount =accountServices.getData("Leela");
        System.out.println(userAccount);
        accountServices.delete("Ram");
    }
}
