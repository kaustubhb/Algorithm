// Develop an implementation SmartDate of our Date API that raises an exception
// if the date is not legal.

package ch1.section2;

import edu.princeton.cs.introcs.StdOut;
import java.util.Objects;

public class Ex11_SmartDate {

  private static final int[] monthDays = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private final int fDay;
  private final int fMonth;
  private final int fYear;

  public Ex11_SmartDate(int day, int mon, int year) {
    if (year < 1900) {
      throw new IllegalArgumentException("Can't handle years before 1900");
    }
    fYear = year;
    if (mon < 1 || mon > 12) {
      throw new IllegalArgumentException("Invalid month");
    }
    fMonth = mon;
    if (day < 1 || day > monthDays[fMonth]) {
      if (mon != 2 || day != 29 || !isLeapYear(year)) {
        throw new IllegalArgumentException("Invalid day");
      }
    }
    fDay = day;
  }

  public static void main(String[] args) {
    Ex11_SmartDate date = new Ex11_SmartDate(31, 12, 1999);
    StdOut.println(date);   // 12/31/1999
    StdOut.println(new Ex11_SmartDate(29, 2, 2020 ));
    try {
      StdOut.println(new Ex11_SmartDate(29, 2, 2022 ));
    } catch (IllegalArgumentException ex) {
      StdOut.println("Expected IllegalArgumentException exception");
    }
  }

  private boolean isLeapYear(int year) {
    return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0);
  }

  public int day() {
    return fDay;
  }

  public int month() {
    return fMonth;
  }

  public int year() {
    return fYear;
  }

  public String toString() {
    return fDay + "/" + fMonth + "/" + fYear;
  }

  public boolean equals(Object x) {
    if (this == x) {
      return true;
    }
    if (x == null) {
      return false;
    }
    if (x.getClass() != this.getClass()) {
      return false;
    }

    Ex11_SmartDate d = (Ex11_SmartDate) x;
    if (fDay != d.fDay) {
      return false;
    }
    if (fMonth != d.fMonth) {
      return false;
    }
    if (fYear != d.fYear) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fDay, fMonth, fYear);
  }

}
