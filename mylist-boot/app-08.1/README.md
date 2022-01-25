# 07.6 파일 API 활용: 데이터를 객체 단위로 읽고 쓰기

- 직렬화 도구를 사용하여 인스턴스를 읽고 쓴다.

## 백엔드 개발 실습

### 1단계 - BoardController 클래스에서 데이터 보관 처리 코드를 분리하여 CSV BoardDao 클래스로 정의한다.
- com.eomcs.mylist.dao.CsvBoardDao 클래스 생성
  - BoardController에서 데이터 보관 처리와 관련된 코드를 가져온다.
- com.eomcs.mylist.controller.BoardController 클래스 변경
 - 데이터 처리 코드를 CsvBoard로 옮긴다.



### 2단계 - 데이터를 저장할 때 CSV 포멧 대신 Binary 형식으로 저장한다.

- com.eomcs.mylist.dao.BinaryBoardDao 클래스 생성
  - 인스턴스의 각 필드를 바이트 배열로 저장한다.
- com.eomcs.mylist.dao.BinaryBoardDao 클래스 변경
 

### 4단계 - interface로 DAO사용 규칙을 정의한다.
 - com.eomcs.mylist.dao.BoardDao 인터페이스 정의
  - DAO객체에 대해 호출하는 메서드의 시그너쳐를 정의한다.
  - 일관된 호출이 가능하다.
- com.eomcs.mylist.dao.XxxDao 클래스 변경
  - BoardDao 규칙에 따라 클래스를 작성한다.
- com.eomcs.mylist.controller.boardController 클래스 변경
  - BoardDao 규칙에 따라 

## 프론트엔드 개발 실습








#
