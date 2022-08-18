package hello.core.member;

//dip를 위반하고 있는 것.
public class MemberServiceImple implements MemberService{

    private final MemberRepository memberRepostitory;
    //생성자로 객체를 만들어주면서 추상화에만 의존하게 됨.

    public MemberServiceImple(MemberRepository memberRepository) {
        this.memberRepostitory = memberRepository;

    }

    @Override
    public void join(Member member) {
        memberRepostitory.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepostitory.findById(memberId);
    }
}
