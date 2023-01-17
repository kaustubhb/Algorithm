package ch1.section2;

import java.util.Objects;
import utils.MyUtils;

public class Ex17_Rational {

  private long fNum, fDen;
  private int fSign;

  public Ex17_Rational(long value) {
    this(value, 1);
  }

  public Ex17_Rational(long numerator, long denominator) {
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

    Ex17_Rational y = (Ex17_Rational) x;
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

  public Ex17_Rational plus(Ex17_Rational b) {
    long num = addWithOverflow(fSign * multiplyWithOverflow(fNum, b.fDen),
        multiplyWithOverflow(fDen, b.fNum) * b.fSign);
    long den = multiplyWithOverflow(fDen, b.fDen);
    return new Ex17_Rational(num, den);
  }

  public Ex17_Rational minus(Ex17_Rational b) {
    return plus(new Ex17_Rational(-b.fNum, b.fDen));
  }

  public Ex17_Rational times(Ex17_Rational b) {
    return new Ex17_Rational(multiplyWithOverflow(fNum, b.fNum),
        multiplyWithOverflow(fDen, b.fDen));
  }

  public Ex17_Rational divides(Ex17_Rational b) {
    return new Ex17_Rational(multiplyWithOverflow(fNum, b.fDen),
        multiplyWithOverflow(fDen, b.fNum));
  }

  private long addWithOverflow(long a, long b) {
    long sum = a + b;
    if (a > 0 && b > 0 && sum < 0 || a < 0 && b < 0 && sum > 0) {
      throw new ArithmeticException("Overflow");
    }
    return sum;
  }

  private long multiplyWithOverflow(long a, long b) {
    long prod = a * b;
    if (a != 0 && prod / a != b) {
      throw new ArithmeticException("Overflow");
    }
    return prod;
  }

}
