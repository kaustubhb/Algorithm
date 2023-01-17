package ch1.section1;

public class Ex33_MatrixLibrary {

  static double dot(double[] x, double[] y) {
    double result = 0;
    if (x.length != y.length) {
      throw new RuntimeException("The length of arguments must match");
    }
    for (int i = 0; i < x.length; ++i) {
      result += x[i] * y[i];
    }
    return result;
  }

  static double[][] multiply(double[][] a, double[][] b) {
    double[][] result = new double[a.length][b[0].length];
    int l = a.length, m = a[0].length, n = b[0].length;
    if (b.length != m) {
      throw new RuntimeException("Incompatible matrices");
    }
    for (int i = 0; i < l; ++i) {
      if (a[i].length != m) {
        throw new RuntimeException("Mismatched lengths");
      }
      for (int j = 0; j < n; ++j) {
        for (int k = 0; k < m; ++k) {
          result[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return result;
  }

  static double[][] transpose(double[][] matrix) {
    int m, n;
    m = matrix.length;
    if (m == 0) {
      return null;
    }
    n = matrix[0].length;

    double[][] t = new double[n][m];
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        t[j][i] = matrix[i][j];
      }
    }
    return t;
  }

  // matrix-vector product
  static double[] multiply(double[][] a, double[] x) {
    double[] result = new double[a.length];
    double l = a[0].length;
    for (int i = 0; i < a.length; ++i) {
      if (a[i].length != x.length) {
        throw new RuntimeException("Incompatible operands");
      }
      for (int j = 0; j < l; ++j) {
        result[i] += a[i][j] * x[j];
      }
    }
    return result;
  }

  // vector-matrix product
  static double[] multiply(double[] x, double[][] a) {
    var result = multiply(new double[][]{x}, a);
    return result[0];
  }

}
