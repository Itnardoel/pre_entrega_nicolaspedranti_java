public class Main {

  public static void main(String[] args) {
    final ProductService productService = new ProductService(new ProductRepository());

    int option;

    do {
      System.out.println("\n=== Menú Principal ===");
      System.out.println("1) CRUD de Productos");
      // System.out.println("2) CRUD de Categorías");
      System.out.println("0) Salir");

      option = ConsoleInput.readInt("Opción: ");

      switch (option) {
        case 1 -> productMenu(productService);
        case 0 -> System.out.println("¡Hasta luego!");
        default -> System.out.println("Opción inválida");
      }
    } while (option != 0);
  }

  private static void productMenu(ProductService service) {
    int option;
    do {
      System.out.println("\n--- CRUD Productos ---");
      System.out.println("1) Crear");
      System.out.println("2) Listar");
      System.out.println("3) Buscar por nombre");
      System.out.println("4) Actualizar");
      System.out.println("5) Eliminar");
      System.out.println("0) Volver");

      option = ConsoleInput.readInt("Opción: ");

      switch (option) {
        case 1 -> service.createProduct();
        case 2 -> service.getAllProducts();
        case 3 -> service.getByName();
        case 4 -> service.updateProduct();
        case 5 -> service.deleteProduct();
        case 0 -> System.out.println("Volviendo al menú principal...");
        default -> System.out.println("Opción inválida");
      }
    } while (option != 0);
  }
}
