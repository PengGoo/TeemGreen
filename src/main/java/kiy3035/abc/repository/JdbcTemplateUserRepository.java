package kiy3035.abc.repository;

import kiy3035.abc.domain.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired      // 생성자가 딱 1개일 때 Autowired 생략 가능
    public JdbcTemplateUserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User1 save(User1 user) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("user1").usingGeneratedKeyColumns("idx");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_id", user.getUser_id());
        parameters.put("user_age", user.getUser_age());
        parameters.put("user_pw", user.getUser_pw());
        parameters.put("user_name", user.getUser_name());
        parameters.put("user_tel", user.getUser_tel());
        parameters.put("user_comment", user.getUser_comment());
        parameters.put("user_profile", user.getUser_profile());
        parameters.put("user_kakao", user.getUser_kakao());


        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));
        user.setIdx(key.longValue());
        return user;
    }

    @Override
    public Optional<User1> findById(Long idx) {
        List<User1> result = jdbcTemplate.query("select * from User1 where idx = ?", userRowMapper(), idx);
        return result.stream().findAny();
    }

    @Override
    public Optional<User1> findByName(String user_name) {
        List<User1> result = jdbcTemplate.query("select * from User1 where user_name = ?", userRowMapper(), user_name);
        return result.stream().findAny();
    }

    @Override
    public List<User1> findAll() {
        return jdbcTemplate.query("select * from User1", userRowMapper());
    }

    private RowMapper<User1> userRowMapper() {
        return (rs, rowNum) -> {
            User1 user = new User1();
            user.setIdx(rs.getLong("idx"));
            user.setUser_id(rs.getString("user_id"));
            user.setUser_age(rs.getLong("user_age"));
            user.setUser_pw(rs.getString("user_pw"));
            user.setUser_name(rs.getString("user_name"));
            user.setUser_tel(rs.getString("user_tel"));
            user.setUser_comment(rs.getString("user_comment"));
            user.setUser_profile(rs.getString("user_profile"));
            user.setUser_kakao(rs.getString("user_kakao"));

            return user;
        };
    }
}

