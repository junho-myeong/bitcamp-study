package com.junho.algorithm.data_structer.linkedList.step1;

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

    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ",");
    }
    System.out.println();
    System.out.println("----------------------------------------------");

    list.remove(0);

    System.out.println(list.size());

    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ",");
    }
    System.out.println();
    System.out.println("----------------------------------------------");

    list.add(0, "홍길동0");

    System.out.println(list.size());

    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ",");
    }
    System.out.println();
    System.out.println("----------------------------------------------");
  }

}
