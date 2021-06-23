package temperature;

import temperature.average.*;
import temperature.model.StatisticType;
import temperature.model.Temperature;
import temperature.util.Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageComputationEngine {
  /**
   * Method execute all the average calculation strategies on the provided list of Temperature.
   *
   * @param items #List {@link Temperature}
   * @return result is {@link Map} collection that contains {@link StatisticType} as key and {@link
   *     Double} as value.
   */
  public Map<StatisticType, Double> execution(
      final List<Temperature> items, final List<StatisticType> strategiesToCompute) {
    if (items.isEmpty()) {
      throw new IllegalStateException(
          "Input temperature list is empty, average can not be computed");
    }
    // Sort and filter temperature list using a helper method.
    final List<Temperature> sortedList = Helper.customSort(items);

    return executeStrategy(sortedList, strategiesToCompute);
  }

  /**
   * Method calls the computation strategy for each value of {@link StatisticType} at runtime.
   *
   * @param sortedList List of {@link Temperature}
   * @param strategiesToCompute List of {@link StatisticType}
   * @return result is {@link Map} collection that contains {@link StatisticType} as key and {@link
   *     * Double} as value.
   */
  private Map<StatisticType, Double> executeStrategy(
      final List<Temperature> sortedList, final List<StatisticType> strategiesToCompute) {
    final AverageComputationExecution averageComputationExecution =
        new AverageComputationExecution(sortedList);

    final Map<StatisticType, Double> statsResult = new HashMap<>();
    // Iterate over the strategy list provided by the user and calculate the average as per the
    // reference.
    strategiesToCompute.forEach(
        statisticType -> {
          if (statisticType.equals(StatisticType.MODE)) {
            final AverageComputationStrategy mode = new ModeStatistics();
            statsResult.put(StatisticType.MODE, averageComputationExecution.executeStrategy(mode));
          } else if (statisticType.equals(StatisticType.MEAN)) {
            final AverageComputationStrategy mean = new MeanStatistics();
            statsResult.put(StatisticType.MEAN, averageComputationExecution.executeStrategy(mean));
          } else {
            final AverageComputationStrategy median = new MedianStatistics();
            statsResult.put(
                StatisticType.MEDIAN, averageComputationExecution.executeStrategy(median));
          }
        });
    return statsResult;
  }
}
