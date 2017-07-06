package spring.txQ3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.txQ2.UserAccount;

public class Executer {
    public static void main(String[] args) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring-tx-config.xml");
        AccountServicesProgramitically accountServicesProgramitically =applicationContext.getBean(AccountServicesProgramitically.class);
        UserAccount userAccount1 = new UserAccount("Ram",25000.56);
        UserAccount userAccount2 = new UserAccount("Naina",27540.80);
        accountServicesProgramitically.addEntry(userAccount1);
        accountServicesProgramitically.addEntry(userAccount2);
        UserAccount userAccount =accountServicesProgramitically.getData("Naina");
        System.out.println(userAccount);

    }
}
