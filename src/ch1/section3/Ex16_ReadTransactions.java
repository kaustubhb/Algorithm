package ch1.section3;

import ch1.section2.Ex14_Transaction;
import edu.princeton.cs.introcs.StdIn;

public class Ex16_ReadTransactions {
  public static void main(String[] args) {
    System.out.println(readTransactions().length);
  }

  private static Ex14_Transaction[] readTransactions() {
    Queue<Ex14_Transaction> queue = new Queue<>();
    while (!StdIn.isEmpty()) {
      queue.enqueue(new Ex14_Transaction(StdIn.readLine()));
    }
    Ex14_Transaction[] arr = new Ex14_Transaction[queue.size()];
    int i = 0;
    for (var d : queue) {
      arr[i++] = d;
    }
    return arr;
  }
}
