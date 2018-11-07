package task1;

import java.util.Scanner;

public class ThreadTask implements Runnable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startRange = inputValue(scanner);
        int endRange = inputValue(scanner);
        int threadsAmount = inputValue(scanner);
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

    }
}
