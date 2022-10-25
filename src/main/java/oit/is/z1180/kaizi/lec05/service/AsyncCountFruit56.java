package oit.is.z1180.kaizi.lec05.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.z1180.kaizi.lec05.model.Fruit;

@Service
public class AsyncCountFruit56 {
  int count = 1;
  private final Logger logger = LoggerFactory.getLogger(AsyncCountFruit56.class);

  @Async
  public void count(SseEmitter emitter) throws IOException {
    logger.info("count start");
    try {
      while (true) {
        logger.info("send:" + count);

        emitter.send(count);
        count++;
        TimeUnit.SECONDS.sleep(1);
      }
    } catch (InterruptedException e) {
      logger.warn("Exception:" + e.getClass().getName() + ":" + e.getMessage());
    }
  }

  @Async
  public void pushFruit(SseEmitter emitter) {
    logger.info("pushFruit start");
    Fruit fruit = new Fruit();
    fruit.setName("桃");
    fruit.setPrice(300);
    for (int i = 0; i < 10; i++) {
      try {
        logger.info("send(fruit)");
        TimeUnit.SECONDS.sleep(1);
        emitter.send(fruit);

      } catch (Exception e) {

        logger.warn("Exception:" + e.getClass().getName() + ":" + e.getMessage());

        break;
      }
    }
    emitter.complete();
  }
}
