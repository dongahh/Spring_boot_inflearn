package hello.core;


import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
AppConfig를 사용하므로써 구성영역과 사용영역으로 구분이 됨.
AppConfig 는 구성역역..
-> 실제 역할을 담당하는 배우와 역할을 캐스팅하고 기획하는 역할이 완전히 분리 될 수 있게 됨.
 */


//애플리케이션 전체를 설정하고 구성한다.
@Configuration
public class AppConfig {

    //return 타입을 구체 클래스로 설정하느 것이 아니라 인터페이스 타입으로!
    @Bean
    public MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
       // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
    @Bean
    public MemberService memberService(){

        return new MemberServiceImple(memberRepository());
    }


    //orderService는 사용하는 사용하는 필드가 두개임!
    @Bean
    public OrderService orderService(){

        return new OrderServiceImple(memberRepository(), discountPolicy());

    }



}
