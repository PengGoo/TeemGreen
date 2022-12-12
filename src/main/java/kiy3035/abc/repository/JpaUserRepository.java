package kiy3035.abc.repository;

import kiy3035.abc.domain.User1;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository {

    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User1 save(User1 user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User1> findById(Long idx) {
        User1 user = em.find(User1.class, idx);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User1> findByName(String user_name) {
        List<User1> result = em.createQuery("select u from User1 u where u.user_name = :user_name", User1.class)      // TypeQuery : 반환할 타입을 명확하게 지정할 수 있을 때
                .setParameter("user_name", user_name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<User1> findAll() {
        return em.createQuery("select u from User1 u order by idx asc", User1.class)     // TypeQuery : 반환할 타입을 명확하게 지정할 수 있을 때
                .getResultList();

    }
}
