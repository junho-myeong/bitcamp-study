package com.junho.io.ex01;

import java.io.File;

public class Exam0431 {

  public static void main(String[] args) throws Exception {
    // 생성할 파일의 경로 설정
    File file = new File("temp/b/test.txt");

    // 파일을 생성하기 전에 존재하지 않는 폴더를 생성하고 싶다면,
    //    String path = file.getParent(); // 현재 생성하고싶은 파일의 부모 경로를 말한다.
    //    File dir = new File(path); // 그 부모 경로에 대한 정보를 File 클래스에게 준다

    File dir = file.getParentFile(); // 위에 코드와 같다
    System.out.println(dir.getCanonicalPath());

    // 먼저 디렉토리를 생성한다.
    // 디렉토리가 존재하지 않는다면 mkdirs()를 하면 된다.
    // 현재는 우리가 temp는 존재하지만 b만 존재하지 않기 때문에
    // mkdir 한번만 사용해도 기능이 돌아간다.
    if (dir.mkdirs()) {
      System.out.println("디렉토리 생성 완료");
    } else {
      System.out.println("디렉토리를 생성할 수 없습니다.");
    }

    // 그런후에 파일을 생성한다.
    if (file.createNewFile()) {
      System.out.println("파일을 생성하였습니다.");
    } else {
      System.out.println("파일을 생성할수 없습니다.");
    }
  }

}
