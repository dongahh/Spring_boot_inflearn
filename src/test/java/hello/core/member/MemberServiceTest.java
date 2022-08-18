package hello.core.member;


import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    AppConfig appConfig = new AppConfig();


    MemberService memberService = appConfig.memberService();
    @Test
    void join(){
        //given = 이런게 주어졌을떄
        Member member =  new Member(1L, "memberA", Grade.VIP);

        //when = 이렇게 했을 떄
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //than = 이렇게 된다.(검증)
        Assertions.assertThat(member).isEqualTo(findMember);



    }
}
