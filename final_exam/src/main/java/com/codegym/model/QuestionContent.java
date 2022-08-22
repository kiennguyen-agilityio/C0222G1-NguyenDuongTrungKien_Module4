package com.codegym.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "question_content")
public class QuestionContent {
    @Id
//    @Pattern(regexp = "^KH-[0-9]{4}$", message = "Phải đúng định dạng KH-XXXX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @NotBlank(message = "Không để trống")
    private String title;

//    @NotNull(message = "Không để trống")
    private String content;

//    @NotNull(message = "Không để trống")
    private String answer;

//    @Pattern(regexp = "^(\\d{9})|(\\d{12})$", message = "CMND gồm 9 hoặc 12 số")

    @ManyToOne
    @JoinColumn(name = "question_type_id")
    private QuestionType questionType;
//    @Pattern(regexp = "^09[0-1][0-9]{7}|\\(84\\)\\+9[0-1][0-9]{7}$",
//            message = "Phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String dateCreate;

//    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$",
//            message = "Phải đúng định dạng abc@xyz.com")

//    @NotBlank(message = "Không để trống")
    private String status;

    public QuestionContent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
