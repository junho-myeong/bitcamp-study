// java.io.Serializable 처럼 사용되는 인터페이스 : java.lang.Cloneable 인터페이스
package com.eomcs.io.ex11.b;

public class Exam0231 {

  static class Score {
    String name;

    // 복제 기능을 수행하려면 clone()을 오버라이딩 해야 한다.
    // overriding 은 메서드 시그니쳐가 같아야한다
    // modifier는 더 넓은 범위로 변경가능
    // 리턴 타입은 서브 클래스도 가능
    @Override
    public Score clone() throws CloneNotSupportedException {
      return (Score) super.clone();
    }
  }

  public static void main(String[] args) throws Exception {

    Score obj = new Score();

    System.out.println(obj instanceof Cloneable);

    Score copy = obj.clone(); // 런타임(run-time) 오류!
    // Object에서 상속 받은 clone()을 호출하려면
    // 해당 클래스에 대해 복제 기능을 활성화해야 한다.
    // 방법? java.lang.Cloneable 인터페이스를 구현하라!
  }

}
