package spring.txQ4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class Executor {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-tx-config.xml");
        TransactionServices transactionServices = applicationContext.getBean(TransactionServices.class);
        transactionServices.transactAmount("Leela","Ram",10000);
    }
}
