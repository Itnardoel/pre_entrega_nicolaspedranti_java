
public interface CrudRepository<T> {
  void create();

  void getAll();

  void findByName();

  void update();

  void delete();

}
