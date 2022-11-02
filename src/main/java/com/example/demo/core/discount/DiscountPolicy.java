package com.example.demo.core.discount;

import com.example.demo.core.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
