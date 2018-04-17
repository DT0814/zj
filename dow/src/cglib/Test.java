package cglib;

public class Test {
    /**
     * @param args
     */
    public static void main(String[] args) {

        CglibProxy proxy = new CglibProxy ();
        Car c = (Car) proxy.getProxy (Car.class);
        c.move ();
    }

}
