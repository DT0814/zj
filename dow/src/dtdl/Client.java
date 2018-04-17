package dtdl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        Car car = new Car ();
        InvocationHandler logHandler = new LogHandler (car);
        Class<?> cls = car.getClass ();

        uitl u = (uitl) Proxy.newProxyInstance (cls.getClassLoader (), cls.getInterfaces (), logHandler);
        u.move ();
        u.move1 ();
    }
}


class Car implements uitl {
    public void move() {
        System.out.println ("xxxxxxxxxxxxxxxxxxxxxxx");
    }

    public void move1() {
        System.out.println ("zzzzzzzzzzzzzzzzzzzzzzzz");
    }
}

