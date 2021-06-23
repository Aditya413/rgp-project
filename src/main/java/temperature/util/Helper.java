package temperature.util;

import temperature.model.Temperature;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/** Helper class is used to take out the common functionality and make it reusable. */
public class Helper {

  private Helper() {
    //
  }

  /**
   * It takes the unsorted {@link Temperature} list, filter out null values and used implemented
   * compareTo method to sort the list.
   *
   * @param unsortedList {@link Temperature}
   * @return sortedList {@link Temperature}
   */
  public static List<Temperature> customSort(final List<Temperature> unsortedList) {
    return unsortedList.stream().filter(Objects::nonNull).sorted().collect(Collectors.toList());
  }
}
