// 활용 - 지정한 폴더 및 그 하위 폴더까지 모두 검색하여 파일 및 디렉토리 이름을 출력하라.
package com.junho.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0710 {

  public static void main(String[] args) throws Exception {
    File dir = new File(".");
    System.out.println(dir.getCanonicalPath());

    printList(dir,1);
  }
  static void printList(File dir, int level) {
    File[] files = dir.listFiles();
    for (File file : files) {
      printIndent(level);
      if (file.isDirectory() && !file.isHidden()) {
        System.out.printf("%s \n", file.getName());
        printList(file, level + 1);
      } else if (file.isFile()) {
        System.out.print("\\--");
        System.out.printf("%s \n",file.getName());
      }
    }
  }
  static void printIndent (int level) {
    for (int i = 0; i < level; i++) {
      System.out.print(" ");
    }
  }
  class JavaFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
      if (pathname.isDirectory() || pathname.getName().endsWith(".class")) {
        return true;
      }
      return false;
    }
  }

}
