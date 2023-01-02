import java.util.Date;

public class TimeInfo extends Thread {
    private static final Date START_TIME = new Date();
    private static long upTime = START_TIME.getTime();

    public static void main(String[] args) {
        Thread begin = new Thread(() -> {
            while (!interrupted()) {
                try {
                    Thread.sleep(5000);
                    System.out.println("5 second have pass");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread timeRemain = new Thread(() -> {
            System.out.println(" Program Start at :" + START_TIME);
            while (!interrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int up = (int)(System.currentTimeMillis() - upTime) / 1000;
                System.out.println("Work time after start : " + up );
            }
        });
        timeRemain.start();
        begin.start();

    }
}

