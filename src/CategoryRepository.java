import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryRepository implements CrudRepository<Category> {
  private final List<Category> categories = new ArrayList<>();

  @Override
  public void create(Category c) {
    categories.add(c);
  };

  @Override
  public List<Category> getAll() {
    return categories.stream().filter(c -> !c.isDeleted()).toList();
  };

  @Override
  public Optional<Category> findById(int id) {
    return categories.stream().filter(c -> c.getId() == id && !c.isDeleted()).findFirst();
  };

  @Override
  public List<Category> findByName(String name) {
    return categories.stream()
        .filter(c -> c.getName().toLowerCase().equals(name.toLowerCase()) && !c.isDeleted())
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
