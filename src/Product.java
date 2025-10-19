public class Product extends Item {
  // private Categoria categoria;

  public Product(String name, double price) {
    super(name, price);
  }

  @Override
  public String toString() {
    return "ID: " + getId() + " | Nombre: " + getName() + " | Precio: " + getPrice();
  }
}
