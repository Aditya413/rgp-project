package temperature.average;

import temperature.model.Temperature;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implement {@link AverageComputationStrategy} and override the computation logic to calculate the
 * mode.
 */
public class ModeStatistics implements AverageComputationStrategy {
  /**
   * Mode is the number which has the highest occurrence in the list.
   *
   * <p>NOTE: We are not calculating mode for grouped data and if there is no repetitive occurrence
   * of the number, mode will be 0 as there is no mode.
   *
   * @param temperature #List {@link Temperature}
   * @return mode
   */
  @Override
  public double calculateStatistics(final List<Temperature> temperature) {
    final Map<Double, Long> countFrequencies =
        temperature.stream()
            .collect(Collectors.groupingBy(Temperature::getCelsiusTemp, Collectors.counting()));

    final long maxFrequency =
        countFrequencies.values().stream().mapToLong(count -> count).max().orElse(-1);
    if (maxFrequency != 1) {
      final Optional<Double> mode =
          countFrequencies.entrySet().stream()
              .filter(tuple -> tuple.getValue() == maxFrequency)
              .map(Map.Entry::getKey)
              .findFirst();
      return mode.orElse(0.0);
    }

    return 0.0;
  }
}
