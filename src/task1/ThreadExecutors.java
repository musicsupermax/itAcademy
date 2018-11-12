package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadExecutors implements Callable<List> {

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

        ExecutorService executorService = Executors.newFixedThreadPool(threadsAmount);
        for (int counter = 0; counter < threadsAmount; counter++) {
            Future<List> future = executorService.submit(new ThreadExecutors());
            try {
                list.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
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
    public List<Integer> call() {
        List<Integer> list2 = new ArrayList<>();
        for (int number = startRange; number <= range && number <= endRange; number++, startRange++) {
            if (isPrime(number)) {
                list2.add(number);
            }
        }
        range += rangeFinal;
        return list2;
    }
}
