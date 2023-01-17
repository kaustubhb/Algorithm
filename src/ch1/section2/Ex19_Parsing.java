// Develop the parse constructors for your Date and Transaction implementations
// that take a single String argument to specify the
// initialization values, using the formats given in the table below.

package ch1.section2;

public class Ex19_Parsing {

  // Expected input format dd?/mm?/yyyy
  public static Ex12_SmartDate dateFromString(String strDate) {
    if (strDate == null) {
      throw new IllegalArgumentException("null argument");
    }
    String[] components = strDate.split("/");
    if (components.length != 3) {
      throw new IllegalArgumentException("malformed date");
    }
    return new Ex12_SmartDate(Integer.parseInt(components[0]), Integer.parseInt(components[1]),
        Integer.parseInt(components[2]));
  }

  // Expected format "Turing 22/5/1939 11.99"
  public static Ex14_Transaction transactionFromString(String strTxn) {
    if (strTxn == null) {
      throw new IllegalArgumentException("null argument");
    }
    String[] components = strTxn.split(("\\s+"));
    if (components.length != 3) {
      throw new IllegalArgumentException("Malformed transaction");
    }
    return new Ex14_Transaction(components[0],
        dateFromString(components[1]), Double.parseDouble(components[2]));
  }
}
