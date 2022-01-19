// 활용 - 클래스 파일 이름을 출력할 때 패키지 이름을 포함하라.
package com.junho.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0731 {

  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");

    printClasses(dir, "");


  }

  static void printClasses(File dir, String packageName) {
    class JavaFilter implements FileFilter {
      @Override
      public boolean accept(File pathname) {
        if ((pathname.isFile() && pathname.getName().endsWith(".class")) || pathname.isDirectory()) {
          return true;
        }
        return false;
      }
    }
    if (packageName.length() > 0) {
      packageName += ".";
    }

    File[] files = dir.listFiles(new JavaFilter());
    for (File file : files) {
      if (file.isDirectory()) {
        printClasses(file, packageName + file.getName());
      } else {
        System.out.println(packageName + file.getName().replace(".class", ""));
      }
    }
  }

}
