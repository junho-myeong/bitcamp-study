# 03.3 클래스 사용법 : 클래스 활용 연습

- TodoList 만들기

## 백엔드 개발 실습

### 1단계 - TodoList 요청을 처리할 REST API를 만든다.

- com.eomcs.mylist.Todo 클래스 생성
  - 해야 할 일 데이터를 저장할 수 있는 메모리를 설계한다.
  - Todo 데이터 타입을 정의한다.
- com.eomcs.mylist.ArrayList2 클래스 생성
  - Todo 배열을 다룰 클래스를 정의한다.
  - ArrayList 클래스를 복사해서 변경한다.
- com.eomcs.mylist.TodoController 클래스 생성
  - ContactController를 복사해서 변경한다.
  - check() 메서드를 추가한다.
  - get() 메서드를 제거한다.


## 프론트엔드 개발 실습

### 1단계 - Todo 목록 출력 화면을 만든다.

- /index.html 변경
  - Todo 메뉴 추가
- /todo/form.html 생성
  - /contact/form.html을 복사해서 변경한다.
- /todo/index.html 생성
  - /contact/index.html을 복사해서 변경한다.
  - index-00.html: To-do 목록 화면 구성하기
  - index-01.html: 서버에서 목록 가져오기
  - index-02.html: 동적으로 tr 태그 만들기

### 2단계 - Todo 삭제 기능 추가한다.

- /todo/index.html 변경
  - index-03.html: 삭제 버튼 추가하기
  - index-04.html: 삭제 버튼에 리스너 등록하기
  - index-05.html: 삭제 버튼을 서버의 REST API와 연동하기
  - index-06.html: 삭제 버튼에 리스너 등록하기 II

### 3단계 - Todo 체크 기능 추가한다.

- /todo/index.html 변경
  - index-07.html : 체크 박스 추가하기
  - index-08.html : 체크 박스에 리스너 등록하기
  - index-09.html : 체크 박스를 선택할 때 제목에 취소선 출력하기
  - index-10.html : 체크 박스를 서버의 REST API와 연동하기
  - index-11.html : 서버에서 받아 온 데이터의 상태에 따라 check 상자의 ui를 처리한다.

### 4단계 - Todo 제목을 변경한다.
- /todo/index.html 변경
  - index-12.html : 변경 버튼을 추가한다.
  - index-13.html : 변경 버튼을 누려면 ui를 편집 모드로 전환한다.
  




#
