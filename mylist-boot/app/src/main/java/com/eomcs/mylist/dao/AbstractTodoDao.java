package com.eomcs.mylist.dao;


import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList;

// 서브 클래스에 공통 분모를 추출하여 슈퍼 클래스를 정의할 경우,
// - 보통 이런 수퍼 클래스는 직접 사용하려고 만든 클래스가 아니다.
// - 단지 서브 클래스에게 공통 분모를 물려 주려고 만든 클래스이다.
// - 이런경우 "추상 클래스"로 선언한다.
// - 또한 추상 클래스 만이 추상메서드를 가질수 있기 때문에
//  추상메서드가 잇는 클래스는 반드시 추상 클래스로 선언해야한다.
//
public abstract class AbstractTodoDao implements TodoDao {

  // 서브 클래스에서 접근해야할 필드라면
  // 접근 범위를 protected로 설정한다.
  protected ArrayList todoList = new ArrayList(); 

  // 1) 데이터를 저장하는 save()메서드가 반드시 있어야 한다.
  //    - insert(), update(), delete(), increaseViewCount() 메서드에서 save() 사용한다.
  //    - 그래서 수퍼 클래스에 save()를 메서드를 둬야한다.
  // 2) 그러나 save()에서 데이터를 저장하는 방법은 서브 클래스 마다 다르다.
  //    - 슈퍼 클래스에서 save()메서드를 구현해 봐야 의미가 없다.
  //    - 왜? 어차피 서브클래스에서 재 정의 할테니까!
  // 데이터를 저장하는것은 subclass 마다 다르기 때문에
  // save()메서드는 추상메서드로 사용해야한다.
  // 3) 서브 클래스에서 오버라이딩 할수 잇도록 접근 가능 해야한다.
  //    -서브 클래스가 다른 패키지에 잇을수 잇다.
  //    - 이런경우 메서드에 접근 범위를 protected로 한다.
  protected abstract void save() throws Exception; 

  @Override
  public int countAll() {
    return todoList.size();
  }

  @Override
  public Object[] findAll() {
    return todoList.toArray();
  }

  @Override
  public void insert(Todo todo) throws Exception {
    todoList.add(todo);
    save();
  }

  @Override
  public Todo findByNo(int no) {
    if (no < 0 || no >= todoList.size()) {
      return null;
    }
    return (Todo) todoList.get(no);
  }

  @Override
  public int update(int no, Todo todo) throws Exception {
    if (no < 0 || no >= todoList.size()) {
      return 0;
    }
    todoList.set(no, todo);
    save();
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    if (no < 0 || no >= todoList.size()) {
      return 0;
    }
    todoList.remove(no);
    save();
    return 1;
  }

}











