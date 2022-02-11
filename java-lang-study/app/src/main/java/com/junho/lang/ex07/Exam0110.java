package com.junho.lang.ex07;

import java.util.Scanner;

public class Exam0110 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("밑변의 길이는?");
    int totalLen = sc.nextInt();
    sc.close();
    System.out.println("test");

    int starLen = 1;
    while (starLen <= totalLen) {
      // 빈공간 출력
      int spaceCnt = 1;
      int spaceLen = (totalLen - starLen) /2;
      while (spaceCnt <= spaceLen) {
        System.out.print(" ");
        spaceCnt++;
      }
      // 별 출력
      int starCnt = 1;
      while (starCnt <= starLen) {
        System.out.print("*");
        starCnt++;
      }
      System.out.println();
      starLen += 2;
    }
  }
}
