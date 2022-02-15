package com.junho.algorithm.data_structer.linkedList.step6;

public class LinkedList {
  Node head;
  Node tail;
  int size;

  // create
  public void add(Object value) {
    Node node = new Node(value);
    if (head == null) {
      tail = head = node;
    } else {
      node.prev = tail;
      tail.next = node;
      tail = node;
    }
    size++;
  }

  // create(insert)
  public void add(int index, Object value) {
    Node node = getNode(index);
    Node newNode = new Node(value);

    if (node.prev != null) {
      node.prev.next = newNode;
    } 
    newNode.prev = node.prev;
    node.prev = newNode;
    newNode.next = node;
    if (node == head) {
      head = newNode;
    }
    size++;
  }

  // read
  public Node getNode(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    } else {
      Node node = head;
      int count = 0;
      while (count < index) {
        node = node.next;
        count++;
      }
      return node;
    }
  }
  public Object get(int index) {
    Node node = getNode(index);
    return node.value;
  }

  public int size() {
    return this.size;
  }

  // delete
  public Object remove(int index) {
    Node node = getNode(index);
    if (size == 1) {
      tail = head = null;
    }else if (node == this.head) {
      head = node.next;
    } else if(node == this.tail) {
      tail = node.prev;
    } else {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
    node.next = null;
    node.prev = null;
    Object deleted = node.value;
    node.value = null;
    size--;
    return deleted;
  }

  // update
  public Object update(int index, Object value) {
    Node node = getNode(index);
    Object old = node.value;
    node.value = value;
    return old;
  }



  private static class Node {
    Node prev;
    Object value;
    Node next;

    public Node() {}
    public Node(Object value) {
      this.value = value;
    }
    public Node(Object value, Node prev,Node next) {
      this.prev = prev;
      this.value = value;
      this.next = next;
    }
  }

  public Iterator iterator() {
    return new Iterator(){
      int cursor;
      @Override
      public boolean hasNext() {
        return cursor < LinkedList.this.size();
      }
      @Override
      public Object next() {
        return LinkedList.this.get(cursor++);
      }
    };
  }



}
