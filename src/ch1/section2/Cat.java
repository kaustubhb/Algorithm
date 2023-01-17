package ch1.section2;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

// Concatenate multiple files to the output file (last argument)
// Usage:
// arg1: src/ch1/section2/Cat.java
// arg2: src/ch1/section2/Counter.java
// arg3: out/temp.txt
class Cat {

  public static void main(String[] args) {
    assert (args.length >= 2);
    Out outputFile = new Out(args[args.length - 1]);
    for (int i = 0; i < args.length - 1; ++i) {
      In fin = new In(args[i]);
      String s = fin.readAll();
      outputFile.print(s);
    }
  }
}
