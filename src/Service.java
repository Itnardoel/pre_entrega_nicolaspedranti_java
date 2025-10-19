public class Service extends Item {
  private int durationInHours;

  public Service(String name, double price, int durationInHours) {
    super(name, price);
    this.durationInHours = durationInHours;
  }

  public int getDurationInHours() {
    return durationInHours;
  }

  public void setDurationInHours(int durationInHours) { // Setter
    this.durationInHours = durationInHours;
  }

  @Override
  public String toString() {
    return "ID: " + getId() + " | Nombre: " + getName() + " | Precio: " + getPrice()
        + " | Duración en horas: " + durationInHours;
  }
}
