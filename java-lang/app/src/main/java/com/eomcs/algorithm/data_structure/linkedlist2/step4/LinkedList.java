package com.eomcs.algorithm.data_structure.linkedlist2.step4;

public class LinkedList {
  Node head;
  Node tail;
  int size;

  // create
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

  public void add(int index, Object value) {
    Node node = getNode(index);
    Node newNode = new Node(value);
    if (node.prev != null) {
      node.prev.next = newNode; // 앞 노드 뒤의 노드를 새 노드로 설정
    }
    newNode.prev = node.prev; // 새 노드의 앞 노드 설정
    node.prev = newNode; // 현재 노드의 앞 노드를 새 노드로 설정
    newNode.next = node; // 새 노드의 다음 노드를 현재 노드로 설정. 
    if (node == head) { // 첫 번째 노드라면
      head = newNode; // 새 노드를 첫 번째 노드로 만든다.
    }
    size++;
  }

  public int size() {
    return size;
  }

  // read
  private Node getNode(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node node = head;
    int count = 0;
    while (count < index) {
      node = node.next;
      count++;
    }
    return node;
  }

  public Object get(int index) {
    Node node = getNode(index);
    return node.value;
  }

  public Object remove(int index) {
    Node node = getNode(index);
    Node old = node;
    if (size == 1) {
      head = tail = null;
    } else if (node == head) { // 맨앞 값 삭제
      head = node.next;
    } else if (node == tail) { // 맨뒤 값 삭제
      tail = node.prev;
    } else { // 중간 값 삭제
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
    // 삭제된 노드는 다른 노드를 참조하지 않도록 초기화시킨다.
    // => 삭제된 노드 끼리 참조하는 경우 가비지가 되지 않는 문제를 방지하기 위함이다.
    // => 삭제된 노드가 값 객체의 주소를 갖고 있으면 값 객체가 가비지가 되지않는 문제 발생한다.
    node.prev = null; // 다중에서는 삭제한것이지만 변수에는 다음꺼에 레퍼런스를 참조하고 잇어서 가비지가 될수없기 때문인다.
    node.next = null; // 예를들면 왕따
    Object deleted = node.value;
    node.value = null;
    size--;
    return deleted; // 삭제되기 전에 값을 리턴한다.
  }

  // update
  public Object set(int index, Object value) {
    Node node = getNode(index);
    Object old = node.value;
    node.value = value;
    return old; // 변경되기 전에 값을 리턴한다.
  }

  public Iterator iterator() {
    // local Class 활용 예
    // => 특정 메서드 안에서만 사용될 때
    // 
    class ListIterator implements Iterator{

      int cursor;

      // 다음에 값이 잇는지 확인
      @Override
      public boolean hasNext() {
        return cursor < LinkedList.this.size();
      }
      // 현재 위치 값에서 값 꺼내기
      @Override
      public Object next() {
        return LinkedList.this.get(cursor++);
      }
    }
    return new ListIterator(); //
  }

  // 범위 축소
  // satic Nested Class 활용 예
  // => 특정 클래스 내부에서만 사용되는 클래스일 때
  // => 바깥 클래스의 인스턴스 맴버를 사용하지 않을때
  private static class Node { // 바깥클래스에 인스턴스 맴버를 사용하지 않기 때문에 static으로 해준다
    Node prev;
    Object value;
    Node next;

    public Node(Object value) {
      this.value = value;
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
}
