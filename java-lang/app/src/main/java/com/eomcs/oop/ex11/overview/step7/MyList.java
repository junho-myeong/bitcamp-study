package com.eomcs.oop.ex11.overview.step7;

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
    // anonymous class(익명 클래스)
    // - 클래스의 이름이 없다
    // - 그래서 클래스 클래스를 정의한후 따로 인스턴스를 생성할 수 없다.
    // - 그래서 클래스 정의와 인스턴스 생성이 합쳐져 잇다.
    // 
    return new Iterator() {
      int cursor;
      @Override
      public boolean hasNext() {
        return cursor < MyList.this.size();
      }
      @Override
      public Object next() {
        return MyList.this.get(cursor++);
      }
    };
  }


}
