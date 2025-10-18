import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements CrudRepository<Product> {
  private final List<Product> products = new ArrayList<>();

  @Override
  public void create(Product p) {
    products.add(p);
  };

  @Override
  public List<Product> getAll() {
    return products.stream().filter(p -> !p.isDeleted()).toList();
  };

  @Override
  public Optional<Product> findById(int id) {
    return products.stream().filter(p -> p.getId() == id && !p.isDeleted()).findFirst();
  };

  @Override
  public List<Product> findByName(String name) {
    return products.stream().filter(p -> p.getName().equals(name) && !p.isDeleted()).toList();
  };

  @Override
  public void update(int id) {
    // No es necesario actualizar en memoria, el objeto ya fue modificado por referencia.
    // Método preparado para futuras implementaciones con base de datos u otro almacenamiento
    // persistente.

    // findById(id).ifPresent(existing -> {
    // existing.setName(p.getName());
    // existing.setPrice(p.getPrice());
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
