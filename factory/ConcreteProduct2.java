package factory;

public class ConcreteProduct2 implements Product {
    @Override
    public void create() {
        System.out.println("ConcreteProduct2");
    }
}
