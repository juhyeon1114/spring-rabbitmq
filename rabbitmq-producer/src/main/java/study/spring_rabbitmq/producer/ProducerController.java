package study.spring_rabbitmq.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import study.rabbitmq.dto.MessageDTO;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final RabbitProducer rabbitProducer;

    @PostMapping("/send/{key}")
    public String send(@PathVariable("key") String key, MessageDTO message) throws JsonProcessingException {
        return rabbitProducer.sendMessage(key, message);
    }

}
