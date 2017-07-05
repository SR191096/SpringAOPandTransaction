package springQ4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Executer {
    public static void main(String[] args) throws IOException{

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        MyDemoClass4 myDemoClass4 = applicationContext.getBean(MyDemoClass4.class);
        myDemoClass4.display();
        myDemoClass4.display1();

    }
}
