package com.example.demo.core;

import com.example.demo.core.discount.DiscountPolicy;
import com.example.demo.core.discount.FixDiscountPolicy;
import com.example.demo.core.member.MemberRepository;
import com.example.demo.core.member.MemberService;
import com.example.demo.core.member.MemberServiceImpl;
import com.example.demo.core.member.MemoryMemberRepository;
import com.example.demo.core.order.OrderService;
import com.example.demo.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
}
