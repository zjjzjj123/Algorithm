package factory;

import java.util.Scanner;

public class TestFactory {

    public static void main(String[] args) {
        //不使用简单工厂模式 想创造不同的实例 就需要
        //Product product; //这样是属于组合关系 有一个的关系
        //只需要调用创建一个工厂类实例 然后想要什么就去问工厂类即可  这样修改逻辑代码的时候就不用修改主业务逻辑里面的了
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
        product.create();
        product = simpleFactory.createProduct(2);
        product.create();

//        if(type==1)
//        {
//            product = new ConcreteProduct1();
//            product.create();
//        }
//        else if(type==2)
//        {
//            product = new ConcreteProduct2();
//            product.create();
//        }
//        else if(type == 3)
//        {
//            product = new ConcreteProduct3();
//            product.create();
//        }

        System.out.println("end");
    }
}
