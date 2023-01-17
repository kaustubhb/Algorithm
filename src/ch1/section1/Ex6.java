// Predict output of program

package ch1.section1;

import edu.princeton.cs.introcs.StdOut;

public class Ex6 {

  public static void main(String[] args) {
    int f = 0;
    int g = 1;
    for (int i = 0; i <= 15; i++) {
      StdOut.println(f);
      f = f + g;
      g = f - g;
    }
  }
}

/*
0
f = 1
g = 0

1
f = 1
g = 1

1
f = 2
g = 1

2
f = 3
g = 2

3
f = 5
g = 3

5
f = 8
g = 5

Looks like fibonacci series is printed, stating from 0, 1
 */
