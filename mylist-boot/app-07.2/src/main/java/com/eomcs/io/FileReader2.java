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
  public String readLine() throws Exception {
    StringBuilder buf = new StringBuilder();
    int c;
    while ((c = this.read()) != -1) {// 파일에서 한 문자를 읽는다. 더이상 읽을 문자가 없으면 반복문을 종료하다.
      if (c == '\n') { // 만약 읽은 문자가 줄바꿈 명령이라면, 지금까지 읽은 CSV 데이터를 분석하여 Contact 객체에 담는다.
        return buf.toString();
      } else { // 문자를 읽을 때 마다 버퍼이 임시 보관한다.
        buf.append((char) c);
      }
    }
    return buf.toString();
  }

}
