package oit.is.z1180.kaizi.lec05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Lec05Application {

  public static void main(String[] args) {
    SpringApplication.run(Lec05Application.class, args);
  }

}
