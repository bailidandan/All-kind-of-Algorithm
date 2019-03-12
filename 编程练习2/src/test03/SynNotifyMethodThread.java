package test03;

/**
 * Created by regis on 2017/4/23.
 */
public class SynNotifyMethodThread extends Thread {
    private Object lock;
    public SynNotifyMethodThread(Object lock) {
        super();
        this.lock = lock;
    }
    @Override
    public void run() {
        Service service = new Service();
        service.synNotifyMethod(lock);
    }
}