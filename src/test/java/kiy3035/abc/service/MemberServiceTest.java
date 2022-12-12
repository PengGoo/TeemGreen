//package kiy3035.abc.service;
//
//import kiy3035.abc.domain.User1;
//import kiy3035.abc.repository.MemoryMemberRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//class MemberServiceTest {
//
//    MemberService memberService;
//    MemoryMemberRepository memberRepository;
//
//    @BeforeEach
//    public void beforeEach() {
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);
//    }
//
//    @AfterEach
//    public void afterEach() {
//        memberRepository.clearStore();
//    }
//
//    @Test
//    public void 회원가입() throws Exception {
//        //Given
//        User1 member = new User1();
//        member.setName("hello");
//        //When
//        Long saveId = memberService.join(member);
//        //Then
//        User1 findMember = memberRepository.findById(saveId).get();
//        assertEquals(member.getName(), findMember.getName());
//    }
//
//    @Test
//    public void 중복_회원_예외() throws Exception {
//        //Given
//        User1 member1 = new User1();
//        member1.setName("spring");
//        User1 member2 = new User1();
//        member2.setName("spring");
//        //When
//        memberService.join(member1);
//        IllegalStateException e = assertThrows(IllegalStateException.class,
//                () -> memberService.join(member2));//예외가 발생해야 한다.
//        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    }
//
//}