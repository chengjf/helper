package com.chengjf.uxinhelper.repository;

import com.chengjf.uxinhelper.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
