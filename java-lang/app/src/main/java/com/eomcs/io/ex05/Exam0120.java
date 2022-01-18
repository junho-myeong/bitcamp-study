// 객체 읽기 - 파일이 데이터를 읽어 인스턴스로 만들기 
package com.eomcs.io.ex05;

import java.io.FileInputStream;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/test4.data");

    Member member = null;

    member = new Member();

    // 1) 이름 읽기
    int size = in.read(); // 이름이 저장된 바이트 배열의 수
    byte[] buf = new byte[size];
    in.read(buf); // 이름 배열 개수 만큼 바이트를 읽어 배열에 저장한다.
    member.name = new String(buf, "UTF-8"); // UTF-8 규칙에 따라서 문자에 대한 숫자 값이 저장된 배열을 String으로 바꿔줘
    // utf-8 캐릭터 셋이 저장된
    // jvm에서 읽을수 잇는 utf-16으로 바꿔준다

    // 2) 나이(int) 읽기
    member.age = in.read() << 24;
    member.age += in.read() << 16;
    member.age += in.read() << 8;
    member.age += in.read();

    // 3) 성별 읽기
    if (in.read() == 1) 
      member.gender = true;
    else 
      member.gender = false;

    in.close();

    System.out.printf("%s\n", member);
    System.out.printf("%s,%d,%s\n", member.name,member.age,member.gender);
  }
}






