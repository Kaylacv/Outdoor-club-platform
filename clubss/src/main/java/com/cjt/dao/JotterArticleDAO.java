package com.cjt.dao;


import com.cjt.entity.JotterArticle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JotterArticleDAO  extends JpaRepository<JotterArticle,Integer> {
    JotterArticle findById(int id);
}
