package study.spring_rabbitmq.producer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RabbitProducerTest {

    @Autowired
    RabbitProducer rabbitProducer;

    @Test
    @DisplayName("메세지_대량_전송")
    void 메세지_대량_전송() throws Exception {

        for (int i = 0; i < 1000000; i++) {
            rabbitProducer.sendMessage("-", "message" + i);
        }

    }

}