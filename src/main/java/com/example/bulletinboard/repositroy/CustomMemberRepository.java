package com.example.bulletinboard.repositroy;

import com.example.bulletinboard.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 복잡한 비즈니스 로직이나 커스텀 엔드포인트가 필요한 경우
// 컨트롤러와 서비스를 사용하는 전통적인 방법
@Repository
public interface CustomMemberRepository extends JpaRepository<MemberEntity, Long> {
    // 커스텀 쿼리 메소드들을 추가할 수 있습니다.
}
