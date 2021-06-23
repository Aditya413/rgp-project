package temperature.average;

import temperature.model.Temperature;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ModeStatistics implements AverageComputationStrategy {
  @Override
  public double calculateStatistics(final List<Temperature> temperature) {
    final Map<Temperature, Long> countFrequencies =
        temperature.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    final long maxFrequency =
        countFrequencies.values().stream().mapToLong(count -> count).max().orElse(-1);

    final Temperature mode =
        Objects.requireNonNull(
            countFrequencies.entrySet().stream()
                .filter(tuple -> tuple.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null));
    return mode.getCelsiusTemp();
  }
}
