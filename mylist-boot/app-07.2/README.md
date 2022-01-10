# 07.2 파일 API 활용: 상속 문법을 이용해 읽고 쓰기 기능 확장

- 상속을 이용하여 한 줄 단위로 읽고 쓰는 기능을 추가한다.

## 백엔드 개발 실습

### 1단계 - FileReader 클래스의 기능을 확장한다.

- com.eomcs.io.FileReader2 클래스 생성
  - FileReader를 상속 받아 FileReader2 클래스를 정의한다.
  - readLine() 메서드를 추가한다: 한 줄 단위로 읽는다.

### 2단계 - 페이지 컨트롤러 객체가 생성될 때 파일에서 한 줄의 데이터를 읽어 객체로 로딩한다.

- com.eomcs.mylist.controller.XxxController 클래스의 생성자 변경
  - FileReader 대신 이 클래스의 서브 클래스인 FileReader2를 사용하여 데이터를 읽는다.


### 3단계 - 데이터 저장 요청을 받았을 때 파일에 한 줄씩 출력하는 기능을 추가한다.

- com.eomcs.io.FileWriter2 클래스 생성
  - FileWriter를 상속 받아 FileWriter2 클래스를 정의한다.
  - println() 메서드를 추가: 한 줄 단위로 출력하는 기능을 추가한다.


### 4단계 - FileWriter 대신 FileWriter2 클래스를 이용하여 데이터를 출력한다.
 - com.eomcs.mylist.controller.XxxController 클래스 변경
  - save() 메서드 변경


## 프론트엔드 개발 실습








#
