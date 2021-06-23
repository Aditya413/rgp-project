package temperature.util;

import temperature.model.Temperature;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Helper {

  private Helper() {
    //
  }

  public static List<Temperature> customSort(final List<Temperature> unsortedList) {
    final Comparator<Temperature> celsiusComparator =
        Comparator.comparingDouble(Temperature::getCelsiusTemp);
    return unsortedList.stream()
        .filter(Objects::nonNull)
        .sorted(celsiusComparator)
        .collect(Collectors.toList());
  }
}
