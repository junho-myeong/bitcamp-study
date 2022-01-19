package com.junho.io.ex01;

import java.io.File;

public class Exam0321 {

  public static void main(String[] args) {

    // 존재하지 않는 폴더 아래에 새 폴더를 만들 때
    // => 존재하지 않는 폴더가 자동 생성되지 않는다.
    // => 따라서 그 하위 폴더도 생성할 수 없다.

    File dir = new File("temp2/a");

    if (dir.mkdir()) {
      System.out.println("temp2/a 디렉토리를 생성하엿습니다.");
    }else {
      System.out.println("temp2/a 디렉토리를 생성하지 못했습니다.");
    }

  }

}
