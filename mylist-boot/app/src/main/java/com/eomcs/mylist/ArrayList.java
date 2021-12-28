package com.eomcs.mylist;

public class ArrayList {

  static Object[] list= new Object[5];
  static int size = 0;

  static void add(Object obj) {
    if (size == list.length) { 
      list = grow();
    }
    list[size++] = obj;
  }

  static Object[] grow() {
    Object[] arr = new Object[newLength()];
    copy(list, arr);
    return arr;
  }

  static int newLength() {
    return list.length + (list.length >> 1);
  }

  static void copy(Object[] source, Object[] target) {
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  }

  static Object[] toArray() {
    Object[] arr = new Contact[size]; 
    for (int i = 0; i < size; i++) { 
      arr[i] = list[i]; 
    }
    return arr; 
  }

  static Object remove(int index) {
    Object old = list[index];
    for (int i = index + 1; i < size; i++) {
      list[i - 1] = list[i];
    }
    size--;
    return old;
  }

  static Object set(int index, Object obj) {
    if (index < 0 || index >= size) { // 값이 저장된 위치가 무효한 인덱스라면 
      return null;
    }
    Object old = list[index];
    list[index] = obj;
    return old;
  }

  // 기능:
  // - 이메일로 연락처 정보를 찾는다.
  // - 찾은 연락처의 배열 인덱스를 리턴한다.
  //


  // 기능:
  // - 배열에서 지정한 항목을 삭제한다.
  //


  // 기능:
  // - 배열의 크기를 늘린다.
  // - 기존 배열의 값을 복사해온다.
  //


  // 기능:
  // - 주어진 배열에 대해 50% 증가시킨 새 배열의 길이를 알려준다.
  //


  // 기능: 
  // - 배열을 복사한다.
  // 


  // 기능:
  // - 배열에 저장된 목록만 꺼내 새 배열에 담아 리턴한다.
  //


  // 기능:
  // - 배열에 항목을 추가한다.
  // - 배열이 꽉찼으면 배열의 크기를 늘린다.
  //


  // 기능:
  // - 배열의 특정 위치에 값을 변경한다.
  // - 리턴 값: 
  //   - 변경하기 전에 저장되어 있던 값
  //

}










