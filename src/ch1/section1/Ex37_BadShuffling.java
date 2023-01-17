// 1.1.37 Bad shuffling. Suppose that you choose a random integer between 0 and N-1
//  in our shuffling code instead of one between i and N-1. Show that the resulting order is
//  not equally likely to be one of the N! possibilities. Run the test of the previous exercise
//  for this version.

package ch1.section1;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Ex37_BadShuffling {

  static void shuffle(int[] a) {
    for (int i = 0; i < a.length; ++i) {
      int j = StdRandom.uniform(0, a.length);
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
    System.out.print("What is the size of array? ");    // Try 10
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