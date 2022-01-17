// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
// 필터 사용해서
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0730x {

  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir); // 클래스이름과 인스턴스 주소 없이 바로 메서드 호출했다는것은
    // 같은 클래스에 static 메서드를 호출한다는 것이다.
    // 여기서 변수로 받아서 사용하는것이 아니기 때문에 return이 없다는 뜻이다.
  }
  static void  printClasses(File dir) {
    class JavaFilter implements FileFilter {
      @Override
      public boolean accept(File pathname) {
        if ((pathname.isFile() && pathname.getName().endsWith(".class")) || pathname.isDirectory()) {
          return true;
        }
        return false;
      }

    }
    File[] files = dir.listFiles(new JavaFilter());
    for (File file : files) {
      if(file.isDirectory()) {
        printClasses(file);
      } else {
        System.out.println(file.getName());
      }
    }
  }


}


