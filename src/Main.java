public class Main {

  public static void main(String[] args) {
    final ItemRepository itemRepository = new ItemRepository();
    final CategoryRepository categoryRepository = new CategoryRepository();
    final UserRepository userRepository = new UserRepository();
    final OrderRepository orderRepository = new OrderRepository();

    final CategoryService categoryService = new CategoryService(categoryRepository, itemRepository);
    final ItemService itemService = new ItemService(itemRepository, categoryService);
    final UserService userService = new UserService(userRepository);
    final OrderService orderService = new OrderService(orderRepository, userService, itemService);

    int option;

    do {
      System.out.println("\n=== Menú Principal ===");
      System.out.println("1) CRUD de Productos");
      System.out.println("2) CRUD de Categorías");
      System.out.println("3) CRUD de Usuarios");
      System.out.println("4) CRUD de Pedidos");
      System.out.println("0) Salir");

      option = ConsoleInput.readInt("Opción: ");

      switch (option) {
        case 1 -> productMenu(itemService);
        case 2 -> categoriesMenu(categoryService);
        case 3 -> usersMenu(userService);
        case 4 -> ordersMenu(orderService);
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

  private static void categoriesMenu(CategoryService service) {
    int option;
    do {
      System.out.println("\n--- CRUD Categorías ---");
      System.out.println("1) Crear");
      System.out.println("2) Listar");
      System.out.println("3) Buscar por nombre");
      System.out.println("4) Actualizar");
      System.out.println("5) Eliminar");
      System.out.println("0) Volver");

      option = ConsoleInput.readInt("Opción: ");

      switch (option) {
        case 1 -> service.createCategory();
        case 2 -> service.getAllCategories();
        case 3 -> service.getByName();
        case 4 -> service.updateCategory();
        case 5 -> service.deleteCategory();
        case 0 -> System.out.println("Volviendo al menú principal...");
        default -> System.out.println("Opción inválida");
      }
    } while (option != 0);
  }

  private static void usersMenu(UserService service) {
    int option;
    do {
      System.out.println("\n--- CRUD Categorías ---");
      System.out.println("1) Crear");
      System.out.println("2) Listar");
      System.out.println("3) Buscar por nombre");
      System.out.println("4) Actualizar");
      System.out.println("5) Eliminar");
      System.out.println("0) Volver");

      option = ConsoleInput.readInt("Opción: ");

      switch (option) {
        case 1 -> service.createUser();
        case 2 -> service.getAllUsers();
        case 3 -> service.getByName();
        case 4 -> service.updateUser();
        case 5 -> service.deleteUser();
        case 0 -> System.out.println("Volviendo al menú principal...");
        default -> System.out.println("Opción inválida");
      }
    } while (option != 0);
  }

  private static void ordersMenu(OrderService service) {
    int option;
    do {
      System.out.println("\n--- CRUD Pedidos ---");
      System.out.println("1) Crear");
      System.out.println("2) Listar");
      System.out.println("3) Eliminar");
      System.out.println("0) Volver");

      option = ConsoleInput.readInt("Opción: ");

      switch (option) {
        case 1 -> service.createOrder();
        case 2 -> service.getAllOrders();
        case 3 -> service.deleteOrder();
        case 0 -> System.out.println("Volviendo al menú principal...");
        default -> System.out.println("Opción inválida");
      }
    } while (option != 0);
  }
}
