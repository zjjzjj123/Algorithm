package factory;

public class ConcreteProduct1 implements  Product{

    @Override
    public void create() {
        System.out.println("ConcreteProduct1");
    }
}
