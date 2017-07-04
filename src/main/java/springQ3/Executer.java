package springQ3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Executer {
    public static void main(String[] args) throws IOException{

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        MyDemoClass3 myDemoClass2 = applicationContext.getBean(MyDemoClass3.class);
        myDemoClass2.display();

    }
}
