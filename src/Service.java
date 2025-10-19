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
    return super.toString() + " | Duración en horas: " + durationInHours;
  }
}
