public class Product extends Item {
  private Category category;

  public Product(String name, double price, Category category) {
    super(name, price);
    this.category = category;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return super.toString() + " | Categoría: " + category.getName();
  }
}
