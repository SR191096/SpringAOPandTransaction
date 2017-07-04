package springQ7;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.ObjectInputStream;
import java.util.Arrays;

@Aspect
public class MyAspect {

    @Before("execution(void springQ7.MyDemoClass7.display(..))")
    void displayAfterInvoked(JoinPoint joinPoint)
    {
        System.out.println("Invoke method called before with JointPoint");
        System.out.println("Method Name : "+ joinPoint.getSignature());

        System.out.print("Method Args : ");
        Object[] objects =  joinPoint.getArgs();
        for(Object o :objects)
        {
            System.out.print(o+" ");
        }
    }
}
