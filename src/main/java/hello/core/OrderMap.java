package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderMap {
    public static void main(String[] args) {

/*
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
*/


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1l;
        //멤버에 데이터 저장;.
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order.toString());
        System.out.println("order.calculaterPrice() = " + order.calculaterPrice());
    }

}
/*
//좋은 객체지향의 원칙
SRP, DIP, OCP 적용
1. 단일책임 -> 수현 객체를 생성하고 연결하는 책임은 AppConfig가 가진다.
2. DIP => 의존관계 역전 (생성자로 클라이언트 코드에 의존관계를 주입하며 추상클래스에만 의존하게 된다. );
3. OCP(개방폐쇄원칙) => 구성객체(App Config)만 수정하면, 사용 영역은를 변경하지 않고 확장할 수 있다?);

 */
