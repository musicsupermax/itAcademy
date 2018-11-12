
package task1;

import java.util.*;

public class ThreadsPrime implements Runnable {

    private static int startRange;
    private static int endRange;
    private static int threadsAmount;
    private static int range;
    private static int rangeFinal;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        startRange = inputValue(scanner);
        endRange = inputValue(scanner);
        threadsAmount = inputValue(scanner);

        range = ((endRange - startRange) / threadsAmount);
        rangeFinal = ++range;

        Calendar calendar = new GregorianCalendar();
        long start = calendar.getTimeInMillis();
        for (int counter = 0; counter < threadsAmount; counter++) {
            Thread thread = new Thread(new ThreadsPrime());
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(list);

        Calendar calendar1 = new GregorianCalendar();
        long end = calendar1.getTimeInMillis();
        System.out.println(end - start);
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
        List<Integer> list2 = new ArrayList<>();
        for (int number = startRange; number <= range && number <= endRange; number++, startRange++) {
            if (isPrime(number)) {
                list2.add(number);
            }
        }
        range += rangeFinal;
        list.addAll(list2);
    }
}
