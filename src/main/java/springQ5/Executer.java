package springQ5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Executer {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        MyDemoClass5 myDemoClass5 = applicationContext.getBean(MyDemoClass5.class);
        MyDemoClass5B myDemoClass5B = applicationContext.getBean(MyDemoClass5B.class);
        myDemoClass5.display();
        myDemoClass5.setter(5);
        myDemoClass5B.display();

    }
}
