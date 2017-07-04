package springQ1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Executer {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        MyDemoClass myDemoClass = applicationContext.getBean(MyDemoClass.class);
        myDemoClass.display();
        myDemoClass.getter();

    }
}
