import java.util.List;

public class UserService {
  private final UserRepository userRepo;

  public UserService(UserRepository userRepository) {
    this.userRepo = userRepository;
  }

  public void createUser() {
    String name = ConsoleInput.readString("Nombre: ");
    String email = ConsoleInput.readString("Email: ");

    while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
      System.out.println("Email inválido.");
      email = ConsoleInput.readString("Email: ");
    }

    User newUser = new User(name, email);
    userRepo.create(newUser);

    System.out.println("Categoría creada -> " + newUser);
  }

  public List<User> getAllUsers() {
    List<User> users = userRepo.getAll();

    if (isUsersEmpty(users))
      return null;

    System.out.println("Lista de usuarios:");
    printItems(users);
    return users;
  }

  public void getByName() {
    if (getAllUsers() == null)
      return;

    String nameToFind = ConsoleInput.readString("Nombre del usuario a buscar:");
    List<User> usersFound = userRepo.findByName(nameToFind);

    if (usersFound.isEmpty()) {
      System.out.println("No se encontraron usuarios con el nombre: " + nameToFind);
      return;
    }

    System.out.println("Usuario/s encontrado/s:");
    printItems(usersFound);
  }

  public void updateUser() {
    if (getAllUsers() == null)
      return;

    int idToFind = ConsoleInput.readInt("Id del usuario a modificar:");

    userRepo.findById(idToFind).ifPresentOrElse(user -> {
      String newName = ConsoleInput.readString("Nuevo nombre: ");
      user.setName(newName);
      String newEmail = ConsoleInput.readString("Nuevo email: ");
      user.setEmail(newEmail);

      System.out.println("Usuario actualizado: " + user);
    }, () -> {
      System.out.println("Usuario no encontrado.");
    });
  }

  public void deleteUser() {
    if (getAllUsers() == null)
      return;

    int idToFind = ConsoleInput.readInt("Id del usuario a eliminar:");

    userRepo.findById(idToFind).ifPresentOrElse(user -> {
      user.setIsActive(true);

      System.out.println("Usuario eliminado: " + user);
    }, () -> {
      System.out.println("Usuario no encontrado.");
    });
  }

  private boolean isUsersEmpty(List<User> users) {
    if (users.isEmpty()) {
      System.out.println("No hay usuarios registradas.");
      return true;
    }

    return false;
  }

  private void printItems(List<User> users) {
    users.forEach(u -> System.out.println(u));
  }
}
