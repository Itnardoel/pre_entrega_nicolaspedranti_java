public abstract class Item {
  private int id;
  private String name;
  private double price;
  private boolean isDeleted = false;

  private static int nextId = 1;

  protected Item(String name, double price) {
    this.id = nextId++;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean deleted) {
    this.isDeleted = deleted;
  }

  @Override
  public String toString() {
    return "ID: " + id + " | Nombre: " + name + " | Precio: " + price;
  }
}
