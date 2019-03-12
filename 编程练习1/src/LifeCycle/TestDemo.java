package LifeCycle;

import javax.naming.InitialContext;  
import javax.naming.NamingException;  
  
import javax.ejb.*;
  
  
public class TestDemo {  
    public static void main(String[] args) throws NamingException {  
        InitialContext ctx=new InitialContext();  
        LifeCycle lifecycle = (LifeCycle) ctx.lookup("LifeCycleBean/remote");  
        System.out.println(lifecycle.Say());  
        lifecycle.stopSession();  
        System.out.println("请注意观察Jboss控制台输出.等待10分钟,容器将会钝化此会话Bean,@PrePassivate注释的方法将会执行");  
        System.out.println("你可以调用stopSession方法把会话Bean实例删除。在删除会话Bean时，将触发@PreDestroy事件");  
    }  
}  