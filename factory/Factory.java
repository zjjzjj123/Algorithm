package factory;

public abstract class Factory {

    abstract public  Product factoryMethod();

    public void doSomething()
    {
        Product product = factoryMethod(); //调用自己生产的抽象方法实现的类
    }
}
