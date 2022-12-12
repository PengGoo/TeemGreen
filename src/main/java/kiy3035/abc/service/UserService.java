package kiy3035.abc.service;

import kiy3035.abc.domain.User1;
import kiy3035.abc.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * 회원가입
     */
    public Long join(User1 user) {

        validateDuplicateUser(user); // 중복 회원 검증
        userRepository.save(user);
        return user.getIdx();
    }

    private void validateDuplicateUser(User1 user) {
        userRepository.findByName(user.getUser_name())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    /**
     * id로 회원 조회
     */
    public List<User1> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User1> findOne(Long userId) {
        return userRepository.findById(userId);
    }
}