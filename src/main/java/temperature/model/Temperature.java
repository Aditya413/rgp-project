package temperature.model;

import java.util.Objects;

public class Temperature implements Comparable<Temperature> {

  private double celsiusTemp;

  public Temperature() {}

  public Temperature(final double celsiusTemp) {
    this.celsiusTemp = celsiusTemp;
  }

  public double getCelsiusTemp() {
    return celsiusTemp;
  }

  public void setCelsiusTemp(final int celsiusTemp) {
    this.celsiusTemp = celsiusTemp;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Temperature that = (Temperature) o;
    return Double.compare(that.celsiusTemp, celsiusTemp) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(celsiusTemp);
  }

  @Override
  public int compareTo(final Temperature temperature) {
    if (this.getCelsiusTemp() < temperature.getCelsiusTemp()) return -1;
    else if (this.getCelsiusTemp() > temperature.getCelsiusTemp()) return 1;
    return 0;
  }
}
