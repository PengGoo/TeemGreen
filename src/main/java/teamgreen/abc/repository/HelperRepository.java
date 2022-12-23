package teamgreen.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teamgreen.abc.domain.Helper;
import teamgreen.abc.domain.User1;

// CRUD 함수를 들고있음
// @Repository 어노테이션이 없어도 IOC가 된다
public interface HelperRepository extends JpaRepository<Helper,Long>  {

     // select * from User1 where user_id = ?
     Helper findByHelperid(String helper_id);


/*   @Query("select u from User1 u where user_email = :user_email and user_pw = :user_pw")
    User1 findUser(@Param("user_email") String user_email, @Param("user_pw") String user_pw);*/

}
