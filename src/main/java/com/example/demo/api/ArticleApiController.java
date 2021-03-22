package com.example.demo.api;

import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ArticleApiController {

    @Autowired
    private ArticleRepository articleRepository;


    private final ArticleService articleService;

    @PostMapping("/api/articles")
    public Long create(@RequestBody ArticleForm form) {
        log.info(form.toString());


        Article article = form.toEntity();


        Article saved = articleRepository.save(article);
        log.info(saved.toString());


        return saved.getId();
    }

    @GetMapping("/api/articles/{id}")
    public ArticleForm getArticle(@PathVariable Long id) {
        Article entity = articleRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 Article이 없습니다.")
                );

        return new ArticleForm(entity);
    }

    @PutMapping("/api/articles/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody ArticleForm form) {
        Article saved = articleService.update(id, form);
        return saved.getId();
    }

    @DeleteMapping("/api/articles/{id}")
    public Long destroy(@PathVariable Long id) {
        return articleService.destroy(id);
    }
}