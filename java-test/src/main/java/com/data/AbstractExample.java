package com.data;

public class AbstractExample {
    public static void main(String[] args) {
        PeopleMangement CL_A = new ClientA();
        PeopleMangement CL_B = new ClientB();
    }
}

class ClientA implements PeopleMangement {

    @Override
    public void Add(String name) {

    }

    @Override
    public void Message(String message) {

    }

    @Override
    public void Report() {

    }
}

class ClientB implements PeopleMangement {

    @Override
    public void Add(String name) {

    }

    @Override
    public void Message(String message) {

    }

    @Override
    public void Report() {

    }
}

interface AbstractProdA {
    void interact(AbstractProdA b);
}

interface AbstractProdB {
    void interact(AbstractProdB a);
}

interface PeopleMangement {
    String name = new String();
    String Message = new String();

    void Add(String name);

    void Message(String message);

    void Report();
}