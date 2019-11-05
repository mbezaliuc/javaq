package com.endava.javaq.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "T_ANSWER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String answer;

    @Column
    private boolean correct;

    public Answer(String answer, boolean correct) {
        this.answer = answer;
        this.correct = correct;
    }

}
