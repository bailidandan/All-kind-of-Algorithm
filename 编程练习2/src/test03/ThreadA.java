package test03;

/**
 * Created by regis on 2017/4/23.
 */
public class ThreadA extends Thread{
    private Object lock;
    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }
    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}
