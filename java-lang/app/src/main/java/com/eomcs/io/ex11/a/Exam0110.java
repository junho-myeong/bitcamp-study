// 인스턴스 입출력 - DataOutputStream으로 인스턴스 출력하기
package com.eomcs.io.ex11.a;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    FileOutputStream fileOut = new FileOutputStream("temp/member.data");
    DataOutputStream out = new DataOutputStream(fileOut); // 자바에 잇는 DataOutputStream 사용

    Member member = new Member();
    member.name = "AB가각간";
    member.age = 27;
    member.gender = true;


    // String을 내보낼때는 처음에 몇개의 데이터가 String인지 나타내준다 
    out.writeUTF(member.name);
    out.writeInt(member.age);
    out.writeBoolean(member.gender);

    out.close();
    System.out.println("데이터 출력 완료!");
  }

}


