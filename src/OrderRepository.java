import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {
  private final List<Order> orders = new ArrayList<>();

  public void create(Order o) {
    orders.add(o);
  }

  public List<Order> getAll() {
    return orders;
  }

  public Optional<Order> findById(int id) {
    return orders.stream().filter(o -> o.getId() == id).findFirst();
  }

  public void update(int id) {
    // No es necesario actualizar en memoria, el objeto ya fue modificado por referencia.
    // Método preparado para futuras implementaciones con base de datos u otro almacenamiento
    // persistente.
  }

  public void delete(int id) {
    // No es necesario actualizar en memoria, el objeto ya fue modificado por referencia.
    // Método preparado para futuras implementaciones con base de datos u otro almacenamiento
    // persistente.
  }
}
