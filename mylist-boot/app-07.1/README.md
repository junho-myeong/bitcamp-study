### 07.1 파일 API 활용: 데이터를 바이너리 형식으로 읽고 쓰기

- 데이터를 파일에 저장하고 읽는다.

## 백엔드 개발 실습

### 1단계 - 데이터 저장 요청을 받았을 때 파일로 데이터를 저장한다.

- com.eomcs.mylist.ContactContoller 클래스 변경
  - save() 메서드 추가하기
  - GRASP의 information expert용어!

### 2단계 - 페이지 컨트롤러 객체가 생성될 때 파일에서 데이터를 로딩한다.

- com.eomcs.mylist.BookController 클래스 변경
  - 파일에서 데이터를 로딩하는 코드를 생성자에 추가한다.
  

### 2단계 - 여러 프로젝트에서 일반적인 용도로 사용하는 클래스는 utill 패키지로 분류한다.

### 3단계 - 페이지 컨트롤러 역활을 수행하는 클래스를 controller 패키지로 분류한다.

-com.eomcs.mylist.Controller 패키지 생성
-XxxController 클래스를 controller 패키지로 이동한다.
