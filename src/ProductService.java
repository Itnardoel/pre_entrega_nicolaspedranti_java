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
}
