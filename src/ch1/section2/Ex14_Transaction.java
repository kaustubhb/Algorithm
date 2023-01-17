// Using our implementation of equals() in Date as a model (page 103), develop
// implementations of equals() for Transaction.

package ch1.section2;

import java.util.Objects;

public class Ex14_Transaction {
  private final String fWho;
  private final Ex12_SmartDate fWhen;
  private final double fAmount;

  public Ex14_Transaction(String who, Ex12_SmartDate when, double amount) {
    fWho = who;
    fWhen = when;
    fAmount = amount;
  }

  public Ex14_Transaction(String record) {
    String[] fields = record.split("\\s+");
    if (fields.length != 3) {
      throw new RuntimeException("Transaction format invalid");
    }
    fWho = fields[0];
    fWhen = new Ex12_SmartDate(fields[1]);
    fAmount = Integer.parseInt(fields[2]);
  }

  public String who() {
    return fWho;
  }

  public Ex12_SmartDate when() {
    return fWhen;
  }

  public double amount() {
    return fAmount;
  }

  public boolean equals(Object x) {
    if (this == x) {
      return true;
    }
    if (x == null) {
      return false;
    }
    if (this.getClass() != x.getClass()) {
      return false;
    }

    Ex14_Transaction t = (Ex14_Transaction) x;
    if (!Objects.equals(this.who(), t.who())) {
      return false;
    }
    return this.when() == t.when();
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = fWho != null ? fWho.hashCode() : 0;
    result = 31 * result + (fWhen != null ? fWhen.hashCode() : 0);
    temp = Double.doubleToLongBits(fAmount);
    result = 31 * result + Long.hashCode(temp);
    return result;
  }

  public String toString() {
    return fWho + " " + fWhen + " " + fAmount;
  }
}
