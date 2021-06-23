package temperature.average;

import temperature.model.Temperature;

import java.util.List;
/**
 * Implement {@link AverageComputationStrategy} and override the computation logic to calculate the
 * median.
 */
public class MedianStatistics implements AverageComputationStrategy {
  /**
   * The basic formula to calculate median are based on two conditions.
   *
   * <p>1. if the total number of temperature value is an even number, median will be average of two
   * middle values.
   *
   * <p>2. if the total number of temperature value is an odd number, median will be middle values.
   *
   * <p>NOTE. Parameter list is a sorted list.
   *
   * @param temperature #List {@link Temperature}
   * @return median
   */
  @Override
  public double calculateStatistics(final List<Temperature> temperature) {
    double median = temperature.get(temperature.size() / 2).getCelsiusTemp();
    if (temperature.size() % 2 == 0)
      median = (median + temperature.get(temperature.size() / 2 - 1).getCelsiusTemp()) / 2;
    return Math.round(median * 100.0) / 100.0;
  }
}
