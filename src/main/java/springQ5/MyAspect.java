package springQ5;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.io.IOException;

@Aspect
public class MyAspect {

    @Before("execution(void springQ5.MyDemoClass5.display())")
    void displayBeforeInvoked()
    {
        System.out.println("Invoke method called before execution");
    }
    @After("execution(void springQ5.MyDemoClass5.display())")
    void displayAfterInvoked()
    {
        System.out.println("Invoke method called after execution");
    }

    @Before("within(springQ5.*)")
    void displayBeforeInvokedWithIn()
    {
        System.out.println("Invoke method called before within");
    }
    @After("within(springQ5.*)")
    void displayAfterInvokedWithIn()
    {
        System.out.println("Invoke method called after within");
    }

    @Before("this(springQ5.MyDemoClass5)")
    void displayBeforeInvokedThis()
    {
        System.out.println("Invoke method called before this");
    }
    @After("this(springQ5.MyDemoClass5)")
    void displayAfterInvokedThis()
    {
        System.out.println("Invoke method called after this");
    }

    @Before("args(int)")
    void displayBeforeInvokedArgs()
    {
        System.out.println("Invoke method called before args");
    }
    @After("args(int)")
    void displayAfterInvokedArgs()
    {
        System.out.println("Invoke method called after args");
    }

    @Before("bean(myDemoClass5B)")
    void displayBeforeInvokedBean()
    {
        System.out.println("Invoke method called before bean");
    }
    @After("bean(myDemoClass5B)")
    void displayAfterInvokedBean()
    {
        System.out.println("Invoke method called after bean");
    }
}
