package com.eomcs.algorithm.data_structure.linkedlist2.step1;

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

    if (node.prev != null) { // 첫번째 노드가 아니라면
      node.prev.next = newNode; // 앞 노드 뒤의 노드를 새 노드로 설정.
      newNode.prev = node.prev; // 새 노드에 앞 노드 설정
      newNode.next = node; // 새 노드에 다음 노드를 현재 노드로 설정.
      node.prev = newNode; // 현재 노드에 앞 노드로 새 노드를 설정.

      size++;
    } else if(node == head) {
      head = newNode; // 새 노드를 첫번째 노드로 만든다.
      newNode.next = node.prev;
      node.prev = newNode;
      newNode.next = node;
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



}
