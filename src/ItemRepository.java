import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemRepository implements CrudRepository<Item> {
  private final List<Item> items = new ArrayList<>();

  @Override
  public void create(Item item) {
    items.add(item);
  };

  @Override
  public List<Item> getAll() {
    return items.stream().filter(i -> !i.isDeleted()).toList();
  };

  @Override
  public Optional<Item> findById(int id) {
    return items.stream().filter(i -> i.getId() == id && !i.isDeleted()).findFirst();
  };

  @Override
  public List<Item> findByName(String name) {
    return items.stream()
        .filter(i -> i.getName().toLowerCase().equals(name.toLowerCase()) && !i.isDeleted())
        .toList();
  };

  @Override
  public void update(int id) {
    // No es necesario actualizar en memoria, el objeto ya fue modificado por referencia.
    // Método preparado para futuras implementaciones con base de datos u otro almacenamiento
    // persistente.

    // findById(id).ifPresent(existing -> {
    // existing.setName(i.getName());
    // existing.setPrice(i.getPrice());
    // });
  };

  @Override
  public void delete(int id) {
    // No es necesario actualizar en memoria, el objeto ya fue modificado por referencia.
    // Método preparado para futuras implementaciones con base de datos u otro almacenamiento
    // persistente.

    // findById(id).ifPresent(existing -> {
    // existing.setDeleted(true);
    // });
  };
}
