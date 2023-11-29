package com.example.bulletinboard.repositroy;

import com.example.bulletinboard.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// 기본 CRUD 작업을 위한 스프링 데이터 REST
@RepositoryRestResource(collectionResourceRel = "members", path = "members")
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 사용자 정의 쿼리 메소드들을 추가할 수 있습니다.
    // 예: 회원 이름으로 검색
}
