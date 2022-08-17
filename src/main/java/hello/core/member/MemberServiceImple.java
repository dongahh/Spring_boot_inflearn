package hello.core.member;

//dip를 위반하고 있는 것.
public class MemberServiceImple implements MemberService{

    private final MemberRepository memberRepostitory = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepostitory.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepostitory.findById(memberId);
    }
}
