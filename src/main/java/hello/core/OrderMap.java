package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImple;

public class OrderMap {
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImple();
        OrderService orderService = new OrderServiceImple();

        Long memberId = 1l;
        //멤버에 데이터 저장;.
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order.toString());
        System.out.println("order.calculaterPrice() = " + order.calculaterPrice());
    }

}
