import java.util.List;

public class CategoryService {
  private final CategoryRepository categoryRepo;
  private final ItemRepository itemRepo;

  public CategoryService(CategoryRepository categoryRepo, ItemRepository itemRepo) {
    this.categoryRepo = categoryRepo;
    this.itemRepo = itemRepo;
  }

  public void createCategory() {
    String name = ConsoleInput.readString("Nombre de la nueva categoría: ");
    Category newCategory = new Category(name);
    categoryRepo.create(newCategory);
    System.out.println("Categoría creada -> " + newCategory);
  }

  public List<Category> getAllCategories() {
    List<Category> categories = categoryRepo.getAll();

    if (isCategoriesEmpty(categories))
      return null;

    System.out.println("Lista de categorías:");
    printItems(categories);
    return categories;
  }

  public void getByName() {
    if (getAllCategories() == null)
      return;

    String nameToFind = ConsoleInput.readString("Nombre de la categoría a buscar:");
    List<Category> itemsFound = categoryRepo.findByName(nameToFind);

    if (itemsFound.isEmpty()) {
      System.out.println("No se encontraron categorías con el nombre: " + nameToFind);
      return;
    }

    System.out.println("Categoría/s encontrada/s:");
    printItems(itemsFound);
  }

  public void updateCategory() {
    if (getAllCategories() == null)
      return;

    int idToFind = ConsoleInput.readInt("Id de la categoría a modificar:");



    categoryRepo.findById(idToFind).ifPresentOrElse(category -> {
      String newName = ConsoleInput.readString("Nuevo nombre: ");
      category.setName(newName);

      System.out.println("Categoría actualizada: " + category);
    }, () -> {
      System.out.println("Categoría no encontrada.");
    });
  }

  public void deleteCategory() {
    if (getAllCategories() == null)
      return;

    int idToFind = ConsoleInput.readInt("Id de la categoría a eliminar:");

    List<Product> products =
        itemRepo.getAll().stream().filter(i -> i instanceof Product).map(i -> (Product) i).toList();

    categoryRepo.findById(idToFind).ifPresentOrElse(category -> {
      boolean activeProductWithCategory =
          products.stream().anyMatch(p -> p.getCategory().equals(category));

      if (activeProductWithCategory) {
        System.out.println("No se puede eliminar la categoría con productos existentes.");
        return;
      }

      category.setIsDeleted(true);

      System.out.println("Categoría eliminada: " + category);
    }, () -> {
      System.out.println("Categoría no encontrada.");
    });
  }

  private boolean isCategoriesEmpty(List<Category> categories) {
    if (categories.isEmpty()) {
      System.out.println("No hay categorías registradas.");
      return true;
    }

    return false;
  }

  private void printItems(List<Category> categories) {
    categories.forEach(c -> System.out.println(c));
  }
}
