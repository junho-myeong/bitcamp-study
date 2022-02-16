package com.eomcs.app2.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.eomcs.app2.vo.Score;
import com.eomcs.util.Prompt;

public class ScoreHandler {
  ArrayList<Score> scores = new ArrayList<>();

  ObjectInputStream in;
  ObjectOutputStream out;
  public ScoreHandler(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }

  public void create() throws Exception {
    Score score = new Score();
    score.setName(Prompt.promptString("이름?"));
    score.setKor(Prompt.promptInt("국어?"));
    score.setEng(Prompt.promptInt("영어?"));
    score.setMath(Prompt.promptInt("수학?"));
    out.writeUTF("insert");
    out.writeObject(score);
    out.flush();

    String status = in.readUTF();
    if (status.equals("sucees")) {
      int count = in.readInt();
      if (count == 1) {
        System.out.println("입력성공");
      } else {
        System.out.println("입력실패");
      }
    } else {
      System.out.println(in.readUTF());
    }
  }

  public void list() throws Exception {
    out.writeUTF("selectList");
    out.flush();
    String status = in.readUTF();
    if (status.equals("sucees")) {
      Score[] scores = (Score[]) in.readObject();
      int count = 0;
      //ArrayList는 Iterator 구현체이기 때문에 for(:)문을 사용할수 잇다.
      for (Score score : scores) {
        System.out.printf("%d: %s, %d, %.1f", // 소수점 이하 한자리만 출력하라
            count++,
            score.getName(),
            score.getSum(),
            score.getAver());
        System.out.println();
      }
    } else {
      System.out.println(in.readUTF());
    }
  }

  public void detail() throws Exception {
    int no = Prompt.promptInt("번호? ");
    out.writeUTF("selectOne");
    out.writeInt(no);
    out.flush();

    String status = in.readUTF();
    if (status.equals("sucees")) {
      Score score = (Score) in.readObject();
      System.out.printf("이름: %s\n", score.getName());
      System.out.printf("국어: %d\n", score.getKor());
      System.out.printf("영어: %d\n", score.getEng());
      System.out.printf("수학: %d\n", score.getMath());
      System.out.printf("합계: %d\n", score.getSum());
      System.out.printf("평균: %.1f\n", score.getAver());
    } else {
      System.out.println(in.readUTF());
    }
  }
  public void update() throws Exception {
    int no = Prompt.promptInt("번호? ");
    out.writeUTF("selectOne");
    out.writeInt(no);
    out.flush();

    String status = in.readUTF();
    if (status.equals("sucees")) {
      Score old = (Score) in.readObject();
      Score score = new Score();
      score.setName(Prompt.promptString("이름(%s)?", old.getName())); 
      score.setKor(Prompt.promptInt("국어(%d)?", old.getKor())); // 메서드 통해서 변수에 접근하는게 캡슐링 하기위함이다.
      score.setEng(Prompt.promptInt("영어(%d)?", old.getEng()));
      score.setMath(Prompt.promptInt("수학(%d)?", old.getMath()));
      out.writeUTF("update");
      out.writeInt(no);
      out.writeObject(score);
      out.flush();

      status = in.readUTF();
      if (status.equals("sucees")) {
        int count = in.readInt();
        if (count == 1) {
          System.out.println("업데이트성공");
        } else {
          System.out.println("업데이트실패");
        }
      } else {
        System.out.println(in.readUTF());
      }
    } else {
      System.out.println(in.readUTF());
    }
  }

  public void delete() throws Exception {
    int no = Prompt.promptInt("번호? ");
    out.writeUTF("selectOne");
    out.writeInt(no);
    out.flush();

    String status = in.readUTF();
    if (status.equals("sucees")) {
      int count = in.readInt();
      if (count == 1) {
        System.out.println("삭제성공");
      } else {
        System.out.println("삭제실패");
      }
    } else {
      System.out.println(in.readUTF());
    }

  }
}
