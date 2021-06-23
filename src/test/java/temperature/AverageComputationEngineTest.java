package temperature;

import org.junit.Before;
import org.junit.Test;
import temperature.model.StatisticType;
import temperature.model.Temperature;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class AverageComputationEngineTest {
  private AverageComputationEngine averageComputationEngine;

  @Before
  public void setUp() {
    averageComputationEngine = new AverageComputationEngine();
  }

  @Test
  public void calculateAverageWithCorrectData() {
    final List<Temperature> items = new ArrayList<>();
    items.add(new Temperature(17.0));
    items.add(new Temperature(17.0));
    items.add(new Temperature(15.0));
    items.add(new Temperature(23.3));
    items.add(new Temperature(15.0));

    final List<StatisticType> strategiesToCompute =
        Arrays.asList(StatisticType.MEAN, StatisticType.MEDIAN, StatisticType.MODE);

    final Map<StatisticType, Double> statsResult =
        averageComputationEngine.execution(items, strategiesToCompute);
    assertEquals(Double.valueOf(17.46), statsResult.get(StatisticType.MEAN));
    assertEquals(Double.valueOf(17.0), statsResult.get(StatisticType.MEDIAN));
    assertEquals(Double.valueOf(17.0), statsResult.get(StatisticType.MODE));
  }

  @Test
  public void calculateAverageWhenDataIsSame() {
    final List<Temperature> items = new ArrayList<>();
    items.add(new Temperature(15.0));
    items.add(new Temperature(15.0));
    items.add(new Temperature(15.0));
    items.add(new Temperature(15.0));

    final List<StatisticType> strategiesToCompute =
        Arrays.asList(StatisticType.MEAN, StatisticType.MEDIAN, StatisticType.MODE);

    final Map<StatisticType, Double> statsResult =
        averageComputationEngine.execution(items, strategiesToCompute);
    assertEquals(Double.valueOf(15.0), statsResult.get(StatisticType.MEAN));
    assertEquals(Double.valueOf(15.0), statsResult.get(StatisticType.MEDIAN));
    assertEquals(Double.valueOf(15.0), statsResult.get(StatisticType.MODE));
  }

  @Test(expected = IllegalStateException.class)
  public void calculateAverageWhenListIsBlank() {
    final List<Temperature> items = new ArrayList<>(); // blank list

    final List<StatisticType> strategiesToCompute =
        Arrays.asList(StatisticType.MEAN, StatisticType.MEDIAN, StatisticType.MODE);

    averageComputationEngine.execution(items, strategiesToCompute);
  }

  @Test
  public void calculateAverageWhenSomeValuesAreNull() {
    final List<Temperature> items = new ArrayList<>();
    items.add(new Temperature(17.0));
    items.add(null); // value will be filtered out from computation
    items.add(new Temperature(23.3));
    items.add(new Temperature(15.0));

    final List<StatisticType> strategiesToCompute =
        Arrays.asList(StatisticType.MEAN, StatisticType.MEDIAN, StatisticType.MODE);

    final Map<StatisticType, Double> statsResult =
        averageComputationEngine.execution(items, strategiesToCompute);
    assertEquals(Double.valueOf(18.43), statsResult.get(StatisticType.MEAN));
    assertEquals(Double.valueOf(17.0), statsResult.get(StatisticType.MEDIAN));
    assertEquals(Double.valueOf(0.0), statsResult.get(StatisticType.MODE));
  }

  @Test
  public void calculateModeWithNoRepetitiveNumber() {
    final List<Temperature> items = new ArrayList<>();
    items.add(new Temperature(17.0));
    items.add(new Temperature(15.0));
    items.add(new Temperature(23.3));
    items.add(new Temperature(25.0));

    final List<StatisticType> strategiesToCompute = Collections.singletonList(StatisticType.MODE);

    final Map<StatisticType, Double> statsResult =
        averageComputationEngine.execution(items, strategiesToCompute);
    assertEquals(Double.valueOf(0.0), statsResult.get(StatisticType.MODE));
  }
}
