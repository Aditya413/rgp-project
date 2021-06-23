package temperature.average;

import temperature.model.Temperature;

import java.util.List;

public class MedianStatistics implements AverageComputationStrategy {
  @Override
  public double calculateStatistics(final List<Temperature> temperature) {
    final int middle = temperature.size() / 2;
    if (temperature.size() % 2 == 0) {
      // size is even take average temp
      final Temperature middleValue = temperature.get(middle - 1);
      final Temperature middleValue2 = temperature.get(middle);
      final double median = middleValue.getCelsiusTemp() + middleValue2.getCelsiusTemp() / 2.0;
      return Math.round(median * 100.0) / 100.0; // Round to at most 2 decimal places
    }
    return Math.round(temperature.get(middle).getCelsiusTemp() * 100.0) / 100.0;
  }
}
