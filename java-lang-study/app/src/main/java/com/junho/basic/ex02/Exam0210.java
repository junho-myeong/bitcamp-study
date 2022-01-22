// Wrapper 클래스 - 종류
package com.junho.basic.ex02;

public class Exam0210 {

  public static void main(String[] args) {
    // 자바는 primitive type에 data 를 객체처럼 다룰 수 있도록
    // 각 타입에 대응하는 클래스를 제공한다.
    // 예)
    Byte b = new Byte((byte)100);               // ==> byte
    Short s = new Short((short)20000);          // ==> short
    Integer i = new Integer(3000000);           // ==> int
    Long l = new Long(60000000000L);            // ==> long
    Float f = new Float(3.14f);                 // ==> float
    Double d = new Double(3.14159);             // ==> double
    Boolean bool = new Boolean(true);           // ==> boolean
    Character c = new Character((char)0x41);    // ==> char

    // 이렇게 primitive data type에 대응하여 만든 클래스를
    // primitive data를 포장하는 객체라고 해서
    // "랩퍼(wrapper) 클래스"라 부른다.

    // 래퍼 클래스의 주요 용도:
    // => primitive data type의 값을 객체로 주고 받을 때 사용한다.
    // => primitive data type의 값을 객체에 담아 전달하고 싶다면
    //    언제든 wrapper 클래스의 인스턴스를 만들면 된다.
    //
    // Java 9 부터 wrapper 클래스의 생성자가 deprecated 상태이다.
    // 가능한 생성자를 사용하여 인스턴스를 생성하지 말라!
    // deprecated(비난받는, 유지보수가 중단되어, 사용이 권장되지 않는)?
    // - 사용하지 않는 것이 좋다고 결정되었고, 가까운 장래에 제거될 것이라는 의미.
    //

    // Wrapper 클래스의 인스턴스를 생성할 때는 생성자 대신 클래스 메서드를 사용하라.
    // 자바에서 정수는 기본적으로 4바이트 int이다
    // 이렇게 객체를 만들어 주는 메서드를 
    // "factory method"라 부른다. 
    // factory method?
    // => 객체를 만들어 주는 메서드이다.

    Byte b2 = Byte.valueOf((byte)100); // 100 은 원래 4바이트 int형 리터릴이다. 할당연산자일때는 byte = 100; 이 허락 되지만 파라미터에서는 바이트에 int리터럴로 숫자를 넣으면 안된다.
    Short s2 = Short.valueOf((short)20000);
    Integer i2 = Integer.valueOf(3000000);
    Long l2 = Long.valueOf(60000000000L);
    Float f2 = Float.valueOf(3.14f);
    Double d2 = Double.valueOf(3.14159);
    Boolean bool2 = Boolean.valueOf(true);
    Character c2 = Character.valueOf((char)0x41);
  }

}
