import java.util.ArrayList;
import java.util.List;

public class OrderService {
  private final OrderRepository orderRepo;
  private final UserService userService;
  private final ItemService itemService;

  public OrderService(OrderRepository orderRepo, UserService userService, ItemService itemService) {
    this.orderRepo = orderRepo;
    this.userService = userService;
    this.itemService = itemService;
  }

  public void createOrder() {
    List<User> users = userService.getAllUsers();

    if (users == null) {
      System.out.println("No se puede crear un pedido sin usuario válido.");
      return;
    }

    User orderUser = null;

    try {
      int userId = ConsoleInput.readInt("Id del usuario:");
      orderUser = users.get(userId - 1);
    } catch (Exception e) {
      System.out.println("Opción inválida.");
      return;
    }

    List<Item> items = itemService.getAllItems();

    if (items == null) {
      System.out.println("No se puede crear un pedido sin productos.");
      return;
    }

    List<Item> orderItems = new ArrayList<>();
    int addMoreItems = 0;

    do {
      int selectedItemId = ConsoleInput.readInt("Id del producto o servicio: ");

      try {
        Item itemToAdd = items.get(selectedItemId - 1);
        orderItems.add(itemToAdd);
      } catch (Exception e) {
        System.out.println("Opción inválida.");
        continue;
      }

      addMoreItems = ConsoleInput.readInt("¿Agregar otro producto? 1 = Sí | 2 = No: ");

    } while (addMoreItems != 2);

    Order newOrder = new Order(orderUser, orderItems);
    orderRepo.create(newOrder);

    System.out.println("Pedido creado.");
    System.out.println(newOrder);
  }

  public List<Order> getAllOrders() {
    List<Order> orders = orderRepo.getAll();

    if (isOrdersEmpty(orders))
      return null;

    System.out.println("\nLista de pedidos:");
    printItems(orders);
    return orders;
  }

  public void deleteOrder() {
    if (getAllOrders() == null)
      return;

    int idToFind = ConsoleInput.readInt("Id del pedido a eliminar:");

    orderRepo.findById(idToFind).ifPresentOrElse(order -> {
      order.setActive(false);

      System.out.println("Pedido eliminado: " + order);
    }, () -> {
      System.out.println("Usuario no encontrado.");
    });
  }

  private boolean isOrdersEmpty(List<Order> orders) {
    if (orders.isEmpty()) {
      System.out.println("No hay pedidos registrados.");
      return true;
    }

    return false;
  }

  private void printItems(List<Order> orders) {
    orders.forEach(o -> System.out.println(o));
  }
}
