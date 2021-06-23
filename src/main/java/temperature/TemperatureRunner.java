package temperature;

import org.springframework.boot.CommandLineRunner;
import temperature.model.Temperature;

import java.util.ArrayList;
import java.util.List;

public class TemperatureRunner implements CommandLineRunner {

  @Override
  public void run(final String... args) {
    final List<Temperature> items = new ArrayList<>();
    items.add(new Temperature(17.0));
    items.add(new Temperature(15.0));
    items.add(new Temperature(23.3));
    items.add(new Temperature(15.0));

    final AverageCalculationEngine averageCalculationEngine = new AverageCalculationEngine();
    averageCalculationEngine.execution(items);
  }
}
