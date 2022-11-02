package com.example.demo.core.member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
