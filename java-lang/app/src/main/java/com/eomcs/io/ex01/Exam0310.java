// 디렉토리 생성
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0310 {

  public static void main(String[] args) throws Exception {
    // 1) 생성할 디렉토리 경로 설정
    // - 폴더 경로를 지정하지 않으면 현재 폴더를 의미한다.
    //
    // File 생성자 파라미터 값 별로 확인해 보기 
    // 이클립스에서는 현재 디렉토리는 프로젝트 경로를 말한다.
    // 이미 생성되어 있는 폴더라면 생성할수 없다
    File dir = new File("temp");
    if (dir.mkdir()) { // 디렉토리 생성
      System.out.println("temp 디렉토리를 생성하였습니다.");
    } else {
      System.out.println("temp 디렉토리를 생성할 수 없습니다.");
    }


  }

}
