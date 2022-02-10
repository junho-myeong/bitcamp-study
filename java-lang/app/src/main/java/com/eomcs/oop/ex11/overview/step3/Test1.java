package com.eomcs.oop.ex11.overview.step3;

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

    ListIterator iterator = new ListIterator(myList); // 데이터 꺼낼 컬렉션은 myList이다.
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

}
