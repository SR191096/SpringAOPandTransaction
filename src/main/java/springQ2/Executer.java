package springQ2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Executer {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        MyDemoClass2 myDemoClass2 = applicationContext.getBean(MyDemoClass2.class);
        myDemoClass2.display();


    }
}
