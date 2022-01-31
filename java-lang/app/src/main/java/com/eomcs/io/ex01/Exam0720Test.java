// 활용 - 지정한 폴더를 삭제하라
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0720Test {

  public static void main(String[] args) {
    File dir = new File("temp");

    dirDelete(dir);
  }
  static void dirDelete(File dir) {
    File[] files = dir.listFiles();
    for (File file : files) {
      if (file.isDirectory() && !file.isHidden()) {
        dirDelete(file);
      } else if (file.isFile()) {
        file.delete();
      }
    }
    dir.delete();
  }

}
