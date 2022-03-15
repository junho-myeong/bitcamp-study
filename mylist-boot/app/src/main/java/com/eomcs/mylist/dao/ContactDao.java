// 인터페이스 구현하기
// 인터페이스 사용하는 이유 객체 사용 규칙을 정의하기 위해서이다.
// 즉 같은 기능을 수행하는 메서드에 해서 동일한 규칙으로 메서드 호출과 정의를 하기 위한 문법이다.
package com.eomcs.mylist.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.eomcs.mylist.domain.Contact;

@Mapper // Mybatis 프레임 워크에게 ContactDao는 퍼시스턴스 이다 그래서 인터페이스 자동 구현해라
public interface ContactDao {

  // 인터페이스는 객체의 메서드 호출 규칙을 정의하는 것이기 때문에
  // 메서드를 작성할 때 메서드 몸체(method body)를 작성하지 말아야한다.
  // 메서드 바디가 없는 메서드를 "추상 메서드(abstract method)"라 부른다.

  // 인터페이스에 모든 메서드는 기본적으로 public 이다 그래서 생략 가능하다.
  // 왜냐?
  // => 모든 규칙은 공개 되어야 사람들이 알기 때문이다.
  int countAll(); // => <select id = "com.eomcs.mylist.dao.ContactDao.countAll"></select> 즉 sql문 실행

  List<Contact> findAll();

  int insert(Contact contact);

  Contact findByNo(int no);

  int update(Contact contact);

  int delete(int no);

  Contact findByEmail(String email);

  List<Contact> findByName(String name);

}
