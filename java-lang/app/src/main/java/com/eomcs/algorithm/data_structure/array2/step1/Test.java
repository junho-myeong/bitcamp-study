package com.eomcs.algorithm.data_structure.array2.step1;

import com.eomcs.algorithm.data_structure.array2.Score;

public class Test {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    // add()메서드는 Object 타입을 받는다 그래서 
    // 다형적 변수로 Score 타입도 받을수잇다.
    // 그치만 get()에서 조회 할때
    // get()는 Object타입을 리턴한다.
    // 그래서 Score 객체에 담을수가 없다.
    // 그래서 형변환하는 코드를 꼭써줘야한다.
    list.add(new Score("홍길동", 100, 100, 100));
    list.add(new Score("임꺽정", 90, 90, 90));
    list.add(new Score("유관순", 80, 80, 80));
    list.add(new Score("안중근", 70, 70, 70));
    list.add(new Score("윤봉길", 60, 60, 60));
    for (int i = 0; i < list.size(); i++) {
      // 불편1:
      // => 목록에서 값을 꺼낼 때마다 원래의 타입으로 형변환 해야 한다.
      Score s = (Score) list.get(i);
      System.out.printf("%s: %d, %f\n", s.name, s.sum, s.aver);
    }
  }
}
