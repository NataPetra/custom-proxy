package by.nata.concreteclass;

import by.nata.exception.InstantiateException;
import by.nata.interfase.ProxyInterface;
import by.nata.proxy.LogProxyFactory;
import by.nata.proxy.LoggingDecorator;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.lang.reflect.InvocationTargetException;

@UtilityClass
public class CustomClassFactory {

    @SneakyThrows
    public static ProxyInterface createCustomClassProxy(Class<? extends ProxyInterface> clazz) {
        ProxyInterface original;
        try {
            original = clazz.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InvocationTargetException e) {
            throw new InstantiateException("Failed to instantiate the provided class.", e);
        }
        ProxyInterface proxy = (ProxyInterface) LogProxyFactory.createProxyIfNeeded(original);
        return new LoggingDecorator(proxy);
    }
}
