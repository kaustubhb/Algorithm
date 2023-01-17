package ch1.section1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Objects;
import org.junit.jupiter.api.Test;

class Ex33MatrixLibraryTest {

  private static void assertEqual2dDoubleMatrices(double[][] a, double[][] b, double epsilon) {
    assertEquals(a.length, b.length);
    for (int i = 0; i < a.length; ++i) {
      assertArrayEquals(a[i], b[i], epsilon);
    }
  }

  @Test
  public void testDot() {
    double[] a = new double[]{1, 2, 3};
    double[] b = new double[]{4, 5, 6};
    assertEquals(Ex33_MatrixLibrary.dot(a, b), 32.0, 0.000001);
  }

  @Test
  public void testMultMatrices() {
    double[][] a = {
        {1, 2, 3},
        {4, 5, 6}
    };
    double[][] b = {
        {7, 8},
        {9, 10},
        {11, 12}
    };
    var result = Ex33_MatrixLibrary.multiply(a, b);
    assertEqual2dDoubleMatrices(result, new double[][]{{58, 64}, {139, 154}}, 0.0001);

    double[][] c = {{7, 8, 9}, {10, 11, 12}};
    Exception exception = assertThrows(RuntimeException.class, () -> {
      Ex33_MatrixLibrary.multiply(a, c);
    });
    assertEquals("Incompatible matrices", exception.getMessage());
  }

  @Test
  public void testTranspose() {
    double[][] a = {
        {1, 2, 3},
        {4, 5, 6}
    };
    assertEqual2dDoubleMatrices(Objects.requireNonNull(Ex33_MatrixLibrary.transpose(a)),
        new double[][]{{1, 4}, {2, 5}, {3, 6}}, 0.0001);
  }

  @Test
  public void testMultMatrixVector() {
    double[][] a = {
        {1, 2, 3},
        {4, 5, 6}
    };
    double[] b = {7, 8, 9};
    assertArrayEquals(Ex33_MatrixLibrary.multiply(a, b), new double[]{50, 122}, 0.0001);
  }

  @Test
  public void testMultVectorMatrix() {
    double[][] a = {
        {1, 2, 3},
        {4, 5, 6}
    };
    double[] b = {7, 8};
    assertArrayEquals(Ex33_MatrixLibrary.multiply(b, a), new double[]{39, 54, 69}, 0.0001);
  }

}