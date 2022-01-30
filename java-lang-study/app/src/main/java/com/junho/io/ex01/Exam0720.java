// 활용 - 지정한 폴더를 삭제하라.
package com.junho.io.ex01;

import java.io.File;

public class Exam0720 {

  public static void main(String[] args) throws Exception {
    File dir = new File("temp");

    deleteDir(dir);
  }
  static void deleteDir(File dir) {
    if (dir.isDirectory()) {
      File[] files = dir.listFiles();
      for (File file : files) {
        deleteDir(file);
      }
    }
    dir.delete();
  }
}
