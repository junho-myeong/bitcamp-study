// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0730Test {

  public static void main(String[] args) {
    File dir = new File(".");

    printClasses(dir, 1);
  }
  static void printClasses(File dir, int level) {
    class JavaFilter implements FileFilter {
      @Override
      public boolean accept(File pathname) {
        if (pathname.isDirectory() || (pathname.isFile()&& pathname.getName().endsWith(".class"))) {
          return true;
        }
        return false;
      }
    }
    File[] files = dir.listFiles(new JavaFilter());
    for (File file : files) {
      for (int i = 0; i < level; i++) {
        System.out.print(" ");
      }
      if (file.isDirectory()) {
        System.out.printf("%s \n", file.getName());
        printClasses(file, level + 1);
      } else if (file.isFile()) {
        System.out.print("\\--");
        System.out.printf("%s \n", file.getName());
      }
    }
  }

}
