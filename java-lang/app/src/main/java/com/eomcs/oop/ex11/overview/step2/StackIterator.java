package com.eomcs.oop.ex11.overview.step2;

public class StackIterator implements Iterator {
  MyStack myStack;
  int cursor;

  public StackIterator(MyStack list) {
    this.myStack = list;
  }
  @Override
  public boolean hasNext() {
    return myStack.size() > 0;
  }
  @Override
  public Object next() {
    return myStack.pop();
  }
}
