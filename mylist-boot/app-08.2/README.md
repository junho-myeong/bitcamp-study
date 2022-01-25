### 08.2 DAO 역활 도입: 인터페이스 도입하여 DAO 사용 규칙을 통일하기

- DAO 사용 규칙을 정의 하여 프로그래밍에 일관성을 확보한다.

## 백엔드 개발 실습

### 1단계 - 인터페이스로 DAO 사용 규칙을 정의한다.
- com.eomcs.mylist.dao.BoardDao 인터페이스 정의
  - DAO 객체에 대해 호출하는 메서드의 시그너처를 정의한다.




### 4단계 - JSON 형식으로 데이터를 저장하고 읽는 DAO를 인터페이스 규칙에 따라 작성한다.
 - com.eomcs.mylist.dao.JsonBoardDao 클래스 작성
  - BoardDao 인터페이스 규칙에 따라 작성한다.

### 5단계 - BoardDao 구현체를 SpringBoot가 주입하도록 변경한다.
- com.eomcs.mylist.dao.JsonBoardDao 클래스 변경
  - 클래스 선언부에 @Repository 애노테이션을 붙인다.
- com.eomcs.mylist.dao.BoardController 클래스 변경
  - BoardDao 필드 선언에 @Autowired 를 붙인다.






#
