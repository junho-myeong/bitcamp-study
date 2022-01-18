// Character Stream - 텍스트 읽기 II
package com.eomcs.io.ex03;

import java.io.BufferedReader;
import java.io.FileReader;

public class Exam0430 {

  public static void main(String[] args) throws Exception {
    FileReader in = new FileReader("temp/test2.txt");

    // 데코레이터를 붙인다.
    // => 버퍼 기능 + 한 줄 읽기 기능
    BufferedReader in2 = new BufferedReader(in);
    // FileReader 와 BufferedReader에 파라미터를 보고 주객체 인지 데코레이터 인지 확인이 가능하다

    System.out.println(in2.readLine());

    in.close();
  }

}


