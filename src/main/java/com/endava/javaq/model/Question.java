package com.endava.javaq.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_QUESTION")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @Column
    private String question;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Answer> answers;

    public Question(String question, Set<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

}
