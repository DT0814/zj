package dtdl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class LogHandler implements InvocationHandler {
    private Object obj;

    public LogHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke (obj);
        System.out.println ("yyyyyyyyyyyyy");
        return null;
    }
}