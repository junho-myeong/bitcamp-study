// 파일 생성
package com.junho.io.ex01;

import java.io.File;

public class Exam0411 {

  public static void main(String[] args) throws Exception {
    // 존재하지 않는 폴더에 파일을 생성 할때
    // - 해당 경로에 디렉토리가 없다면 파일을 생성할 수 없다.
    // - 예외 발생!
    File file = new File("temp/b/text.txt");

    if (file.createNewFile()) {
      System.out.println("test.txt 파일을 생성하였습니다.");
    }else {
      // 이미 파일이 잇다면 생성할수 없다.
      System.out.println("test.txt 파일을 생성할수 없습니다.");
    }

  }

}
