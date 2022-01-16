package com.junho.oop.ex05.b;

public class Car {
  public String model;
  public String maker;
  public int capacity;

  // 필드를 추가한다.
  public boolean sunroof;
  public boolean auto;

  public Car() {}

  // 기존에 이 클래스를 사용하던 프로젝트는 이 생성자를 사용하기 때문에
  // 현재 이 생성자를 변경 할수는 없다.
  // 즉 이생성자에서 인스턴스 필드를
  // 초기화 하기 위해 여기에 바로 파라미터를 추가하면 안된다.
  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  // 그래서 새로운 인스턴스를 만들어 줘야한다.
  public Car(String model, String maker, int capacity, boolean sunroof, boolean auto) {
    // 현재 우리는 위에 생성자를 이용해서 좀더 쉽게 코드를 짤순잇다.
    // 파라미터의 타입과 갯수와 순서를 보고 컴파일러가 
    // 자동으로 이 파라미터와 관련된 생성자를 찾는다.
    this(model, maker, capacity);

    this.sunroof = sunroof;
    this.auto = auto;
  }
}
