package kiy3035.abc.domain;

import javax.persistence.*;

@Entity
public class User1 {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String user_id;
    private Long   user_age;
    private String user_pw;
    private String user_name;
    private String user_tel;
    private String user_comment;
    private String user_profile;
    private String user_kakao;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Long getUser_age() {
        return user_age;
    }

    public void setUser_age(Long user_age) {
        this.user_age = user_age;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }
    public String getUser_comment() {
        return user_comment;
    }

    public void setUser_comment(String user_comment) {
        this.user_comment = user_comment;
    }

    public String getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(String user_profile) {
        this.user_profile = user_profile;
    }

    public String getUser_kakao() {
        return user_kakao;
    }

    public void setUser_kakao(String user_kakao) {
        this.user_kakao = user_kakao;
    }

}
