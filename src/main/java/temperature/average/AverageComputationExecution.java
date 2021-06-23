package temperature.average;

import temperature.model.Temperature;

import java.util.List;

public class AverageComputationExecution {
  private final List<Temperature> temperatures;

  public AverageComputationExecution(final List<Temperature> temperatures) {
    this.temperatures = temperatures;
  }

  public double executeStrategy(final AverageComputationStrategy averageComputationStrategy) {
    return averageComputationStrategy.calculateStatistics(temperatures);
  }
}
