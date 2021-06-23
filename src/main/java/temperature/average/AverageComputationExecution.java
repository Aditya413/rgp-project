package temperature.average;

import temperature.model.Temperature;

import java.util.List;

/**
 * Object of this class is created using the List of {@link Temperature} and it execute the
 * computation according to the strategy argument which is decided at the runtime.
 */
public class AverageComputationExecution {
  private final List<Temperature> temperatures;

  public AverageComputationExecution(final List<Temperature> temperatures) {
    this.temperatures = temperatures;
  }

  /**
   * Execute the computation strategy according to the object of implementation class object which
   * is hold in the reference of parent interface class {@link AverageComputationStrategy} at
   * runtime and call the overridden from that particular class.
   *
   * @param averageComputationStrategy
   * @return
   */
  public double executeStrategy(final AverageComputationStrategy averageComputationStrategy) {
    return averageComputationStrategy.calculateStatistics(temperatures);
  }
}
