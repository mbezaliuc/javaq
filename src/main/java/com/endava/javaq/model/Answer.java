package com.endava.javaq.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Answer {

    @Id
    private Long id;
    private String answer;
    private boolean correct;

}
