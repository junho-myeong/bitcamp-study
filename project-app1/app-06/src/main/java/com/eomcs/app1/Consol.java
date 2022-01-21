package com.eomcs.app1;

import java.util.Arrays;
import java.util.Scanner;

public class Consol {
  static Scanner sc = new Scanner(System.in);
  static Command prompt() {
    System.out.print(">");
    String[] values = sc.nextLine().split(" ");
    return new Command(values[0], Arrays.copyOfRange(values, 1, values.length));
  }

  public static void close() {
    sc.close();
  }
}
