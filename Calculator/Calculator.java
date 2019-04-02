import java.util.Scanner;

public class Calculator {

  private static int sum(int a, int b) {
    return a+b;
  }

  private static int subtract(int a, int b) {
    return a-b;
  }

  private static float divide(int a, int b) {
    return (float) a /b;
  }

  private static int multiply(int a, int b) {
    return a*b;
  }

  public static void main(String[] args) {
    int a;
    int b;
    String action;

    if (args.length == 0) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter first number: ");
      a = Integer.parseInt(scanner.next());
      System.out.print("Enter second number: ");
      b = Integer.parseInt(scanner.next());
      System.out.print("Enter action (+ - / x): ");
      action = scanner.next();
    } else {
      a = Integer.parseInt(args[0]);
      b = Integer.parseInt(args[2]);
      action = args[1];
    }

    if (action.equals("+")) {
      System.out.println(sum(a, b));

    } else if (action.equals("-")) {
      System.out.println(subtract(a, b));

    } else if (action.equals("/")) {
      System.out.println(divide(a, b));

    } else if (action.equals("x")) {
      System.out.println(multiply(a, b));
    }
  }
}
