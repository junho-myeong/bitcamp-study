package com.eomcs.mylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.TodoDao;
import com.eomcs.mylist.domain.Todo;

@RestController 
public class TodoController {

  @Autowired
  TodoDao todoDao;

  @RequestMapping("/todo/list")
  public Object list() {
    return todoDao.findAll(); 
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) throws Exception {
    todoDao.insert(todo);
    return todoDao.countAll();
  }

  @RequestMapping("/todo/update")
  public Object update(int index, Todo todo) {
    Todo todo1 = todoDao.findByNo(index);
    if (todo == null) {
      return "";
    }
    return todo1;
  }

  @RequestMapping("/todo/check")
  public Object check(int index, boolean done) {
    if (index < 0 || index >= todoDao.countAll()) {
      return 0;  // 인덱스가 무효해서 설정하지 못했다.
    }


    return 1; // 해당 항목의 상태를 변경했다.
  }

  @RequestMapping("/todo/delete")
  public Object delete(int index) throws Exception {
    if (index < 0 || index >= todoDao.countAll()) {
      return 0;
    }

    todoDao.delete(index);
    return 1;
  }
}




