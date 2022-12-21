package kiy3035.abc.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "USER_ID")
    private String userid;

    @Column(name = "USER_EMAIL")
    private String useremail;

    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "USER_PW")
    private String password;


    private Long   user_age;
    private String user_tel;
    private String user_comment;
    private String user_profile;
    private String user_kakao;
    private String user_role;

}
