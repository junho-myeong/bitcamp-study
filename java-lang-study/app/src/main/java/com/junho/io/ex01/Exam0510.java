// 디렉토리에 들어 있는 파일이나 하위 디렉토리 정보 알아내기
package com.junho.io.ex01;

import java.io.File;

public class Exam0510 {

  public static void main(String[] args) {

    // 현재 폴더의 정보를 알아낸다.
    // 프로젝트 폴더를 말한다.
    File dir = new File(".");

    // 현재 폴더에 있는 파일이나 하위 디렉토리 이름 알아내기
    String[] names = dir.list(); // list 는 String 배열에 주소를 리턴한다.

    for (String name : names) {
      System.out.println(name);
    }

  }

}
