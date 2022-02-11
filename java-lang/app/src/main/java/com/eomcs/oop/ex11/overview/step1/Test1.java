// 이다음 단계는 람다와 메서드 레퍼런스인데,
// 두가지 문법은 인터페이스에서 한개의 메서드만 선언해야할때만 가능하다
package com.eomcs.oop.ex11.overview.step1;

public class Test1 {

  public static void main(String[] args) {
    MyList myList = new MyList();
    //    System.out.println(myList.size());
    myList.add("홍길동");
    myList.add("임꺽정");
    myList.add("황대헌");
    myList.add("안중근");
    myList.add("김구");
    myList.add("윤봉길");

    for (int i = 0; i < myList.size; i++) {
      System.out.println(myList.get(i));
    }
  }

}
