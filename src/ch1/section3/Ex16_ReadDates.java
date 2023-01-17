// Using readInts() on page 126 as a model, write a static method readDates() for
// Date that reads dates from standard input in the format specified in the table on page 119
// and returns an array containing them.

package ch1.section3;

import ch1.section2.Ex12_SmartDate;
import edu.princeton.cs.introcs.StdIn;

public class Ex16_ReadDates {

  public static void main(String[] args) {
    System.out.println(readDates().length);
  }

  // Format - M/D/Y
  private static Ex12_SmartDate[] readDates() {
    Queue<Ex12_SmartDate> queue = new Queue<>();
    while (!StdIn.isEmpty()) {
      queue.enqueue(new Ex12_SmartDate(StdIn.readString()));
    }
    Ex12_SmartDate[] arr = new Ex12_SmartDate[queue.size()];
    int i = 0;
    for (var d : queue) {
      arr[i++] = d;
    }
    return arr;
  }
}
