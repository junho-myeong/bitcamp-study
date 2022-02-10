package com.eomcs.oop.ex11.overview.step2;

public class QueueIterator implements Iterator {
  MyQueue queue;
  public QueueIterator(MyQueue list) {
    this.queue = list;
  }
  @Override
  public boolean hasNext() {
    return queue.size() > 0;
  }
  @Override
  public Object next() {
    return queue.poll();
  }
}
