package temperature;

import org.springframework.boot.CommandLineRunner;
import temperature.model.StatisticType;
import temperature.model.Temperature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TemperatureRunner implements CommandLineRunner {

  @Override
  public void run(final String... args) {
    // If needed we can take this as an input from the user, according to their requirement.
    final List<Temperature> items = new ArrayList<>();
    items.add(new Temperature(17.0));
    items.add(new Temperature(15.0));
    items.add(new Temperature(23.3));
    items.add(new Temperature(15.0));

    // This is the entry point for our calculation logic.
    final AverageComputationEngine averageComputationEngine = new AverageComputationEngine();

    // If needed we can take this as an input from the user, according to their requirement.
    final List<StatisticType> strategiesToCompute =
        Arrays.asList(StatisticType.MEAN, StatisticType.MEDIAN, StatisticType.MODE);

    final Map<StatisticType, Double> staticsResult =
        averageComputationEngine.execution(items, strategiesToCompute);

    // Just printing the result for the ease of the User/Reviewer
    staticsResult.forEach(
        (statisticType, value) -> {
          System.out.println("The result for " + statisticType.name() + " is : " + value);
        });
  }
}
