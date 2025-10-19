public class User {
  private int id;
  private String name;
  private String email;
  private boolean isActive = false;

  private static int nextId = 1;

  public User(String name, String email) {
    this.id = nextId++;
    this.name = name;
    this.email = email;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(boolean isActive) {
    this.isActive = isActive;
  }

  @Override
  public String toString() {
    return "ID: " + id + " | Nombre: " + name + " | Email: " + email;
  }
}
