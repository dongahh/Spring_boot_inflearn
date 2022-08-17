package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;   //할인 급액

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade()== Grade.VIP) {//enum 타입은 == 쓰는 것이 맞음.
            return discountFixAmount;

        }else{
            return 0;
        }

    }
}
