package com.example.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor
@Entity
public class Article {

    @Id // 이게 ID임! 즉 사람으로 따지면 주민등록 번호!
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 자동 관리. 매 생성 시, 1, 2, ... 증가
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void rewrite(String title, String content) {
        this.title = title;
        this.content = content;
    }
}