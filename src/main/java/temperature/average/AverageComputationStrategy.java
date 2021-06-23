package temperature.average;

import temperature.model.Temperature;

import java.util.List;

/**
 * Implementation class have precise control over where they can implement the method and provide
 * the logic of calculation
 *
 * @see MeanStatistics
 * @see MedianStatistics
 * @see ModeStatistics
 */
public interface AverageComputationStrategy {
  /**
   * Calculate average of the list according to the implementation.
   *
   * @param temperature #List {@link Temperature}
   * @return average of type {@link double}
   */
  double calculateStatistics(final List<Temperature> temperature);
}
