package by.nata.concreteclass;

import by.nata.annotation.Log;
import by.nata.interfase.ProxyInterface;

public class CustomClass implements ProxyInterface {

    @Log
    @Override
    public void methodForLogging() {
        System.out.println("Method from CustomClass in process");
    }
}
