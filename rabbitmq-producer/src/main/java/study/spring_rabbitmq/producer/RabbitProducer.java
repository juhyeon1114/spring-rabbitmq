package study.spring_rabbitmq.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitProducer {

    private final RabbitTemplate rabbitTemplate;

    public String sendMessage(String routingKey, Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(obj);

        rabbitTemplate.convertAndSend("ex.app.event", routingKey, json);
        return json;
    }

}
