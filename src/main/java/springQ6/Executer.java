package springQ6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Executer {
    public static void main(String[] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        MyDemoClass6 myDemoClass6 = applicationContext.getBean(MyDemoClass6.class);
        myDemoClass6.display();

    }
}
