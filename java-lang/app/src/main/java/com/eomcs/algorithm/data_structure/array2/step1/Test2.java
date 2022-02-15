package com.eomcs.algorithm.data_structure.array2.step1;

import com.eomcs.algorithm.data_structure.array2.Score;

public class Test2 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add(new Score("홍길동", 100, 100, 100));
    list.add(new Score("임꺽정", 90, 90, 90));
    list.add(new Score("유관순", 80, 80, 80));
    list.add(new Score("안중근", 70, 70, 70));
    list.add(new Score("윤봉길", 60, 60, 60));

    // 불편2:
    // => 목록에 값을 저장할 때 원하지 않는 타입의 값이 들어가는 것을 막을수 없다.
    // => 이렇게 원하지 않는 값이 들어 가는것을 막는것을 제네릭이라고한다.
    list.add(new String("오호라"));

    for (int i = 0; i < list.size(); i++) {
      Score s = (Score) list.get(i);
      System.out.printf("%s: %d, %f\n", s.name, s.sum, s.aver);
    }
  }
}
