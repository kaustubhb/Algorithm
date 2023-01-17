// Using our implementation of Date as a model, develop an implementation
// of Transaction.

package ch1.section2;

public class Ex13_Transaction {

  private final String fWho;
  private final Ex12_SmartDate fWhen;
  private final double fAmount;

  public Ex13_Transaction(String who, Ex12_SmartDate when, double amount) {
    fWho = who;
    fWhen = when;
    fAmount = amount;
  }

  public Ex13_Transaction(String record) {
    String[] fields = record.split(" ");
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

  public String toString() {
    return fWho + " " + fWhen + " " + fAmount;
  }
}
