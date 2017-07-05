package springQ4;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.io.IOException;
import java.text.Annotation;

@Aspect
public class MyAspect {


    @Before("@annotation(Deprecated)")
    void displayBeforeInvoked()
    {
        System.out.println("Invoke method called before deprecated method");
    }
}
