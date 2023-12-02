package by.nata;

import by.nata.concreteclass.CustomClass;
import by.nata.concreteclass.CustomClassFactory;
import by.nata.interfase.ProxyInterface;

public class Main {

    public static void main(String[] args) {

        ProxyInterface original = CustomClassFactory.createCustomClassProxy(CustomClass.class);
        original.methodForLogging();
    }
}
