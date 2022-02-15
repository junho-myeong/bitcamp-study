package com.junho.algorithm.data_structer.linkedList.step6;

public class Test {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("홍길동0");
    list.add("홍길동1");
    list.add("홍길동2");
    list.add("홍길동3");
    list.add("홍길동4");
    list.add("홍길동5");
    list.add("홍길동6");

    System.out.println(list.size());

    PintList(list);

    list.remove(0);

    System.out.println(list.size());

    PintList(list);

    list.add(0, "홍길동0");

    System.out.println(list.size());
    PintList(list);

  }

  static void PintList(LinkedList list) {
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + ",");
    }
    System.out.println();
    System.out.println("----------------------------------------------");
  }

}
