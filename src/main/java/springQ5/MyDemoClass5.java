package springQ5;

import org.springframework.stereotype.Component;



@Component
public class MyDemoClass5 {

    public void display()
    {
        System.out.println("In display method MyDemoClass5");

    }
    void setter(int id)
    {
        System.out.println("In setter with value "+id);
    }
}
