package springQ2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

    @Before("execution(void springQ2.MyDemoClass2.display())")
    void displayBeforeInvoked()
    {
        System.out.println("Invoke method called before");
    }
    @After("execution(void springQ2.MyDemoClass2.display())")
    void displayAfterInvoked()
    {
        System.out.println("Invoke method called after");
    }
}
