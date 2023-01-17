// Write a program that reads in lines from standard input with each line containing a name
// and two integers and then uses printf() to print a table with a column of
// the names, the integers, and the result of dividing the first by the second, accurate to
// three decimal places. You could use a program like this to tabulate batting averages for
// baseball players or grades for students.

package ch1.section1;

import edu.princeton.cs.introcs.In;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex21 {

  public static void main(String[] args) {
    String title = String.format("%8s | %6s | %6s | %8s", "Name", "Runs", "Matches", "Average");
    System.out.println(title);
    System.out.println(
        Stream.generate(() -> "-").limit(title.length()).collect(Collectors.joining()));

    In in = new In("files/c1s1e21_records.txt");
    while (in.hasNextLine()) {
      String line = in.readLine();
      String[] stats = line.split("\\s+");
      try {
        printStats(new Record(stats[0], Integer.parseInt(stats[1]), Integer.parseInt(stats[2])));
      } catch (Exception ex) {
        System.err.println(ex.getMessage());
      }
    }
  }

  private static void printStats(final Record record) {
    record.average = 1.0 * record.runs / record.matches;
    System.out.printf("%8s | %6d | %6d | %6.2f\n", record.name, record.runs, record.matches,
        record.average);
  }

  static class Record {

    String name;
    int runs;
    int matches;
    double average;

    public Record(String name, int runs, int matches) {
      this.name = name;
      this.runs = runs;
      this.matches = matches;
    }
  }
}
