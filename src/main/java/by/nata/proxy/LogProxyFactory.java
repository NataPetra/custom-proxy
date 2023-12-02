package by.nata.proxy;

import by.nata.annotation.Log;
import by.nata.interfase.ProxyInterface;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Method;

@UtilityClass
public class LogProxyFactory {
    public static Object createProxyIfNeeded(Object obj) {
        if (shouldCreateProxy(obj)) {
            return new LogProxy((ProxyInterface) obj);
        }
        return obj;
    }

    private static boolean shouldCreateProxy(Object obj) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Log.class)) {
                return true;
            }
        }
        return false;
    }
}
