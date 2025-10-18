import java.util.List;

public class ProductService {
  private ProductRepository productRepo;

  public ProductService(ProductRepository productRepo) {
    this.productRepo = productRepo;
  }

  public void createProduct() {
    String name = ConsoleInput.readString("Nombre: ");
    double price = ConsoleInput.readInt("Precio: ");

    Product newProduct = new Product(name, price);
    productRepo.create(newProduct);

    System.out.println("Producto creado.");
    System.out.println(newProduct);
  }

  public boolean getAllProducts() {
    List<Product> products = productRepo.getAll();

    if (isProductsListEmpty(products))
      return false;

    System.out.println("Lista de productos:");
    printProducts(products);
    return true;
  }

  public void getByName() {
    if (!getAllProducts())
      return;

    String nameToFind = ConsoleInput.readString("Nombre del producto a buscar:");
    List<Product> productsFound = productRepo.findByName(nameToFind);

    if (productsFound.isEmpty()) {
      System.out.println("No se encontraron productos con el nombre: " + nameToFind);
      return;
    }

    System.out.println("Producto/s encontrado/s:");
    printProducts(productsFound);
  }

  public void updateProduct() {
    if (!getAllProducts())
      return;

    int idToFind = ConsoleInput.readInt("Id del producto a actualizar:");

    productRepo.findById(idToFind).ifPresentOrElse(product -> {
      String newName = ConsoleInput.readString("Nuevo nombre: ");
      product.setName(newName);

      double newPrice = ConsoleInput.readDouble("Nuevo precio: ");
      product.setPrice(newPrice);

      System.out.println("Producto actualizado: " + product);
    }, () -> {
      System.out.println("Producto no encontrado.");
    });

  }

  public void deleteProduct() {
    if (!getAllProducts())
      return;

    int idToFind = ConsoleInput.readInt("Id del producto a eliminar:");

    productRepo.findById(idToFind).ifPresentOrElse(product -> {
      product.setDeleted(true);

      System.out.println("Producto eliminado: " + product);
    }, () -> {
      System.out.println("Producto no encontrado.");
    });
  }

  private boolean isProductsListEmpty(List<Product> products) {
    if (products.isEmpty()) {
      System.out.println("No hay productos registrados.");
      return true;
    }

    return false;
  }

  private void printProducts(List<Product> products) {
    products.forEach(p -> System.out.println(p));
  }
}
