package com.chengjf.uxinhelper.entity;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue
    private Long id;
    private String article;

    public Article() {
    }

    @PersistenceConstructor
    public Article(Long id, String article) {
        super();
        this.id = id;
        this.article = article;
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", article=" + article + "]";
    }

    public Long getArticleId() {
        return id;
    }

    public void setArticleId(Long id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

}