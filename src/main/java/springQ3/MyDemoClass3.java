package springQ3;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyDemoClass3 {

    public void display() throws IOException
    {
        System.out.println("In display method");
        throw new IOException();
    }

}
