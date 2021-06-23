package temperature.average;

import temperature.model.Temperature;

import java.util.List;

public interface AverageComputationStrategy {
  double calculateStatistics(final List<Temperature> temperature);
}
