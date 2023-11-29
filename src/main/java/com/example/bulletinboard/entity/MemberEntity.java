package com.example.bulletinboard.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter(AccessLevel.PRIVATE)
@Getter
@ToString
@Entity
@Table(name = "member_table")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "이름은 필수 입력 값 입니다.")
    @Size(max = 20, message = "이름은 최대 20자까지 허용 됩니다.")
    @Column(length = 20, nullable = false)
    private String memberName;

    @NotBlank(message = "이메일은 필수 입력 값 입니다.")
    @Email(message = "이메일 형식이 유효하지 않습니다.")
    @Size(max = 50)
    @Column(length = 50, nullable = false, unique = true) // 데이터베이스 제약조건 추가
    private String memberEmail;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    @Column(length = 100, nullable = false) // 최대 길이를 100으로 설정하여 해시된 비밀번호 저장 가능
    private String password;

    // Getters and setters are omitted for brevity

    // 연관관계
    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BoardEntity> boards = new ArrayList<>();

    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentEntity> comments = new ArrayList<>();

}
