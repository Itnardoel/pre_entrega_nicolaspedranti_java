import java.util.Scanner;

public class ConsoleInput {
  private static final Scanner scanner = ScannerSingleton.getInstance();

  private static final int MIN_LETTERS = 3;

  private ConsoleInput() {};

  public static final int readInt(String message) {
    while (true) {
      try {
        System.out.println(message);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("❌ Error: Ingresa un número entero válido.");
      }
    }
  }

  public static final double readDouble(String message) {
    while (true) {
      try {
        System.out.println(message);
        String input = scanner.nextLine();
        return Double.parseDouble(input);
      } catch (NumberFormatException e) {
        System.out.println("❌ Error: Ingresa un número decimal válido.");
      }
    }
  }

  public static final String readString(String message) {
    while (true) {
      System.out.println(message);
      String input = scanner.nextLine().trim();

      if (input.isEmpty()) {
        System.out.println("❌ Error: El nombre no puede estar vacío.");
        continue;
      }

      int letters = 0;
      for (char c : input.toCharArray()) {
        if (Character.isLetter(c)) {
          letters++;
        }
      }

      if (letters < MIN_LETTERS) {
        System.out.printf("❌ Error: La entrada debe contener al menos %d letras.%n", MIN_LETTERS);
        continue;
      }

      return input;
    }
  }
}
