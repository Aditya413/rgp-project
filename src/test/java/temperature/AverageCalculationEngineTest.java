package temperature;

import org.junit.Before;
import org.junit.Test;
import temperature.model.StatisticType;
import temperature.model.Temperature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AverageCalculationEngineTest {
  private AverageCalculationEngine averageCalculationEngine;

  @Before
  public void setUp() {
    averageCalculationEngine = new AverageCalculationEngine();
  }

  @Test
  public void CalculateAverageWithCorrectData() {
    final List<Temperature> items = new ArrayList<>();
    items.add(new Temperature(17.0));
    items.add(new Temperature(15.0));
    items.add(new Temperature(23.3));
    items.add(new Temperature(15.0));

    final Map<StatisticType, Double> statsResult = averageCalculationEngine.execution(items);
    assertEquals(Double.valueOf(17.58), statsResult.get(StatisticType.MEAN));
    assertEquals(Double.valueOf(23.5), statsResult.get(StatisticType.MEDIAN));
  }

  @Test
  public void CalculateAverageWhenDataIsSame() {
    final List<Temperature> items = new ArrayList<>();
    items.add(new Temperature(15.0));
    items.add(new Temperature(15.0));
    items.add(new Temperature(15.0));
    items.add(new Temperature(15.0));

    final Map<StatisticType, Double> statsResult = averageCalculationEngine.execution(items);
    assertEquals(Double.valueOf(15.0), statsResult.get(StatisticType.MEAN));
    assertEquals(Double.valueOf(22.5), statsResult.get(StatisticType.MEDIAN));
  }

  @Test(expected = IllegalStateException.class)
  public void CalculateAverageWhenListIsBlank() {
    final List<Temperature> items = new ArrayList<>(); // blank list

    averageCalculationEngine.execution(items);
  }

  @Test
  public void CalculateAverageWhenSomeValuesAreNull() {
    final List<Temperature> items = new ArrayList<>();
    items.add(new Temperature(17.0));
    items.add(null); // value will be filtered out from computation
    items.add(new Temperature(23.3));
    items.add(new Temperature(15.0));

    final Map<StatisticType, Double> statsResult = averageCalculationEngine.execution(items);
    assertEquals(Double.valueOf(18.43), statsResult.get(StatisticType.MEAN));
    assertEquals(Double.valueOf(17.0), statsResult.get(StatisticType.MEDIAN));
  }
}
