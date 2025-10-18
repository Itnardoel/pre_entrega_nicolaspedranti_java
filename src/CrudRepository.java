import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
  void create(T entity);

  List<T> getAll();

  Optional<T> findById(int id);

  List<T> findByName(String name);

  void update(int id);

  void delete(int id);
}
