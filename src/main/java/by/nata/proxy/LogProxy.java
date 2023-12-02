package by.nata.proxy;

import by.nata.annotation.Log;
import by.nata.interfase.ProxyInterface;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class LogProxy implements ProxyInterface {
    private final ProxyInterface obj;

    public LogProxy(ProxyInterface obj) {
        this.obj = obj;
    }

    public void invokeMethod(Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        if (method.isAnnotationPresent(Log.class)) {
            String className = obj.getClass().getSimpleName();
            String methodName = method.getName();
            log.info("Method {} of class {} is starting...", methodName, className);

            method.invoke(obj, args);

            log.info("Method {} of class {} has finished.", methodName, className);
        } else {
            method.invoke(obj, args);
        }
    }

    @Override
    public void methodForLogging() {
        try {
            Method method = obj.getClass().getMethod("methodForLogging");
            invokeMethod(method, null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
