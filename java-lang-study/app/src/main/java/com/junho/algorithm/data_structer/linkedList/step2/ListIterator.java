package com.junho.algorithm.data_structer.linkedList.step2;

public class ListIterator implements Iterator{
  LinkedList list;
  int cursor;
  public ListIterator(LinkedList list) {
    this.list = list;
  }
  @Override
  public boolean hasNext() {
    return cursor < list.size();
  }
  @Override
  public Object next() {
    return list.get(cursor++);
  }
}
