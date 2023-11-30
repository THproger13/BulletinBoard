package com.example.bulletinboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "member_table")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String memberName;

    @Column(length = 50, nullable = false, unique = true) // 데이터베이스 제약조건 추가
    private String memberEmail;

    @Column(length = 100, nullable = false) // 최대 길이를 100으로 설정하여 해시된 비밀번호 저장 가능
    private String password;

    // 연관관계
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BoardEntity> boards = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentEntity> comments = new ArrayList<>();

    // 기타 필요한 메서드들...
}
