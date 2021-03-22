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

    @Id // 이게 ID임! 즉 사람으로 따지면 주민등록 번호! DB에서는 PK(Primary Key)라고 함!
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 자동 관리. 매 생성 시, 1, 2, ... 증가
    private Long id;

    @Column(length = 100, nullable = false) // 최대 100글자, 비어 있으면 안됨! 추후 SQL 학습
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 텍스트 타입, 비어있으면 안됨! 추후 SQL 학습
    private String content;

    @Builder // 빌더 패턴 적용! 추후 설명..!
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // 내용을 재작성!
    public void rewrite(String title, String content) {
        this.title = title;
        this.content = content;
    }
}