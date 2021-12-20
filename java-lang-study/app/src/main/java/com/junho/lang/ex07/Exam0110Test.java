package com.junho.lang.ex07;

import java.util.Scanner;

public class Exam0110Test {

  // 1단계: 공백을 출력하는 메서드
  static void printSpaces(int len) {
    int spaceCnt = 1;
    while (spaceCnt <= len) {
      System.out.print(" ");
      spaceCnt++;
    }
  }
  // 2단계: 별을 출력하는 메서드
  static void printStars(int len) {
    int starCnt = 1;
    while (starCnt <= len) {
      System.out.print("*");
      starCnt++;
    }
  }
  // 3단계: while문을 for 문으로 바꾸기

  // 4단계: 공백의 갯수 알아내는 메서드
  static int spaceCapacity(int totalLen, int starLen) {
    return (totalLen - starLen)/2;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("밑변의 길이는?");
    int totalLen = sc.nextInt();
    sc.close();


    for (int starLen = 1; starLen <= totalLen; starLen += 2) {
      printSpaces(spaceCapacity(totalLen, starLen));
      printStars(starLen);
      System.out.println();
    }
  }
}


