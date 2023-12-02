package by.nata.proxy;

import by.nata.interfase.ProxyInterface;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingDecorator implements ProxyInterface {
    private final ProxyInterface obj;

    public LoggingDecorator(ProxyInterface obj) {
        this.obj = obj;
    }

    @Override
    public void methodForLogging() {
        log.info("LoggingDecorator: Before method execution");
        obj.methodForLogging();
        log.info("LoggingDecorator: After method execution");
    }
}
