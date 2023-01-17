// SmartDate. Develop an implementation Ex12_SmartDate of our Date API that raises an
// 	exception if the date is not legal.
// Add a method dayOfTheWeek() to Ex12_SmartDate that returns a String value
//	Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, or Sunday,
//	giving the appropriate day of the week for the date. You may assume that
//	the date is in the 21st century.


package ch1.section2;

public class Ex12_SmartDate {

  private static final int[] monthDays = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private static final String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday",
      "Thursday", "Friday", "Saturday"};
  private int fDay;
  private int fMonth;
  private int fYear;

  public Ex12_SmartDate(int day, int mon, int year) {
    initialize(day, mon, year);
  }

  // Accepted format - M/D/Y
  public Ex12_SmartDate(String date) {
    String[] fields = date.split("/");
    if (fields.length != 3) {
      throw new IllegalArgumentException("Wrong format of date");
    }

    int mon = Integer.parseInt(fields[0]);
    int day = Integer.parseInt(fields[1]);
    int year = Integer.parseInt(fields[2]);
    initialize(day, mon, year);
  }

  private void initialize(int day, int mon, int year) {
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

  private boolean isLeapYear(int year) {
    return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0);
  }

  private int daysSince1Jan2000() {
    int daysElapsed = 0;
    for (int i = 2000; i < fYear; ++i) {
      if (isLeapYear(i)) {
        daysElapsed += 366;
      } else {
        daysElapsed += 365;
      }
    }
    for (int i = 1; i < fMonth; ++i) {
      daysElapsed += monthDays[i];
    }
    if (fMonth > 2 && isLeapYear(fYear)) {
      ++daysElapsed;
    }
    daysElapsed += fDay - 1;

    return daysElapsed;
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

  @Override
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

    Ex12_SmartDate d = (Ex12_SmartDate) x;
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
    return Integer.hashCode(Integer.hashCode(fDay)
        + Integer.hashCode(fMonth)
        + Integer.hashCode(fYear));
  }

  public String dayOfWeek() {
    int dayOnJan12000 = 6; // Saturday
    int elapsedDays = daysSince1Jan2000();
    int dayToday = (elapsedDays % 7 + dayOnJan12000) % 7;
    return weekDays[dayToday];
  }
}
