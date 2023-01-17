/* Josephus problem. In the Josephus problem from antiquity,
 * N people are in dire straits and agree to the following strategy to
 * reduce the population. They arrange themselves in a circle (at positions
 * numbered from 0 to N–1) and proceed around the circle, eliminating every
 * Mth person until only one person is left. Legend has it that Josephus
 * figured out where to sit to avoid being eliminated. Write a Queue client
 * Josephus that takes N and M from the command line and prints out the order
 * in which people are eliminated (and thus would show Josephus where to
 * sit in the circle)
 */

package ch1.section3;

import edu.princeton.cs.introcs.StdIn;

public class Ex37_JoesephusProblem {

  public static void main(String[] args) {
    System.out.print("Number of people in circle? ");
    int n = StdIn.readInt();
    System.out.print("Value of m where every Mth person is eliminated? ");
    int m = StdIn.readInt();

    Queue<Integer> que = new Queue<>();
    for (int i = 0; i < n; ++i) {
      que.enqueue(i);
    }

    // now start eliminating
    int count = 0;
    while (que.size() > 1) {
      int x = que.dequeue();
      if (++count % m == 0) {
        System.out.println(x + 1);
      } else {
        que.enqueue(x);
      }
    }
    // last man standing
    System.out.print("Last man standing: ");
    System.out.println(que.dequeue() + 1);
  }
}
