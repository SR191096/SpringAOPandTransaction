package springQ1;

import org.springframework.stereotype.Component;

@Component
public class MyDemoClass {

    public void display()
    {
        System.out.println("In display method");
    }
    public int getter()
    {
        System.out.println("In getter method");
        return 1;
    }
}
