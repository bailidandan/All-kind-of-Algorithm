package test03;

/**
 * Created by regis on 2017/4/23.
 */
public class Service {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait() ThreadName=" + Thread.currentThread().getName());
                lock.wait();
                if (Thread.currentThread().getName().equals("Thread-1")) {
                    Thread.sleep(50000);
                }
                System.out.println("end wait() ThreadName=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void synNotifyMethod(Object lock) {
        synchronized (lock) {
            System.out.println("begin notify() ThreadName=" + Thread.currentThread().getName());
            lock.notifyAll();
            System.out.println("end notify() ThreadName=" + Thread.currentThread().getName());
        }
    }
}