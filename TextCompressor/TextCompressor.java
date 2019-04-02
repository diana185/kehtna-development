import java.util.Scanner;

public class TextCompressor {
  public static void main(String[] args) {
    String text = "";
    String compressed = "";
    int charCount = 1;

    if (args.length > 0) {
      for (int i = 0; i < args.length; i++) {
        text += args[i] + " ";
      }
      text = text.trim();
      System.out.println(text);
    } else {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter text: ");
      text = scanner.nextLine();
    }

    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (i > 0) {
        if (c == text.charAt(i-1)) {
          charCount++;
        } else {
          if (charCount > 1) {
            compressed += (charCount + String.valueOf(text.charAt(i-1)));
            charCount = 1;
          } else {
            compressed += (String.valueOf(text.charAt(i-1)));
          }
        }
      }
      if (i == text.length()-1) {
        if (charCount > 1) {
          compressed += (charCount + String.valueOf(text.charAt(i)));
        } else {
          compressed += (String.valueOf(text.charAt(i)));
        }
      }
    }
    System.out.println(compressed);
  }
}
