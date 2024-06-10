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

    @RabbitListener(queues = "q.app.event")
    public void consumeMessage(Message msg) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String body = new String(msg.getBody());
        MessageDTO message = objectMapper.readValue(body, MessageDTO.class);

        log.info("message.getId()={}", message.getId());
        log.info("message.getMessage()={}", message.getMessage());
    }

}
