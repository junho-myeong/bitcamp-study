package com.junho.oop.ex05.d;

public class Sedan extends Car {
  public boolean sunroof;
  public boolean auto;

  Sedan(String maker, String model, int capacity, boolean auto, boolean sunroof) {
    super(maker, model, capacity);
    this.auto = auto;
    this.sunroof = sunroof;
  }
}
