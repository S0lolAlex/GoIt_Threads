import java.util.ArrayList;
import java.util.List;

public class ThreadStart {
    public static void main(String[] args) {
        int numb = 15;
        FizzBuzz fizzBuzz = new FizzBuzz((n) -> {
            if (n % 15 == 0) {
                System.out.println("fizzbuzz");
            }
        });
        FizzBuzz fizz = new FizzBuzz((n) -> {
            if (n % 5 == 0) {
                System.out.println("fizz");
            }
        });
        FizzBuzz buzz = new FizzBuzz((n) -> {
            if (n % 3 == 0) {
                System.out.println("buzz");
            }
        });
        FizzBuzz number = new FizzBuzz((n) -> {
            if (n % 3 != 0 && n % 5 != 0) {
                System.out.println(n);
            }
        });

        List<FizzBuzz> threads = new ArrayList<>();
        threads.add(fizzBuzz);
        threads.add(fizz);
        threads.add(buzz);
        threads.add(number);
        for (FizzBuzz thread : threads){
            thread.start();
        }
        for(int i = 1;i <= numb;i++){
            for (FizzBuzz thread : threads) {
                thread.running(i);
            }
            while (true) {
                int runs = 0;
                for (FizzBuzz count : threads) {
                    if (count.isRun()) {
                        runs++;
                    }
                }
                if (runs == threads.size()) {
                    break;
                }
            }
        }
    }
}
