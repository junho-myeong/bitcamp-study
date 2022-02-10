package com.eomcs.oop.ex11.overview.step1;

public class Test2 {

  public static void main(String[] args) {
    MyStack myStack = new MyStack();
    //    System.out.println(myList.size());
    myStack.push("홍길동");
    myStack.push("임꺽정");
    myStack.push("황대헌");
    myStack.push("안중근");
    myStack.push("김구");
    myStack.push("윤봉길");

    while (myStack.size() > 0) {
      System.out.println(myStack.pop());
    }
  }

}
