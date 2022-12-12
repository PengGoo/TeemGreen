//package kiy3035.abc.service;
//
//import kiy3035.abc.domain.User1;
//import kiy3035.abc.repository.MemberRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@SpringBootTest
//@Transactional      // 테스트 완료 후에 항상 롤백한다(이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향 X)
//class MemberServiceIntegrationTest {
//
//    @Autowired MemberService memberService;
//    @Autowired MemberRepository memberRepository;
//
//    @Test
//    void 회원가입() {
//        //Given
//        User1 member = new User1();
//        member.setName("spring");
//
//        //When
//        Long saveId = memberService.join(member);
//
//        //Then
//        User1 findMember = memberService.findOne(saveId).get();
//        assertThat(member.getName()).isEqualTo(findMember.getName());
//    }
//
//    @Test
//    public void 중복_회원_예외() {
//        //Given
//        User1 member1 = new User1();
//        member1.setName("spring");
//
//        User1 member2 = new User1();
//        member2.setName("spring");
//
//        //When
//        memberService.join(member1);
//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));//예외가 발생해야 한다.
//
////        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    }
//
//}