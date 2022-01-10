package com.eomcs.io;
// 기존 코드를 자신의 코드마냥 사용 하겠다고 사용한다.
// extends
public class FileReader2 extends java.io.FileReader{
  // 슈퍼 클래스에 생성자는 바로 사용할 수 없다.
  // 서브 클래스에 생성자를 통해 사용해야 한다.
  public FileReader2(String filename) throws Exception {

    // 다음과 같이 슈퍼 클래스에 생성자를 호출 해야한다.
    super(filename);
  }
}
