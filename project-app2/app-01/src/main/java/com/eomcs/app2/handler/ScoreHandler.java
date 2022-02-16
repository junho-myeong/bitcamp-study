package com.eomcs.app2.handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.eomcs.app2.vo.Score;
import com.eomcs.util.Prompt;

public class ScoreHandler {
  ArrayList<Score> scores = new ArrayList<>();

  public ScoreHandler() {
    try (BufferedReader in = new BufferedReader(new FileReader("./score.csv"));){
      String line;
      while ((line = in.readLine()) != null) {
        scores.add(Score.fromCSV(line));
      }

    } catch (Exception e) {
      System.out.println("데이터 로딩중 오류 발생!");
    }
  }

  private void save() {
    try (PrintWriter out = new PrintWriter(new FileWriter("./score.csv"));) {
      for (Score score : scores) {
        out.println(score.toCSV());
      }
    } catch (Exception e) {
      System.out.println("데이터 저장중 오류 발생!");
    }
  }

  public void create() {
    Score score = new Score();
    score.setName(Prompt.promptString("이름?"));
    score.setKor(Prompt.promptInt("국어?"));
    score.setEng(Prompt.promptInt("영어?"));
    score.setMath(Prompt.promptInt("수학?"));
    scores.add(score);
    save();
  }
  public void list() {
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
  }
  public void detail() {
    int no = Prompt.promptInt("번호? ");
    if (no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지 않습니다");
      return; // 메서드를 나가라는 뜻으로 detailScore()메서드를 나가라는것이다.
    }
    Score score = scores.get(no);
    System.out.printf("이름: %s\n", score.getName());
    System.out.printf("국어: %d\n", score.getKor());
    System.out.printf("영어: %d\n", score.getEng());
    System.out.printf("수학: %d\n", score.getMath());
    System.out.printf("합계: %d\n", score.getSum());
    System.out.printf("평균: %.1f\n", score.getAver());
  }
  public void update() {
    int no = Prompt.promptInt("번호? ");
    if (no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지 않습니다");
      return; // 메서드를 나가라는 뜻으로 detailScore()메서드를 나가라는것이다.
    }
    // 예전꺼
    Score old = scores.get(no);
    // 새로 업데이트 하는것
    Score score = new Score();
    score.setName(Prompt.promptString("이름(%s)?", old.getName())); 
    score.setKor(Prompt.promptInt("국어(%d)?", old.getKor())); // 메서드 통해서 변수에 접근하는게 캡슐링 하기위함이다.
    score.setEng(Prompt.promptInt("영어(%d)?", old.getEng()));
    score.setMath(Prompt.promptInt("수학(%d)?", old.getMath()));

    // 대체하겠다는 뜻이다.
    scores.set(no, score);
    save();
  }
  public void delete() {
    int no = Prompt.promptInt("번호? ");
    if (no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지 않습니다");
      return; // 메서드를 나가라는 뜻으로 detailScore()메서드를 나가라는것이다.
    }
    scores.remove(no);
    save();
  }
}
