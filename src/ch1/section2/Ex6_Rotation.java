//  A string s is a circular rotation of a string t if it matches when the characters
//	are circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of
//	TGACGAC, and vice versa. Detecting this condition is important in the study of genomic
//	sequences. Write a program that checks whether two given strings s and t are circular

package ch1.section2;

public class Ex6_Rotation {

  public static boolean checkRotation(String s, String t) {
    return s.length() == t.length() && (s + s).contains(t);
  }
}
