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
