package com.eomcs.mylist.controller;

import java.io.FileReader;
import java.io.FileWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList;

@RestController 
public class TodoController {

  ArrayList todoList = new ArrayList();

  public TodoController() throws Exception{
    System.out.println("TodoController 호출됨!!");

    FileReader in = new FileReader("Todo.csv");

    StringBuilder buf = new StringBuilder();
    int c;
    while (true) {
      c = in.read(); // 파일에서 한 문자를 읽는다!
      if (c == -1) // 만약 더이상 읽을 문자가 없다면 반복문을 종료한다.
        break;
      if (c == '\n') { // 만약 읽은 문자가 줄바꿈이라면, 지금까지 읽은 csv 데이터를 분석하여 Contact 객체에 담는다.!! // 파일에서 읽을 데이터를 담을 객체준비, 그리고 객체를 초기화 시킨다.
        todoList.add(new Todo(buf.toString())); // 스태틱 메서드를 사용
        buf.setLength(0); // 다음데이터를 읽기 위해 버퍼를 초기화 시킨다.
      }else { // 문자를 읽을때 마다 buf에 일시 보관한다,
        buf.append((char) c);
      }
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
    FileWriter out = new FileWriter("todo.csv"); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 파일이 생성된다.

    Object[] arr = todoList.toArray();
    for (Object obj: arr) {
      Todo todo = (Todo) obj;
      out.write(todo.toCsvString() + "\n");
    }
    out.close(); // 파일이랑 systemin 같은것들은 사용하고 닫아 주는 습관 들이기
    return 0;
  }
}




