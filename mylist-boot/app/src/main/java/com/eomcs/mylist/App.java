package com.eomcs.mylist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args); // 자바의 모든 클래스는 class라는 내장변수가 존재한다. 거기에는 class에 대한 정보들이 담겨잇다.
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext beanContainer) {
    return args -> {

      System.out.println("빈 컨테이너가 생성한 객체(빈 컨테이너에 들어 있는객체):");

      String[] beanNames = beanContainer.getBeanDefinitionNames();
      for (int i = 0; i <= beanNames.length; i++) {
        Object bean = beanContainer.getBean(beanNames[i]);
        System.out.printf("------> %03d: %s\n", i+1, bean.getClass().getName());
      }

    };
  }

  @RequestMapping("/hello")
  String hello() {
    return "Hello World!";
  }

}
