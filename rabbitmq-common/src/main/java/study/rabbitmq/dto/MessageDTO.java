package study.rabbitmq.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO implements Serializable {

    private String id;
    private String message;

}
