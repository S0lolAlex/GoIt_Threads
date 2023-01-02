import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.currentThread;

public class ThreadStart {
    List<Thread> list = new ArrayList<>();
    private static AtomicBoolean status = new AtomicBoolean(true);

    public ThreadStart(int number) {
        temp = number;
        Thread buzz = new Thread(() -> {
            while (status.get()) {
                buzz();
                try {
                    currentThread().sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread fizz = new Thread(() -> {
            while (status.get()) {
                fizz();
                try {
                    currentThread().sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread fizzBuzz = new Thread(() -> {
            while (status.get()) {
                fizzbuzz();
                try {
                    currentThread().sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread count = new Thread(() -> {
            while (status.get()) {
                number();
                try {
                    currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        list.add(fizz);
        list.add(buzz);
        list.add(fizzBuzz);
        list.add(count);
    }

    private static int number = 1;
    private static int temp;

    private static void isStop() {
        if (number > temp) {
            status.set(false);
        }
    }

    public static void fizz() {
        isStop();
        if (number % 3 == 0 && number % 5 != 0) {
            System.out.println("fizz");
            increment();
        }

    }

    public static void buzz() {
        isStop();
        if (number % 5 == 0 && number % 3 != 0) {
            System.out.println("buzz");
            increment();
        }
    }

    public static void fizzbuzz() {
        isStop();
        if (number % 15 == 0) {
            System.out.println("fizzbuzz");
            increment();
        }
    }

    private static void increment() {
        number++;
    }

    private static void number() {
        isStop();
        System.out.println(number);
        increment();
    }
    public void start() {
        for (Thread thread : list) {
            thread.start();
        }
    }

}
