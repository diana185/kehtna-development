import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NavalBattle implements Runnable {

  private boolean gameRunning = false;

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
        size = 5;
        ships = ((size * size) / 3);
        break;
    }
    NavalBattle app = new NavalBattle(size, ships);
    Thread thread = new Thread(app);
    thread.start();
  }
  // RUN
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
  // CLASS CONSTRUCTOR
  public NavalBattle(int size, int ships) {
    int[] array = genArray(size, ships);
    int[][] board = arrayToBoard(array, size);
    printBoard(board);
    System.out.println(size);
    System.out.println(ships);
  }
  // METHODS
  private int[] shuffleArray(int[] array) {
    Random rnd = ThreadLocalRandom.current();
    for (int i = array.length - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      int a = array[index];
      array[index] = array[i];
      array[i] = a;
    }
    return array;
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
    array = shuffleArray(array);
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
    System.out.println("");
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println("");
    }
  }

  private void printArray(int[] array) {
    System.out.println("");
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println("");
  }

  private void clearScreen() {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch(Exception e) {}
  }
}
