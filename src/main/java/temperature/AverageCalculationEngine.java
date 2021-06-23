package temperature;

import temperature.average.*;
import temperature.model.StatisticType;
import temperature.model.Temperature;
import temperature.util.Helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageCalculationEngine {

  public Map<StatisticType, Double> execution(final List<Temperature> items) {
    if (items.isEmpty()) {
      throw new IllegalStateException(
          "Input temperature list is empty, average can not be computed");
    }
    // Sort and filter temperature list
    final List<Temperature> sortedList = Helper.customSort(items);
    final List<StatisticType> strategiesToCompute =
        Arrays.asList(StatisticType.MEAN, StatisticType.MEDIAN, StatisticType.MODE);

    return executeStrategy(sortedList, strategiesToCompute);
  }

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
