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
        System.out.println("��ע��۲�Jboss����̨���.�ȴ�10����,��������ۻ��˻ỰBean,@PrePassivateע�͵ķ�������ִ��");  
        System.out.println("����Ե���stopSession�����ѻỰBeanʵ��ɾ������ɾ���ỰBeanʱ��������@PreDestroy�¼�");  
    }  
}  