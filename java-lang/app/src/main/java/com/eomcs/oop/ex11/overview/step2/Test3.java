package com.eomcs.oop.ex11.overview.step2;

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

    // MyList에 get 메서드랑 다르다!!! 거기서는 조회만 하는것이다.
    while (myQueue.size() > 0) {
      System.out.println(myQueue.poll());
    }
    System.out.println(myQueue.size());
  }

}
