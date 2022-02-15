package com.junho.algorithm.data_structer.linkedList.step1;

public class Node {
  Node prev;
  Object value;
  Node next;

  public Node() {

  }
  public Node(Object value) {
    this.value = value;
  }
  public Node(Object value, Node prev,Node next) {
    this.prev = prev;
    this.value = value;
    this.next = next;
  }


}
