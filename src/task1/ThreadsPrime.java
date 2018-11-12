
package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadsPrime implements Runnable {

    private static boolean flag;
    private static int startRange;
    private static int endRange;
    private static int threadsAmount;
    private static int range;
    private static int counter;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        startRange = inputValue(scanner);
        endRange = inputValue(scanner);
        threadsAmount = inputValue(scanner);

        range = (endRange - startRange) / threadsAmount;

        for (counter = 0; counter < threadsAmount; counter++) {
            Thread thread = new Thread(new ThreadsPrime());
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(list);
    }

    public static int inputValue(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Enter an integer: ");
            sc.nextLine();
        }
        return sc.nextInt();
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; (i * i) <= number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        int i = 0;
        for (int number = startRange; number <= range && number <= endRange; number++) {
            if (isPrime(number)){
                list.add(number);
            }
        }
        range *= range;
    }
}
