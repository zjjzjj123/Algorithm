package factory;


//再次进行一次抽象的封装
public class SimpleFactory {

    //只需要调用一个方法即可
    public Product createProduct(int type) {
        if (type == 1)
        {
            return new ConcreteProduct1(); //这里就使用了 也就是关联了一个类到我们的简单工厂里面
        }

        else if(type==2)
        {
            return new ConcreteProduct2();
        }
        else
        {
            return new ConcreteProduct3();
        }
    }
}
