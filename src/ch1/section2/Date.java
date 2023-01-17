package ch1.section2;

import edu.princeton.cs.introcs.StdOut;
import java.util.Objects;

class Date {

  private final int fDay;
  private final int fMonth;
  private final int fYear;

  public Date(int day, int mon, int year) {
    fDay = day;
    fMonth = mon;
    fYear = year;
  }

  public static void main(String[] args) {
    int m = 12;
    int d = 31;
    int y = 1999;
    Date date = new Date(m, d, y);
    StdOut.println(date);   // 12/31/1999
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

    Date d = (Date) x;
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
