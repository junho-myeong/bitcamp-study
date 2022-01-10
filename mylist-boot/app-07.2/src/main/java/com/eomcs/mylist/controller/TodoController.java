package com.eomcs.mylist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.io.FileWriter2;
import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList;

@RestController 
public class TodoController {

  ArrayList todoList = new ArrayList();

  public TodoController() throws Exception{
    System.out.println("TodoController 호출됨!!");

    com.eomcs.io.FileReader2 in = new com.eomcs.io.FileReader2("Todo.csv");

    String line;
    while ((line = in.readLine()).length() != 0) { // 만약 읽은 문자가 줄바꿈이라면, 지금까지 읽은 csv 데이터를 분석하여 Contact 객체에 담는다.!! // 파일에서 읽을 데이터를 담을 객체준비, 그리고 객체를 초기화 시킨다.
      todoList.add(new Todo(line)); // 스태틱 메서드를 사용
      //      System.out.print((char) c);
    }
    in.close();
  }



  @RequestMapping("/todo/list")
  public Object list() {
    return todoList.toArray(); 
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) {
    todoList.add(todo);
    return todoList.size();
  }

  @RequestMapping("/todo/update")
  public Object update(int index, Todo todo) {
    if (index < 0 || index >= todoList.size()) {
      return 0;
    }
    Todo old = (Todo) todoList.get(index);
    todo.setDone(old.isDone()); // 기존의 체크 정보는 그대로 가져가야한다.

    return todoList.set(index, todo) == null ? 0 : 1;
  }

  @RequestMapping("/todo/check")
  public Object check(int index, boolean done) {
    if (index < 0 || index >= todoList.size()) {
      return 0;  // 인덱스가 무효해서 설정하지 못했다.
    }

    ((Todo) todoList.get(index)).setDone(done);
    return 1; // 해당 항목의 상태를 변경했다.
  }

  @RequestMapping("/todo/delete")
  public Object delete(int index) {
    if (index < 0 || index >= todoList.size()) {
      return 0;
    }
    todoList.remove(index);
    return 1;
  }
  @RequestMapping("/todo/save")
  public Object save() throws Exception {
    FileWriter2 out = new FileWriter2("todo.csv"); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 파일이 생성된다.

    Object[] arr = todoList.toArray();
    for (Object obj: arr) {
      Todo todo = (Todo) obj;
      out.write(todo.toCsvString());
    }
    out.close(); // 파일이랑 systemin 같은것들은 사용하고 닫아 주는 습관 들이기
    return 0;
  }
}




