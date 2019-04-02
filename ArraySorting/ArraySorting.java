import java.util.Scanner;
import java.util.Random;

public class ArraySorting {
  public static void main(String[] args) {
    int size, min, max;
    int[] randomArray = new int[size];

    if (args.length == 0) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter array size: ");
      size = Integer.parseInt(scanner.next());
      System.out.print("Enter minimum number: ");
      min = Integer.parseInt(scanner.next());
      System.out.print("Enter maximum number: ");
      max = Integer.parseInt(scanner.next());
    } else {
      size = Integer.parseInt(args[0]);
      min = Integer.parseInt(args[1]);
      max = Integer.parseInt(args[2]);
    }

    for (int i = 0; i < size; i++) {
      randomArray[i] = (rng(min, max));
    }

    for (int i = 0; i < size; i++) {
      System.out.println(randomArray[i]);
    }

  }

  public static int rng(int min, int max) {
    Random random = new Random();
    int randomNumber = random.nextInt((max - min) + 1) + min;
    return randomNumber;
  }
}
