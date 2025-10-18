
public interface CrudRepository<T> {
  void create(T entity);

  void getAll();

  void findByName();

  void update();

  void delete();

}
