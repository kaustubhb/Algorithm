package ch1.section3;

import edu.princeton.cs.introcs.StdIn;

// Reverses a bunch of integers read from command line
public class Reverse {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    while(!StdIn.isEmpty()) {
      stack.push(StdIn.readInt());
    }
    for(int i : stack) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
