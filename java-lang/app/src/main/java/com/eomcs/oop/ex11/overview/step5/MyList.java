package com.eomcs.oop.ex11.overview.step5;

import java.util.Arrays;

public class MyList {
  Object[] arr = new Object[10];
  int size;
  public void add(Object obj) {
    if (size == arr.length) {
      arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1)); // 기존보다 50퍼센트 큰게하라
    }
    arr[size++] = obj;
  }
  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException(); // RuntimeException의 자식이다
    }
    return arr[index];
  }
  public int size() {
    return size;
  }

  public Object remove(int index) { // 손코딩 하는 방법 읽혀 둬야한다
    if (index < 0 || index >=size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    Object old = arr[index];
    for (int i = index; i < (size - 1); i++) { // 맨마지막 꺼는 앞으로 땡길 필요가 없다.
      arr[i] = arr[i + 1];
    }
    arr[--size] = null; // 배열의 크기를 줄이고 마지막 항목에 잇는 값을 null로 초기화 해서 가비지를 줄인다.
    return old;
  }

  public Iterator iterator() {
    return new ListIterator();
  }

  // non-static nested class(논스태틱 중첩 클래스)
  // - inner class라고도 부른다.
  // - ListIterator가 사용할 바깥 클래스 MyList 인스턴스 주소를 저장할 필드와 생성자가 자동으로 추가된다.
  // - 기존의 static nested class 처럼 개발자가 직접 추가할 필요가 없다.
  // - 바깥 클래스의 인스턴스를 사용하는 경우, static nested class로 만드는 것보다 더 편리하다.
  //
  class ListIterator implements Iterator {
    int cursor;

    @Override
    public boolean hasNext() {
      return cursor < MyList.this.size();
    }
    @Override
    public Object next() {
      return MyList.this.get(cursor++);
    }
  }
}
