package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ByteSequence implements Runnable {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String fileName = inputValue(scanner);

        try (InputStream inputStream = new FileInputStream(new File("src\\" + fileName + ".txt"))) {
            int i;
            List<Byte> list = new ArrayList<>();
            while ((i = inputStream.read()) != -1) {
                list.add((byte)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String inputValue(Scanner sc) {
        while (!sc.hasNext()) {
            System.out.println("Enter an integer: ");
            sc.nextLine();
        }
        return sc.next();
    }

    @Override
    public void run() {

    }
}
