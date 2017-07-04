package springQ1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

    @Before("execution(* springQ1.MyDemoClass.*())")
    void displayInvoked()
    {
        System.out.println("Invoke method called before");
    }
}
