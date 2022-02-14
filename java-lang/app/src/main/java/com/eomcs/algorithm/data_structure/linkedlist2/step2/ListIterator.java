package com.eomcs.algorithm.data_structure.linkedlist2.step2;

// 컬렉션의 값을 조회 하는 일을 수행한다.
//
public class ListIterator implements Iterator{

  LinkedList list;
  int cursor;

  public ListIterator(LinkedList list) {
    this.list = list;
  }
  // 다음에 값이 잇는지 확인
  @Override
  public boolean hasNext() {
    return cursor < list.size();
  }
  // 현재 위치 값에서 값 꺼내기
  @Override
  public Object next() {
    return list.get(cursor++);
  }
}
