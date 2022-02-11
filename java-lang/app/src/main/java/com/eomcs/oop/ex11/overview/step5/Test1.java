// 핵심: low coupling 구현 하기! 종속 관계를 최대한 줄이기
package com.eomcs.oop.ex11.overview.step5;

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

    Iterator iterator = myList.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

}
