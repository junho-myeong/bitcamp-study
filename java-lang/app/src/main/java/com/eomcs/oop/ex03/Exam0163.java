// 클래스 변수의 응용 : 상수 변수를 import 하기 
//
package com.eomcs.oop.ex03;

// Member 클래스를 외부에 다른 클래스에서도 사용한다면,
// nested class로 선언하지 말고 package맴버로 분리하라.!!!

// 패키지 맴버에 스태틱 필드를 사용할 때는 다음과 같이 import로
// 그 변수의 소속을 미리 밝힐 수 있다.
// 스태틱 변수에 스태빅 변수를 미리 밝혀두면
// 클래스 이름 없이 스태틱 변수를 사용할수 잇다.

import static com.eomcs.oop.ex03.Member.GUEST;
import static com.eomcs.oop.ex03.Member.MANAGER;
import static com.eomcs.oop.ex03.Member.MEMBER;

// 여러 개를 한 번에 명시하고 싶다면 다음과 같이 wildcard(*)로 지정해도 된다.
//import static com.eomcs.oop.ex03.Member.*;

public class Exam0163 {

  public static void main(String[] args) {

    Member m4 = new Member();
    m4.id = "aaa";
    m4.password = "1111";
    m4.type = GUEST;  // import static 명령문에서 변수의 소속을 이미 밝혔기 때문에 클래스 이름을 적을 필요가 없다.
    // import에서 선언 하지 않았다면 스태틱 변수명 앞에 클래스 명을 붙여야 한다.
    // 예) Member.GUEST;

    Member m5 = new Member();
    m5.id = "bbb";
    m5.password = "1111";
    m5.type = MANAGER;

    Member m6 = new Member();
    m6.id = "ccc";
    m6.password = "1111";
    m6.type = MEMBER;
  }
}








