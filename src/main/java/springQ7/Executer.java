package springQ7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Executer {
    public static void main(String[] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        MyDemoClass7 myDemoClass7 = applicationContext.getBean(MyDemoClass7.class);
        myDemoClass7.display(1,"Shubham");

    }
}
