package com.junho.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 후
//
public class Exam0112 {
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


  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    int starLen = 1;
    while (starLen <= len) {
      printSpace((len - starLen) /2);
      // 별 출력
      printStar(starLen);

      // 출력 줄 바꾸기
      System.out.println();
      starLen += 2;
    }


  }
}