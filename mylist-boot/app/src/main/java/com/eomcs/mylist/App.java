package com.eomcs.mylist;

import javax.sql.DataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {
  // 클래스 안에는 변수 선언 , 메서드 선언, staitc 블록 같은거 가능 
  // 단 , 조건만 반복문 try ~catch 불가능!

  //  public static Connection con;

  // DB 커넥션풀 준비
  // 모든 커넥션 풀은 DataSource 인터페이스 규칙에 따라 만들어진다.
  public static DataSource dataSource; // DataSource는 인터페이스이다 그 밑에 자식들을 언제든지 변수에 받을수잇다.

  //  static {
  //    try { // 여기서 try리소스 하지 않는 이유는 DAO에서 사용하기 위해 만드는것이지 
  //      // 여기서 사용하고 끊내려는것이 아니다
  //      con = DriverManager.getConnection( 
  //          "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
  //    } catch (Exception e) {
  //      System.out.println("DB연결 중 오류 발생");
  //      e.printStackTrace();
  //    }
  //  }


  // Spring 프레임 워크(IoC = 객체풀)에서 객체를 생성한 후 보관하도록 만드는 방법
  @Bean // => 스프링 프레임워크에게 다음 메서드를 호출한 후 이 메서드가 리턴하는 값을 스프링 부트에 보관하라고 지시한다.
  public DataSource createDataSource() {
    System.out.println("크리에이트 데이타 소스 호출됨!");
    try {
      DriverManagerDataSource connectionPool =new DriverManagerDataSource(); // DB커넥션 풀 준비
      connectionPool.setDriverClassName("org.mariadb.jdbc.Driver"); // 커넥션 풀에서 어떤 DB를 사용할것인지
      connectionPool.setUrl("jdbc:mariadb://localhost:3306/studydb"); // 커넥션 풀에서 어떤 주소로 찾아 갈것인지
      connectionPool.setUsername("study"); 
      connectionPool.setPassword("1111");

      return connectionPool;
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args); // 스프링부트를 실행
  }

  //@Bean
  public CommandLineRunner commandLineRunner(ApplicationContext beanContainer) {
    return args -> {

      System.out.println("빈 컨테이너가 생성한 객체(빈 컨테이너에 들어 있는 객체):");

      String[] beanNames = beanContainer.getBeanDefinitionNames();
      for (int i = 0; i < beanNames.length; i++) {
        Object bean = beanContainer.getBean(beanNames[i]);
        System.out.printf("----> %03d: %s\n", i + 1, bean.getClass().getName());
      }

    };
  }

  @RequestMapping("/hello")
  String hello() {
    return "Hello World!";
  }

}
