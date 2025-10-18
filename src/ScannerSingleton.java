import java.util.Scanner;

// Eager Initialization
public class ScannerSingleton {
  private static final Scanner scanner = new Scanner(System.in);

  private ScannerSingleton() {};

  public static Scanner getInstance() {
    return scanner;
  }
}
