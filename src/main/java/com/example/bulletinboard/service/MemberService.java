package com.example.bulletinboard.service;

import com.example.bulletinboard.repositroy.CustomMemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final CustomMemberRepository customMemberRepository;

    public MemberService(CustomMemberRepository customMemberRepository) {this.customMemberRepository= customMemberRepository;}


}
