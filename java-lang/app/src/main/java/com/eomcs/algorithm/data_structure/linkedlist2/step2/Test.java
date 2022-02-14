package com.eomcs.algorithm.data_structure.linkedlist2.step2;

public class Test {

  public static void main(String[] args) {
    // create
    LinkedList list = new LinkedList();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("안중근");
    list.add("윤봉길");
    list.add("김구");
    list.add("유관순");
    System.out.println(list.size());
    // read
    printList(list);
    // delete
    list.remove(0); // 홍길동
    list.remove(0); // 임꺽정
    list.remove(list.size - 1); // 유관순
    list.remove(1); // 윤봉길
    list.remove(list.size - 1); // 김구
    // 지우고 다시 출력해보기
    printList(list);
    list.remove(0);
    list.add("홍길동");
    list.add("임꺽정");
    list.add("안중근");
    list.add("윤봉길");
    list.add("유관순");
    printList(list);

    list.add(0, "김구");
    list.add(0, "김구2");
    System.out.println(list.size);
    printList(list);
    list.add(6, "김상옥");
    printList(list);
  }

  static void printList(LinkedList list) {
    // Iterator를 통해 목록에서 값 꺼내기
    // Iterator 디자인 패턴 적용
    Iterator iterator = new ListIterator(list);
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + ",");
    }
    System.out.println();
    System.out.println("------------------------------------------------");
  }

}

