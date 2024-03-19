package com.example.e1_blog_upgrade.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;
    private String blogTitle;
    private LocalDate blogDate;
    private String blogContent;
    private String blogConclusion;
    @ManyToOne
    @JoinColumn(name = "infor_id")
    private Infor infor;

    public Blog() {
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
    @NotBlank(message = "title không được để trống")
    @Pattern(regexp = "^[a-z ]{4,100}$",message = "title không đúng định dạng ")
    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public LocalDate getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(LocalDate blogDate) {
        this.blogDate = blogDate;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getBlogConclusion() {
        return blogConclusion;
    }

    public void setBlogConclusion(String blogConclusion) {
        this.blogConclusion = blogConclusion;
    }

    public Infor getInfor() {
        return infor;
    }

    public void setInfor(Infor infor) {
        this.infor = infor;
    }
}
