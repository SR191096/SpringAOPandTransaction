package springQ4;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyDemoClass4 {

    @Deprecated
    public void display()
    {
        System.out.println("In depricated display method");

    }
    public void display1()
    {
        System.out.println("In display method");

    }

}
