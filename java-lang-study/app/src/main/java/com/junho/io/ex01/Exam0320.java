package com.junho.io.ex01;

import java.io.File;

public class Exam0320 {

  public static void main(String[] args) {
    File dir = new File("temp/a");

    // 하위 디렉토리 생성하기

    if (dir.mkdir()) {
      System.out.println("temp/a 디렉토리 생성하였습니다.");
    }else {
      System.out.println("temp/a 디렉토리를 생성하지 못했습니다.");
    }

  }

}
