package test1;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ex3 {
public static void main(String[] args) {//�Դ����̳߳ص�ģ��
    ThreadPoolExecutor pool =new ThreadPoolExecutor(2,3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(2));//���г���Ϊ2����������Ѿ�д�����
    ThreadTast tast1=new ThreadTast(1);
    ThreadTast tast2=new ThreadTast(2);
    ThreadTast tast3=new ThreadTast(3);
    ThreadTast tast4=new ThreadTast(4);
    ThreadTast tast5=new ThreadTast(5);
    ThreadTast tast6=new ThreadTast(6);
    
    
    pool.execute(tast1);//ֱ��ִ��
    pool.execute(tast2);//ֱ��ִ��
    
    
    pool.execute(tast3);//�̶߳�������,��������
    pool.execute(tast4);//�̶߳�������,�������
    
    
    pool.execute(tast5);//��ǰ��߳�С������߳�,�򴴽��߳�ִ�У����������������ֱ��ִ����
    
    
    pool.execute(tast6);//�׳��쳣
    
 
    pool.shutdown();
}
}
class ThreadTast extends Thread{
    private int i;
    public ThreadTast(int i){
        this.i=i;
    }
    public void run() {
        // TODO Auto-generated method stub
        super.run();
        System.out.println("tast"+i+"����ִ��");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
} 