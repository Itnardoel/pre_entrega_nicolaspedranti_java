import java.util.List;

public class ItemService {
  private final ItemRepository itemRepo;
  private final CategoryService categoryService;

  public ItemService(ItemRepository itemRepo, CategoryService categoryService) {
    this.itemRepo = itemRepo;
    this.categoryService = categoryService;
  }

  public void createItem() {
    System.out.println("1) Crear Producto");
    System.out.println("2) Crear Servicio");
    int option = ConsoleInput.readInt("Opción: ");

    if (option == 1) {
      String name = ConsoleInput.readString("Nombre: ");
      double price = ConsoleInput.readDouble("Precio: ");

      List<Category> categories = categoryService.getAllCategories();

      if (categories != null) {
        int categoryId = ConsoleInput.readInt("Elegí id de categoría: ");
        try {
          Category categorySelected = categories.get(categoryId - 1);
          Product newProduct = new Product(name, price, categorySelected);
          itemRepo.create(newProduct);

          System.out.println("Producto creado.");
          System.out.println(newProduct);
        } catch (Exception e) {
          System.out.println("Categoría inválida.");
        }
      }
    } else if (option == 2) {
      String name = ConsoleInput.readString("Nombre: ");
      double price = ConsoleInput.readDouble("Precio: ");
      int durationInHours = ConsoleInput.readInt("Duración (horas): ");

      Service newService = new Service(name, price, durationInHours);
      itemRepo.create(newService);

      System.out.println("Servicio creado.");
      System.out.println(newService);

    } else {
      System.out.println("Opción inválida");
    }
  }

  public boolean getAllItems() {
    List<Item> items = itemRepo.getAll();

    if (isItemsEmpty(items))
      return false;

    System.out.println("Lista de items:");
    printItems(items);
    return true;
  }

  public void getByName() {
    if (!getAllItems())
      return;

    String nameToFind = ConsoleInput.readString("Nombre del item a buscar:");
    List<Item> itemsFound = itemRepo.findByName(nameToFind);

    if (itemsFound.isEmpty()) {
      System.out.println("No se encontraron items con el nombre: " + nameToFind);
      return;
    }

    System.out.println("Item/s encontrado/s:");
    printItems(itemsFound);
  }

  public void updateItem() {
    if (!getAllItems())
      return;

    int idToFind = ConsoleInput.readInt("Id del item a actualizar:");

    itemRepo.findById(idToFind).ifPresentOrElse(item -> {
      String newName = ConsoleInput.readString("Nuevo nombre: ");
      double newPrice = ConsoleInput.readDouble("Nuevo precio: ");

      if (item instanceof Product) {
        List<Category> categories = categoryService.getAllCategories();
        int categoryId = ConsoleInput.readInt("Elegí id de categoría: ");

        try {
          Category categorySelected = categories.get(categoryId - 1);
          item.setName(newName);
          item.setPrice(newPrice);
          ((Product) item).setCategory(categorySelected);

          System.out.println("Producto actualizado: " + item);
        } catch (Exception e) {
          System.out.println("Categoría inválida.");
        }
      }

      if (item instanceof Service) {
        int newDuration = ConsoleInput.readInt("Nueva duración (horas): ");
        item.setName(newName);
        item.setPrice(newPrice);
        ((Service) item).setDurationInHours(newDuration);
        System.out.println("Servicio actualizado: " + item);
      }
    }, () -> {
      System.out.println("Item no encontrado.");
    });

  }

  public void deleteItem() {
    if (!getAllItems())
      return;

    int idToFind = ConsoleInput.readInt("Id del item a eliminar:");

    itemRepo.findById(idToFind).ifPresentOrElse(item -> {
      item.setDeleted(true);

      System.out.println("Item eliminado: " + item);
    }, () -> {
      System.out.println("Item no encontrado.");
    });
  }

  private boolean isItemsEmpty(List<Item> items) {
    if (items.isEmpty()) {
      System.out.println("No hay items registrados.");
      return true;
    }

    return false;
  }

  private void printItems(List<Item> items) {
    items.forEach(i -> System.out.println(i));
  }
}
