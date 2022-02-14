package com.eomcs.oop.ex11.h.test;

public class LinkedList {
  Node head;
  Node tail;
  int size;


  public void add(Object value) {
    Node node = new Node(value); // 값을 담을 객체를 준비한다.

    if (head == null) {
      tail = head = node; // 1번 head = node, 2번 tail = node
    } else {
      node.prev = tail;
      tail.next = node; // 여기까지에서 tail은 앞에 열차에 주소를 가르 킨다
      tail = node;
    }
    size++;
  }

  public int size() {
    return size;
  }
}
