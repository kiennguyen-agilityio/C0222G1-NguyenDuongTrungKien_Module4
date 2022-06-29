package com.codegym.blog.model;

import javax.persistence.*;

@Entity(name = "blog")
public class BlogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    private String title;
    private String content;
    @Column(name = "create_date", columnDefinition = "Date")
    private String createDate;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public BlogModel() {
    }

    public BlogModel(int id, String title, String content, String createDate, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
