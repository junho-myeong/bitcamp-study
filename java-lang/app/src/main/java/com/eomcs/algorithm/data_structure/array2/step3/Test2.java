package com.eomcs.algorithm.data_structure.array2.step3;

import com.eomcs.algorithm.data_structure.array2.Score;

public class Test2 {
  public static void main(String[] args) {
    ArrayList<Score> list = new ArrayList<Score>();
    list.add(new Score("홍길동", 100, 100, 100));
    list.add(new Score("임꺽정", 90, 90, 90));
    list.add(new Score("유관순", 80, 80, 80));
    list.add(new Score("안중근", 70, 70, 70));
    list.add(new Score("윤봉길", 60, 60, 60));

    // 불편2: 해결!
    // => 목록에서 다룰 항목에 타입을 정하고, add()메서드 에서 그 타입의 값을 받도록 정의한다.
    // => 그러면 ArrayList를 생성할때 지정한 타입이 아닌경우
    // => 컴파일 오류가 발생한다.
    //    list.add(new String("오호라")); // 컴파일 오류!

    for (int i = 0; i < list.size(); i++) {
      Score s = list.get(i);
      System.out.printf("%s: %d, %f\n", s.name, s.sum, s.aver);
    }
  }
}
