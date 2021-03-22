package com.example.demo.service;

import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public Article update(Long id, ArticleForm form) {
        log.info("form: " + form.toString());


        Article target = articleRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 Article이 없습니다.")
                );
        log.info("target: " + target.toString());


        target.rewrite(form.getTitle(), form.getContent());
        Article saved = articleRepository.save(target);
        log.info("saved: " + saved.toString());

        return saved;
    }

    @Transactional
    public Long destroy(Long id) {
        Article target = articleRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 Article이 없습니다.")
                );
        articleRepository.delete(target);
        return target.getId();
    }

}
