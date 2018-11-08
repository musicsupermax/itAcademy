
package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadTask implements Runnable {

    private static int startRange;
    private static int endRange;
    private static int threadsAmount;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        startRange = inputValue(scanner);
        endRange = inputValue(scanner);
        threadsAmount = inputValue(scanner);

        Thread thread1 = new Thread(new ThreadTask());
        thread1.start();
        for (Integer list1 : list) {
            System.out.println(list1);
        }
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
        for (int number = startRange; number <= endRange; number++) {
            if (isPrime(number)) {
                list.add(number);
            }
        }
    }
}
