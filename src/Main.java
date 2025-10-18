public class Main {

  public static void main(String[] args) {
    String name = ConsoleInput.readString("Ingrese su nombre");

    int number = ConsoleInput.readInt("Ingrese un numero entero");

    double decimal = ConsoleInput.readDouble("Ingrese un decimal");

    System.out.println("Number: " + number + " | name: " + name + " | decimal: " + decimal);
  }
}
