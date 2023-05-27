package com.data;

public class AbstractFactoryExample {

    public static void main(String[] args) {

        AbstractFactory factory = new ConcreteFactory1();
        Client client1 = new Client(factory);
        client1.execute();

        factory = new ConcreteFactory2();
        Client client2 = new Client(factory);
        client2.execute();
    }
}

class Client {
    private AbstractProductA productA;
    private AbstractProductB productB;

    Client(AbstractFactory factory) {
        productA = factory.createProductA();
        productB = factory.createProductB();
    }

    void execute() {
        productB.interact(productA);
    }
}

abstract class AbstractFactory {
    private int i = 5;

    public abstract AbstractProductA createProductA();

    public abstract AbstractProductB createProductB();

    protected void Test() {
        System.out.println("Test " + i);
    }
}

interface AbstractProductA {
    void interact(AbstractProductB b);
}

interface AbstractProductB {
    void interact(AbstractProductA a);
}

class ConcreteFactory1 extends AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        Test();
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}

class ConcreteFactory2 extends AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}

class ProductA1 implements AbstractProductA {
    @Override
    public void interact(AbstractProductB b) {
        System.out.println(this.getClass().getName() + " interacts with " + b.getClass().getName());
    }
}

class ProductB1 implements AbstractProductB {

    @Override
    public void interact(AbstractProductA a) {
        System.out.println(this.getClass().getName() + " interacts with " + a.getClass().getName());
    }

}

class ProductA2 implements AbstractProductA {
    @Override
    public void interact(AbstractProductB b) {
        System.out.println(this.getClass().getName() + " interacts with " + b.getClass().getName());
    }
}

class ProductB2 implements AbstractProductB {

    @Override
    public void interact(AbstractProductA a) {
        System.out.println(this.getClass().getName() + " interacts with " + a.getClass().getName());
    }

}