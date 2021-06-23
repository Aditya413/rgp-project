package util;

import org.junit.Test;
import temperature.model.Temperature;
import temperature.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HelperTest {

  @Test
  public void sortListOfTemperature() {
    final List<Temperature> unsortedList = new ArrayList<>();
    unsortedList.add(new Temperature(17.0));
    unsortedList.add(new Temperature(15.0));
    unsortedList.add(new Temperature(16.0));

    // check the temperature value of first element which will prove that this is a sorted list
    final double firstvalue = Helper.customSort(unsortedList).get(0).getCelsiusTemp();
    assertEquals(15.0, firstvalue, 0);
  }

  @Test
  public void filterNullOutOfTemperatureList() {
    final List<Temperature> unsortedList = new ArrayList<>();
    unsortedList.add(new Temperature(17.0));
    unsortedList.add(null); // this is will be filtered out
    unsortedList.add(new Temperature(16.0));

    // Sort and filter out the null values from the list
    assertEquals(
        Arrays.asList(new Temperature(16.0), new Temperature(17.0)),
        Helper.customSort(unsortedList));
  }
}
