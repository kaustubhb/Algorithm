//  Rational numbers. Implement an immutable data type Ex16_Rational for rational
//	numbers that supports addition, subtraction, multiplication, and division.

package ch1.section2;

import java.util.Objects;
import utils.MyUtils;

public class Ex16_Rational {

  private long fNum, fDen;
  private int fSign;

  public Ex16_Rational(long value) {
    this(value, 1);
  }

  public Ex16_Rational(long numerator, long denominator) {
    if (denominator == 0) {
      throw new ArithmeticException("Denominator cannot be zero");
    }
    fSign = (int) (Math.signum(numerator) * Math.signum(denominator));
    fSign = numerator == 0 ? 1 : fSign;
    fNum = Math.abs(numerator);
    fDen = Math.abs(denominator);
    reduce();
  }

  private void reduce() {
    long div = MyUtils.gcd(fNum, fDen);
    if (div != 1) {
      fNum /= div;
      fDen /= div;
    }
  }

  public String toString() {
    String str = (fSign < 0 ? "-" : "") + fNum;
    if (fDen != 1) {
      str += "/" + fDen;
    }
    return str;
  }

  @Override
  public boolean equals(Object x) {
    if (x == this) {
      return true;
    }
    if (x == null) {
      return false;
    }
    if (x.getClass() != this.getClass()) {
      return false;
    }

    Ex16_Rational y = (Ex16_Rational) x;
    if (y.fNum != fNum) {
      return false;
    }
    if (y.fDen != fDen) {
      return false;
    }
    return y.fSign == fSign;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fNum, fDen, fSign);
  }

  public Ex16_Rational plus(Ex16_Rational b) {
    long num = fSign * fNum * b.fDen + b.fSign * b.fNum * fDen;
    long den = fDen * b.fDen;
    return new Ex16_Rational(num, den);
  }

  public Ex16_Rational minus(Ex16_Rational b) {
    return plus(new Ex16_Rational(-b.fNum, b.fDen));
  }

  public Ex16_Rational times(Ex16_Rational b) {
    return new Ex16_Rational(fNum * b.fNum, fDen * b.fDen);
  }

  public Ex16_Rational divides(Ex16_Rational b) {
    return new Ex16_Rational(fNum * b.fDen, fDen * b.fNum);
  }
}