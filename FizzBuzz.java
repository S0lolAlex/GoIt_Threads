import java.util.concurrent.atomic.AtomicBoolean;

public class FizzBuzz extends Thread{
    private int number;
    private AtomicBoolean status = new AtomicBoolean(true);
    private ThreadStatus threadStatus;

    public FizzBuzz(ThreadStatus status){
        threadStatus = status;
    }
    public void running(int number){
        this.number = number;
        status.set(false);
    }
    public boolean isRun(){
        return status.get();
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(status.get()){
                continue;
            }
            threadStatus.threadStatus(number);

            status.set(true);
        }
    }
}