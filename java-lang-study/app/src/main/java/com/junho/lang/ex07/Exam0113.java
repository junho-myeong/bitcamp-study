package com.junho.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 후
// 3 단계 : while 대신 for 문 사용하기.
public class Exam0113 {
  // 공백 출력 메서드
  static void printSpace(int len) {
    // 별 앞에 공백 출력
    int spaceCnt = 1;
    while (spaceCnt <= len) {
      System.out.print(" ");
      spaceCnt++;
    }
  }
  // 별 출력 메서드
  static void printStar(int len) {
    int starCnt = 1;
    while (starCnt <= len) {
      System.out.print("*");
      starCnt++;
    }
  }
  // 3 단계 while 대신 for문 이용하기

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpace((len - starLen) /2);
      printStar(starLen);
      System.out.println();
    }


  }
}