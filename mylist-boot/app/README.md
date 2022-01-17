### 07.4 파일 API 활용: 데코레이터 패턴을 이용한 읽고 쓰기 기능 확장

- I/O API의 데코레이터

## 백엔드 개발 실습

### 1단계 - FileReader 클래스의 기능을 확장한다.

- com.eomcs.io.FileReader2 클래스 변경
  - FileReader를 포함한다.
  - readLine() 메서드를 추가한다: 한 줄 단위로 읽는기능을 추가한다.
   - 한 줄 단위로 읽는 기능을 추가한다.
   - 실제 데이터를 읽는 작업은 FileReader에게 위임한다.

### 2단계 - FileReader 대신 FileReader2 클래스를 사용하여 데이터를 읽는다.

- com.eomcs.mylist.controller.XxxController 클래스의 생성자 변경
  - FileReader 대신 이 클래스의 서브 클래스인 FileReader2를 사용하여 데이터를 읽는다.


### 3단계 - FileWriter 기능을 확장한다.

- com.eomcs.io.FileWriter2 클래스 변경
  - FileWriter를 포함한다.
  - println() 메서드를 추가: 한 줄 단위로 출력하는 기능을 추가한다.
   - 한 줄 단위로 


### 4단계 - FileWriter 대신 FileWriter2 클래스를 이용하여 데이터를 출력한다.
 - com.eomcs.mylist.controller.XxxController 클래스 변경
  - save() 메서드 변경











#
