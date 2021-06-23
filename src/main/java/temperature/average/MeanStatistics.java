package temperature.average;

import temperature.model.Temperature;

import java.util.List;

/**
 * Implement {@link AverageComputationStrategy} and override the computation logic to calculate the
 * mean.
 */
public class MeanStatistics implements AverageComputationStrategy {
  /**
   * The basic formula to calculate mean is (sum of all temp)/ (total number of temperature in the
   * list).
   *
   * <p>NOTE. Parameter list is a sorted list.
   *
   * @param temperature #List {@link Temperature}
   * @return mean
   */
  @Override
  public double calculateStatistics(final List<Temperature> temperature) {
    final double mean =
        temperature.stream().mapToDouble(Temperature::getCelsiusTemp).sum() / temperature.size();
    return Math.round(mean * 100.0) / 100.0;
  }
}
