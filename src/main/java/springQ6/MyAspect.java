package springQ6;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;

@Aspect
public class MyAspect {


    @Before("executePointCut()")
    void displayAfterInvoked()
    {
        System.out.println("Invoke method called before by PointCut");
    }

    @Pointcut("execution(void springQ6.MyDemoClass6.display())")
        void executePointCut(){}
}
