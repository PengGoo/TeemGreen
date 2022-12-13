//package kiy3035.abc.repository;
//
//import kiy3035.abc.domain.User1;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//class MemoryMemberRepositoryTest {
//
//    MemoryMemberRepository repository = new MemoryMemberRepository();
//
//    // 테스트 끝날 때마다 clear 해줘서 순서 상관 없게 해줌
//    @AfterEach
//    public void afterEach() {
//        repository.clearStore();
//    }
//
//    @Test
//    public void save() {
//        User1 member = new User1();
//        member.setName("spring");
//
//        repository.save(member);
//
//        User1 result = repository.findById(member.getId()).get();
//        assertThat(member).isEqualTo(result);
//
//    }
//
//    @Test
//    public void findByName() {
//        User1 member1 = new User1();
//        member1.setName("spring1");
//        repository.save(member1);
//
//        User1 member2 = new User1();
//        member2.setName("spring2");
//        repository.save(member2);
//
//        User1 result = repository.findByName("spring1").get();
//
//        assertThat(result).isEqualTo(member1);
//
//    }
//
//    @Test
//    public void findAll() {
//        User1 member1 = new User1();
//        member1.setName("spring1");
//        repository.save(member1);
//
//        User1 member2 = new User1();
//        member2.setName("spring2");
//        repository.save(member2);
//
//        List<User1> result = repository.findAll();
//
//        assertThat(result.size()).isEqualTo(2);
//
//
//
//    }
//
//
//}
