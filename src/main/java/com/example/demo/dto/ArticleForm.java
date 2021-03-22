package com.example.demo.dto;

import com.example.demo.entity.Article;
import lombok.Data;

@Data
public class ArticleForm {
    private Long id;
    private String title;
    private String content;


    public Article toEntity() {
        return Article.builder()
                .id(null)
                .title(title)
                .content(content)
                .build();

    }

    public void rewrite(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public ArticleForm(Article entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
