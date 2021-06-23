package temperature.model;

public class Temperature {

    private double celsiusTemp;

    public Temperature() {
    }

    public Temperature(double celsiusTemp) {
        this.celsiusTemp = celsiusTemp;
    }

    public double getCelsiusTemp() {
        return celsiusTemp;
    }

    public void setCelsiusTemp(int celsiusTemp) {
        this.celsiusTemp = celsiusTemp;
    }

}
