// Empirical shuffle check. Run computational experiments to check that our
// shuffling code on page 32 works as advertised. Write a program ShuffleTest that takes
// command-line arguments M and N, does N shuffles of an array of size M that is initialized
// with a[i] = i before each shuffle, and prints an M-by-M table such that row i
// gives the number of times i wound up in position j for all j. All entries in the array
// should be close to N/M.

package ch1.section1;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Ex36_EmpericalShuffleCheck {

  static void shuffle(int[] a) {
    for (int i = 0; i < a.length; ++i) {
      int j = StdRandom.uniform(i, a.length);
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }

  static int[][] simulateShuffle(int numShuffles, int arrSize) {
    int[][] frequencyMatrix = new int[arrSize][arrSize];
    int[] a = new int[arrSize];
    for (int i = 0; i < numShuffles; ++i) {

      for (int j = 0; j < arrSize; ++j) {
        a[j] = j;
      }

      shuffle(a);
      for (int j = 0; j < arrSize; ++j) {
        ++frequencyMatrix[a[j]][j];
      }
    }
    return frequencyMatrix;
  }

  public static void main(String[] args) {
    System.out.print("How many times do you want to shuffle? ");  // Try 1000
    int numShuffles = StdIn.readInt();
    System.out.print("What is the size of array? ");  // Try 10
    int arrSize = StdIn.readInt();
    int[][] frequencyMatrix = simulateShuffle(numShuffles, arrSize);

    System.out.println("Frequency chart: \n[i, j] indicates how many times i was in position j");
    for (int i = 0; i < frequencyMatrix.length; ++i) {
      for (int j = 0; j < frequencyMatrix.length; ++j) {
        StdOut.printf("%6d", frequencyMatrix[i][j]);
      }
      StdOut.println();
    }
  }
}