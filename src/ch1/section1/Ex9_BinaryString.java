package ch1.section1;

public class Ex9_BinaryString {

  public static String binaryString(int num) {
    String s = "";
    while (num > 0) {
      s = num % 2 + s;
      num /= 2;
    }
    return s.isEmpty() ? "0" : s;
  }
}
