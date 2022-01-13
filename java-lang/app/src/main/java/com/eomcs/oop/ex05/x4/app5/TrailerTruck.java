package com.eomcs.oop.ex05.x4.app5;

import com.eomcs.oop.ex05.x4.app2.Truck;
import com.eomcs.oop.ex05.x4.app3.CampingTrailer;

public class TrailerTruck extends Truck {
  CampingTrailer trailer;
  // 트레일러 붙이는 기능 추가
  public void setTrailer(CampingTrailer trailer) {
    this.trailer = trailer;
    this.trailer.aircon = "on";
    System.out.println(this.trailer.aircon);
  }

  @Override
  public void run() {
    // 트레일러 장착 기능이 추가 되었다면 다음과 같이 run()메서드를 변경 해야한다.
    if (trailer == null) {
      super.run(); // 오버라이딩 하기 전에 메서드를 실행해라
    }else {
      System.out.println("조심히 움직인다.");
    }
  }
}
