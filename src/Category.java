public class Category {
  private int id;
  private String name;
  private boolean isDeleted = false;

  private static int nextId = 1;

  public Category(String name) {
    this.id = nextId++;
    this.name = name;
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

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean deleted) {
    this.isDeleted = deleted;
  }

  @Override
  public String toString() {
    return "ID: " + id + " | Nombre: " + name;
  }
}
