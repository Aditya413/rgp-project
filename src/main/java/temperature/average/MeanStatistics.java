package temperature.average;

import temperature.model.Temperature;

import java.util.List;

public class MeanStatistics implements AverageComputationStrategy {
  @Override
  public double calculateStatistics(final List<Temperature> temperature) {
    final double mean =
        temperature.stream().mapToDouble(Temperature::getCelsiusTemp).sum() / temperature.size();
    return Math.round(mean * 100.0) / 100.0;
  }
}
