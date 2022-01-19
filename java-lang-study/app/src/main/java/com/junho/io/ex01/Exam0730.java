package com.junho.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0730 {

  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");

    printClasses(dir);


  }

  static void printClasses(File dir) {
    class JavaFilter implements FileFilter {
      @Override
      public boolean accept(File pathname) {
        if ((pathname.isFile() && pathname.getName().endsWith(".class")) || pathname.isDirectory()) {
          return true;
        }
        return false;
      }
    }

    File[] files = dir.listFiles(new JavaFilter());
    for (File file : files) {
      if (file.isDirectory()) {
        printClasses(file);
      } else {
        System.out.println(file.getName());
      }
    }
  }

}
