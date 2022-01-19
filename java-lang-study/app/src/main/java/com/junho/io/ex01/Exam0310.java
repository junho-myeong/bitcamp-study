package com.junho.io.ex01;

import java.io.File;

public class Exam0310 {

  public static void main(String[] args) {
    // 1) 생성할 디렉토리 경로 설정
    // - 폴더 경로를 지정하지 않으면 현재 폴더를 의미한다. (최상위 루트를 말한다. 여기서는 app)
    // 
    File dir = new File("temp");
    if (dir.mkdir()) { // 디렉토리 생성
      System.out.println("temp 디렉토리를 생성하였습니다.");
    }else {
      System.out.println("temp 디렉토리를 생성하지 못했습니다.");
    }

  }

}
