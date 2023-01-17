// Listing files. A folder is a list of files and folders. Write a program
// that takes the name of a folder as a command-line argument and prints out
// all the files contained in that folder, with the contents of each folder
// recursively listed (indented) under that folder's name.

package ch1.section3;

import java.io.File;
import java.util.Objects;

public class Ex42_ListingFiles {

  private static void printFiles(String folderName, int depth) {
    File file = new File(folderName);
    if (!file.exists()) {
      throw new IllegalArgumentException("File not found, " + file.getAbsolutePath());
    }

    printCurrent(file, depth);

    File[] files = file.listFiles();
    for (File f : Objects.requireNonNull(files)) {
      if (!f.isDirectory()) {
        printCurrent(f, depth + 1);
      } else {
        printFiles(f.getPath(), depth + 1);
      }
    }
  }

  private static void printCurrent(File file, int depth) {
    if (file.isHidden()) {
      return;
    }
    String sb = " ".repeat(Math.max(0, depth))
        + file.getName();
    System.out.println(sb);
  }

  public static void main(String[] args) {
    printFiles("src", 0);
  }
}
