import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NavalBattle implements Runnable {

  private boolean gameRunning = false;

  /**
   * Main method
   * @param args Arguments from command line - String[]
   */
  public static void main(String[] args) {
    int size = 5;
    int ships = ((size * size) / 3);
    switch(args.length) {
      case 1:
        size = Integer.parseInt(args[0]);
        break;
      case 2:
        size = Integer.parseInt(args[0]);
        ships = Integer.parseInt(args[1]);
        break;
      default:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board size: ");
        size = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the amount of ships: ");
        ships = Integer.parseInt(scanner.nextLine());
        break;
    }
    NavalBattle app = new NavalBattle(size, ships);
    Thread thread = new Thread(app);
    thread.start();
  }

  /**
   * Runnable method
   */
  public void run() {
    while (gameRunning) {
      //System.out.println("Running...");
      try {
        Thread.sleep(1000);
        clearScreen();
      } catch(Exception e) {
        // Exception
      }
    }
  }

  /**
   * Class NavalBattle constructor
   * @param size Size of the board - int
   * @param ships Amount of the ships - int
   */
  @SuppressWarnings("WeakerAccess")
  public NavalBattle(int size, int ships) {
    int[] array = genArray(size, ships);
    int[][] board = arrayToBoard(array, size);
    printBoard(board);
    //System.out.println(size);
    //System.out.println(ships);
  }

  /**
   * Array shuffler
   * @param array Array to be shuffled - int[]
   */
  private void shuffleArray(int[] array) {
    Random rnd = ThreadLocalRandom.current();
    for (int i = array.length - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      int a = array[index];
      array[index] = array[i];
      array[i] = a;
    }
  }

  private int[] boardToArray(int[][] board) {
    int[] array = new int[(board.length * board[0].length)];
    int k = 0;
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        array[k] = board[i][j];
        k++;
      }
    }
    return array;
  }

  private int[] genArray(int size, int ships) {
    int[] array = new int[(size * size)];
    for (int a = 0; a < array.length; a++) {
      if (a < ships) {
        array[a] = 1;
      } else {
        array[a] = 0;
      }
    }
    shuffleArray(array);
    return array;
  }

  private int[][] arrayToBoard(int[] array, int size) {
    int[][] board = new int[size][size];
    int k = 0;
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
        board[i][j] = array[k];
        k++;
      }
    }
    return board;
  }

  private void printBoard(int[][] board) {
    System.out.println();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  private void printArray(int[] array) {
    System.out.println();
      for (int value : array) System.out.print(value + " ");
    System.out.println();
  }

  private void clearScreen() {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch(Exception e) {
        //
    }
  }
}
