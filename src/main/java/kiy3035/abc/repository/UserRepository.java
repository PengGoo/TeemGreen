package kiy3035.abc.repository;

import kiy3035.abc.domain.User1;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

// CRUD 함수를 들고있음
// @Repository 어노테이션이 없어도 IOC가 된다
public interface UserRepository extends JpaRepository<User1,Long>  {

     // select * from User1 where user_id = ?
     User1 findByUserid(String userid);


/*   @Query("select u from User1 u where user_email = :user_email and user_pw = :user_pw")
    User1 findUser(@Param("user_email") String user_email, @Param("user_pw") String user_pw);*/

}
