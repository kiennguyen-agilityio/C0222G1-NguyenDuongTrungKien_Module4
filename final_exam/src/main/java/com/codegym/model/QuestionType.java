package com.codegym.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question_type")
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "questionType")
    @JsonBackReference("questionType")
    private Set<QuestionContent> questionContents  ;

    public QuestionType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<QuestionContent> getQuestionContents() {
        return questionContents;
    }

    public void setQuestionContents(Set<QuestionContent> questionContents) {
        this.questionContents = questionContents;
    }
}
