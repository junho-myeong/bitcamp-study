### 21.1 Log4j 적용하기(우리가 프로그램이 잘 실행되는지 확인하기 위해 console.log 하는것은 배포할때 필요 없는데 실수로 들어갈수 잇다 그때를 대비해서 사용하는것이다.)

- Log4j 기능 활성화 시키기

## 백엔드 개발 실습

### 1단계 - 스프링부트 기본 로그라이브러리를 제거한다.
  - build.gradle 변경한다.
  - ```
  configurations {
      all {
          exclude group: 'org.springframework.boot', module: 'spring-boot-starter-logging'
      }
  }
    ```

### 2단계 - log4j2 스프링부트 라이브러리를 추가한다.
- bulid.gradle 변경한다.
  - ```implementation 'org.springframework.boot:spring-boot-starter-log4j2'```

### 3단계 - log4j2 설정 파일을 생성한다.
- src/main/resource/log4j2.xml파일을 생성한다.(무조건 root경로에 존재해야한다.)

    <?xml version="1.0" encoding="UTF-8"?>
    <Configuration status="INFO">
      <Appenders> <!-- 장비를 정의하는것이다. -->
        <Console name="stdout" target="SYSTEM_OUT">
          <PatternLayout
            pattern="[%-5level] %d{yyyy-MM-dd} [%t] %c{1} - %msg%n" /> <!-- 5level 디버그, 날짜 스레드 이름  -->
        </Console>
      </Appenders>
      <Loggers>
        <Logger name="com.bts.yomojomo" level="debug">
          <AppenderRef ref="stdout" />
        </Logger>
        <Root level="info">
          <AppenderRef ref="stdout" />
        </Root>
      </Loggers>
    </Configuration>

### 4단계 - 스프링부트 설정 파일에 log4j2 설정 파일의 경로를 지정한다.

- /src/main/resources/application.properties 변경

  logging.config=classpath:log4j2.xml



## 프론트엔드 개발 실습


#
