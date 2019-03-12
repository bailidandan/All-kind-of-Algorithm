package test1;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ex3 {
public static void main(String[] args) {//自带的线程池的模具
    ThreadPoolExecutor pool =new ThreadPoolExecutor(2,3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(2));//队列长度为2，在最后面已经写清楚了
    ThreadTast tast1=new ThreadTast(1);
    ThreadTast tast2=new ThreadTast(2);
    ThreadTast tast3=new ThreadTast(3);
    ThreadTast tast4=new ThreadTast(4);
    ThreadTast tast5=new ThreadTast(5);
    ThreadTast tast6=new ThreadTast(6);
    
    
    pool.execute(tast1);//直接执行
    pool.execute(tast2);//直接执行
    
    
    pool.execute(tast3);//线程都在运行,则加入队列
    pool.execute(tast4);//线程都在运行,加入队列
    
    
    pool.execute(tast5);//当前活动线程小于最大线程,则创建线程执行，接下来的这个，就直接执行了
    
    
    pool.execute(tast6);//抛出异常
    
 
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
        System.out.println("tast"+i+"正在执行");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
} 