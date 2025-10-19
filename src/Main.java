public class Main {

  public static void main(String[] args) {
    final ItemService itemService = new ItemService(new ItemRepository());

    int option;

    do {
      System.out.println("\n=== Menú Principal ===");
      System.out.println("1) CRUD de Productos");
      // System.out.println("2) CRUD de Categorías");
      System.out.println("0) Salir");

      option = ConsoleInput.readInt("Opción: ");

      switch (option) {
        case 1 -> productMenu(itemService);
        case 0 -> System.out.println("¡Hasta luego!");
        default -> System.out.println("Opción inválida");
      }
    } while (option != 0);
  }

  private static void productMenu(ItemService service) {
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
        case 1 -> service.createItem();
        case 2 -> service.getAllItems();
        case 3 -> service.getByName();
        case 4 -> service.updateItem();
        case 5 -> service.deleteItem();
        case 0 -> System.out.println("Volviendo al menú principal...");
        default -> System.out.println("Opción inválida");
      }
    } while (option != 0);
  }
}
