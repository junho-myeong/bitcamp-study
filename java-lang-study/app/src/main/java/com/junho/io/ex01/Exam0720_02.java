// 활용 - 지정한 폴더를 삭제하라.
package com.junho.io.ex01;

import java.io.File;

public class Exam0720_02 {

  public static void main(String[] args) {
    // temp 디렉토리를 삭제하기
    File dir = new File("temp");
    deleteDir(dir);

  }
  static void deleteDir(File dir) {
    // 내가 만든 방법
    //    File[] files = dir.listFiles();
    //    for (File file : files) {
    //      if (file.isDirectory() && !file.isHidden()) {
    //        deleteDir(file);
    //        file.delete();
    //      } else if (file.isFile()){
    //        file.delete();
    //      }
    //    }
    //    dir.delete();

    // 강사님 방법
    // 주어진 파일이 디렉토리라면 하위 파일이나 디렉토리를 찾아 지운다.
    if (dir.isDirectory()) {
      File[] files = dir.listFiles();
      for (File file: files) {
        deleteDir(file);
      }
    }
    dir.delete();
  }

}
