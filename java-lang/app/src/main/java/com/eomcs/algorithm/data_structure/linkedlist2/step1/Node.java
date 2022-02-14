package com.eomcs.algorithm.data_structure.linkedlist2.step1;

public class Node {
  Node prev;
  Object value;
  Node next;

  public Node() {

  }

  public Node(Object value) {
    this.value = value;
  }

  public Node (Object value, Node prev, Node next) {
    this.value = value;
    this.prev = prev;
    this.next = next;
  }

  public Node getPrev() {
    return prev;
  }
  public void setPrev(Node prev) {
    this.prev = prev;
  }
  public Object getValue() {
    return value;
  }
  public void setValue(Object value) {
    this.value = value;
  }
  public Node getNext() {
    return next;
  }
  public void setNext(Node next) {
    this.next = next;
  }
  @Override
  public String toString() {
    return "Node [prev=" + prev + ", value=" + value + ", next=" + next + "]";
  }


}
