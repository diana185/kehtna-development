import java.util.Scanner;
import java.util.Random;

public class ArraySorting {
  public static void main(String[] args) {
    int size, min, max;

    if (args.length == 0) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter array size: ");
      size = Integer.parseInt(scanner.next());
      System.out.print("Enter minimum number: ");
      min = Integer.parseInt(scanner.next());
      System.out.print("Enter maximum number: ");
      max = Integer.parseInt(scanner.next());
    } else {
      if (isInteger(args[0]) && isInteger(args[1]) && isInteger(args[2])) {
        size = Integer.parseInt(args[0]);
        min = Integer.parseInt(args[1]);
        max = Integer.parseInt(args[2]);
      } else {
        System.out.println("Entered data is incorrect!");
        return;
      }
    }

    int[] randomArray = new int[size];

    for (int i = 0; i < size; i++) {
      randomArray[i] = (randInt(min, max));
    }

    printArray(randomArray);
    System.out.println("- random");

    for (int i = 0; i < randomArray.length-1; i++) {
      for (int j=i+1; j < randomArray.length; j++) {
        if (randomArray[i] > randomArray[j]) {
          swap(randomArray, i, j);
        }
      }
    }

    printArray(randomArray);
    System.out.println("- sorted");
  }

  public static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
  }

  public static void swap(int[] array, int i, int j) {
    int aux = array[i];
    array[i] = array[j];
    array[j] = aux;
  }

  public static int randInt(int min, int max) {
    Random random = new Random();
    int randInt = random.nextInt((max - min) + 1) + min;
    return randInt;
  }

  public static boolean isInteger(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException ex) {
      return false;
    }
  }

  public static void incorrect() {
    System.out.println("Entered data is incorrect!");
  }
}
