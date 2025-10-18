public class Product extends BaseEntity {
  private double price;
  // private Categoria categoria;

  private static int nextId = 0;

  public Product(String name, double price) {
    super(nextId, name);
    this.price = price;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
