package com.eomcs.oop.ex11.overview.step7;

public class Test3 {

  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    //    System.out.println(myList.size());
    myQueue.offer("홍길동");
    myQueue.offer("임꺽정");
    myQueue.offer("황대헌");
    myQueue.offer("안중근");
    myQueue.offer("김구");
    myQueue.offer("윤봉길");

    // iterator는 팩토리 메서드이다.
    Iterator iterator = myQueue.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

}
