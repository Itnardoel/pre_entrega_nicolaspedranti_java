import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements CrudRepository<Product> {
  private final List<Product> products = new ArrayList<>();

  @Override
  public void create() {
    String name = ConsoleInput.readString("Nombre: ");
    double price = ConsoleInput.readInt("Precio: ");
    products.add(new Product(name, price));
  };

  @Override
  public void getAll() {
    System.out.println("Not implemented.");
  };

  @Override
  public void findByName() {
    System.out.println("Not implemented.");
  };

  @Override
  public void update() {
    System.out.println("Not implemented.");
  };

  @Override
  public void delete() {
    System.out.println("Not implemented.");
  };
}
