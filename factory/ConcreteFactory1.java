package factory;

//创建具体的工厂 再次进行抽象 简单工厂直接在一个类里创建所有势力

//工厂方法是通过抽象类复用代码 创造不同的工厂 定制不同的特点的产品
public class ConcreteFactory1 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}
