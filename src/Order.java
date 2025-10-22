import java.time.LocalDateTime;
import java.util.List;

public class Order {
  private int id;
  private User user;
  private List<Item> items;
  private boolean active;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private static int nextId = 1;

  public Order(User user, List<Item> items) {
    this.id = nextId++;
    this.user = user;
    this.items = items;
    this.active = true;
    this.createdAt = LocalDateTime.now();
    this.updatedAt = null;
  }

  public int getId() {
    return id;
  }

  public User getUser() {
    return user;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setProductos(List<Item> items) {
    this.items = items;
    this.updatedAt = LocalDateTime.now();
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
    this.updatedAt = LocalDateTime.now();
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public String toString() {
    return "\nPedido #" + id + "\nUsuario: " + user.getName() + " - " + user.getEmail()
        + "\nProductos: " + items.size() + "\nTotal: $"
        + items.stream().mapToDouble(item -> item.getPrice()).sum() + "\nActivo: "
        + (active ? "Sí" : "No") + "\nCreado: " + createdAt
        + (updatedAt != null ? "\nActualizado: " + updatedAt : "");
  }
}
