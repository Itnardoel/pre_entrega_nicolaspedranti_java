import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements CrudRepository<User> {
  private final List<User> users = new ArrayList<>();

  @Override
  public void create(User user) {
    users.add(user);
  };

  @Override
  public List<User> getAll() {
    return users.stream().filter(i -> !i.getIsActive()).toList();
  };

  @Override
  public Optional<User> findById(int id) {
    return users.stream().filter(i -> i.getId() == id && !i.getIsActive()).findFirst();
  };

  @Override
  public List<User> findByName(String name) {
    return users.stream()
        .filter(i -> i.getName().toLowerCase().equals(name.toLowerCase()) && !i.getIsActive())
        .toList();
  };

  @Override
  public void update(int id) {
    // No es necesario actualizar en memoria, el objeto ya fue modificado por referencia.
    // Método preparado para futuras implementaciones con base de datos u otro almacenamiento
    // persistente.
  };

  @Override
  public void delete(int id) {
    // No es necesario actualizar en memoria, el objeto ya fue modificado por referencia.
    // Método preparado para futuras implementaciones con base de datos u otro almacenamiento
    // persistente.
  };
}
