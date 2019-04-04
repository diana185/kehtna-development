import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NavalBattle implements Runnable {

  /**
   *
   */
  private boolean gameRunning = false;

  /**
   * Main method
   * @param args Arguments from command line - String[]
   */
  public static void main(String[] args) {
    int size = 5;
    int ships = ((size * size) / 3);
    int minSize = 5;
    int maxSize = 20;
    int defaultSize = 10;
    int minShips = 3;
    int maxShips = ((size * size) / 3);
    int defaultShips = ((size * size) / 2);

    switch(args.length) {
      case 1:
        try {
          size = Integer.parseInt(args[0]);
        } catch (Exception e) {
          size = defaultSize;
          System.out.println("Used default value.");
        }
        break;
      case 2:
        try {
          size = Integer.parseInt(args[0]);
        } catch (Exception e) {
          size = defaultSize;
          System.out.println("Used default value.");
        }
        try {
          size = Integer.parseInt(args[1]);
        } catch (Exception e) {
          ships = defaultShips;
          System.out.println("Used default value.");
        }
        break;
      default:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board size: ");
        try {
          size = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
          size = defaultSize;
          System.out.println("Used default value.");
        }
        System.out.println("Enter the amount of ships: ");
        try {
          ships = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
          ships = defaultShips;
          System.out.println("Used default value.");
        }
        break;
    }
    if (size > maxSize || size < minSize) {
      size = defaultSize;
      System.out.println("Used default value.");
    }
    if (ships > maxShips || ships < minShips) {
      ships = defaultShips;
      System.out.println("Used default value.");
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
    System.out.println(size);
    System.out.println(ships);
  }

  /**
   * Shuffles an array
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

  /**
   * Converts a 2D array to a 1D array
   * @param board 2D array - int[][]
   * @return 1D array - int[]
   */
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

  /**
   * Generates an array
   * @param size Size of the array - int
   * @param ships Amount of ships - int
   * @return returns array
   */
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

  /**
   * Converts a 1D array to 2D array
   * @param array 1D array - int[]
   * @param size size of the 2D array
   * @return returns 2D array - int[][]
   */
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

  /**
   * Prints a 2D array
   * @param board - array to be printed - int[][]
   */
  private void printBoard(int[][] board) {
    System.out.println();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  /**
   * Prints a 1D array
   * @param array array to be printed - itn[]
   */
  private void printArray(int[] array) {
    System.out.println();
      for (int value : array) System.out.print(value + " ");
    System.out.println();
  }

  /**
   * Clears screen only in Windows Command Prompt
   */
  private void clearScreen() {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch(Exception e) {
        //
    }
  }
}
