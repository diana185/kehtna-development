import java.util.Random;

public class MatrixApp {

  public static void main(String[] args) {
    int rows = 2;
    int cols = 2;
    if (args.length == 2) {
      rows = Integer.parseInt(args[0]);
      cols = Integer.parseInt(args[1]);
    }
    MatrixApp app = new MatrixApp(rows, cols);
  }

  public MatrixApp(int rows, int cols) { // Constructor
    int[][] matrix = genMatrix(rows, cols);
    printMatrix(matrix);
    int[] numbers = sortNumbers(matrixToNumbers(matrix));
    //printArray(numbers);
    matrix = numbersToMatrix(numbers, rows, cols);
    printMatrix(matrix);
    if (rows == cols) {
      printMatrix(genDiagonalMatrix(rows, cols));
    }
  }

  private int randInt(int min, int max) {
    Random random = new Random();
    int randInt = random.nextInt((max - min) + 1) + min;
    return randInt;
  }

  private int[] matrixToNumbers(int[][] matrix) {
    int[] numbers = new int[(matrix.length * matrix[0].length)];
    int k = 0;
    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[0].length; j++) {
        numbers[k] = matrix[i][j];
        k++;
      }
    }
    return numbers;
  }

  private int[] sortNumbers(int[] numbers) {
    for (int i = 0; i < numbers.length-1; i++) {
      for (int j=i+1; j < numbers.length; j++) {
        if (numbers[i] > numbers[j]) {
          int aux = numbers[i];
          numbers[i] = numbers[j];
          numbers[j] = aux;
        }
      }
    }
    return numbers;
  }

  private int[][] genMatrix(int rows, int cols) {
    int[][] matrix = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = randInt(0, 9);
      }
    }
    return matrix;
  }

  private int[][] numbersToMatrix(int[] numbers, int rows, int cols) {
    int[][] matrix = new int[rows][cols];
    int k = 0;
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {
        matrix[i][j] = numbers[k];
        k++;
      }
    }
    return matrix;
  }

  private int[][] genDiagonalMatrix(int rows, int cols) {
    int[][] matrix = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (i > j) {
          matrix[i][j] = 0;
        } else if (i == j) {
          matrix[i][j] = 1;
        } else if (i < j) {
          matrix[i][j] = 2;
        }
      }
    }
    return matrix;
  }

  private void printMatrix(int[][] matrix) {
    System.out.println("");
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
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
}
