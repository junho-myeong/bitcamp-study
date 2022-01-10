package com.eomcs.io;

import java.io.FileWriter;

// 위임기법을 이용하여 기존 기능을 확장한다.
public class FileWriter2{
  // 실제 파일로 데이터 출력을 실행할 객체를 포함한다.
  FileWriter out;

  // 이 클래스의 생성자를 통해 FileWriter 객체를 준비한다.
  public FileWriter2(String filename) throws Exception {
    out = new FileWriter(filename);
  }

  // 한줄 단위로 출력하는 기능을 추가한다.
  public void println(String str) throws Exception {
    // 실제 파일로 데이터를 출력하는 일은 FileWriter 객체에게 위임한다.
    out.write(str + "\n");
  }

  // 자원을 해제 시키는 실제 FileWriter에 잇기 때무넹 위임기법 사용한다.
  public void close() throws Exception{
    out.close();
  }
}
