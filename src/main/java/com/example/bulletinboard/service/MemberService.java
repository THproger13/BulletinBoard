package com.example.bulletinboard.service;

import com.example.bulletinboard.dto.MemberDTO;
import com.example.bulletinboard.entity.MemberEntity;
import com.example.bulletinboard.repositroy.CustomMemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final CustomMemberRepository customMemberRepository;
    private final PasswordEncoder passwordEncoder;


    public MemberService(CustomMemberRepository customMemberRepository, PasswordEncoder passwordEncoder) {
        this.customMemberRepository= customMemberRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerUser(MemberDTO memberDTO) {
        // 회원가입 로직 구현, 예를 들어 회원 정보 저장
        MemberEntity member = new MemberEntity();
        member.setMemberName(memberDTO.getMemberName());
        member.setMemberEmail(memberDTO.getMemberEmail());
        member.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
        customMemberRepository.save(member);
    }
}
