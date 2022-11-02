package com.example.demo.core.order;

import com.example.demo.core.AppConfig;
import com.example.demo.core.member.Grade;
import com.example.demo.core.member.Member;
import com.example.demo.core.member.MemberService;
import com.example.demo.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {

        // given
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}