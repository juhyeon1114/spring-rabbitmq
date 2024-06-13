package study.spring_rabbitmq.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import study.rabbitmq.dto.MessageDTO;

@Slf4j
@Component
public class RabbitConsumer {

    private final ObjectMapper objectMapper;

    public RabbitConsumer() {
        this.objectMapper = new ObjectMapper();
    }

    @RabbitListener(queues = {"q.app.event"}, concurrency = "2")
    public void consumeMessage(Message msg) throws JsonProcessingException {
            String body = new String(msg.getBody());
            MessageDTO dto = objectMapper.readValue(body, MessageDTO.class);

            log.info("dto.getId()={}", dto.getId());
            log.info("dto.getMessage()={}", dto.getMessage());
    }

    @RabbitListener(queues = {"q.test.2"})
    public void consumeMessage2(Message msg) throws JsonProcessingException {
        String body = new String(msg.getBody());

        log.info(body);
    }

}
