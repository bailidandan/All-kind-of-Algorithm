package test1;

import javax.annotation.PostConstruct;  
import javax.annotation.PreDestroy;  
import javax.ejb.*;  
  
@Stateful  
@Remote(LifeCycle.class)  
public class LifeCycleBean implements LifeCycle {  
  
    public LifeCycleBean(){  
        System.out.println("���캯����ʼ��");  
    }  
  
    public String Say() {  
        try {  
            Thread.sleep(1000*10);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        return "���ǻỰBean��������Ӧ������";  
    }  
  
    @Init  
    public void initialize () {  
      System.out.println("@Init�¼�����");  
    }     
      
    @PostConstruct  
    public void Construct () {  
      System.out.println("@PostConstruct�¼�����");  
    }  
  
    @PreDestroy  
    public void exit () {  
      System.out.println("@PreDestroy�¼�����");  
    }  
  
    @PrePassivate  
    public void serialize () {  
      System.out.println("@PrePassivate�¼�����");  
    }  
  
    @PostActivate  
    public void activate () {  
      System.out.println("@PostActivate�¼�����");  
    }  
  
    @Remove  
    public void stopSession () {  
      System.out.println("@Remove�¼�����");   
      //���ø÷�����֪ͨ�������Ƴ���beanʵ������ֹ�Ự������������ǿյġ�  
    }  
  
}  