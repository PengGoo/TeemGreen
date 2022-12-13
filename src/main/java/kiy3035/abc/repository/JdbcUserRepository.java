//package kiy3035.abc.repository;
//
//import kiy3035.abc.domain.User1;
//import org.springframework.jdbc.datasource.DataSourceUtils;
//
//import javax.sql.DataSource;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class JdbcUserRepository implements UserRepository{
//
//    private final DataSource dataSource;
//    public JdbcUserRepository(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Override
//    public User1 save(User1 user) {
//        String sql = "insert into User1(USER_ID, USER_AGE, USER_PW, USER_NAME, USER_TEL, USER_COMMENT, USER_PROFILE, USER_KAKAO) " +
//                     "values(?, ?, ?, ?, ?, ?, ?, ?)";
//
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;    // 결과 받는것
//
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql,
//                    Statement.RETURN_GENERATED_KEYS);
//
//            pstmt.setString(1, user.getUser_id());   // 1이 위에 ?랑 일치
//            pstmt.setLong  (2, user.getUser_age());
//            pstmt.setString(3, user.getUser_pw());
//            pstmt.setString(4, user.getUser_name());
//            pstmt.setString(5, user.getUser_tel());
//            pstmt.setString(6, user.getUser_comment());
//            pstmt.setString(7, user.getUser_profile());
//            pstmt.setString(8, user.getUser_kakao());
//
//            pstmt.executeUpdate();
//            rs = pstmt.getGeneratedKeys();  // h2 db 테이블에 1번,2번을 꺼내줌
//
//            if (rs.next()) {    // 값이 있으면 값을 꺼내줌
//                user.setIdx(rs.getLong(9));
//            } else {
//                throw new SQLException("id 조회 실패");
//            }
//            return user;
//
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    @Override
//    public Optional<User1> findById(Long idx) {
//        String sql = "select * from User1 where idx = ?";
//
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);     // 날리고
//            pstmt.setLong(1, idx);       // 세팅
//
//            rs = pstmt.executeQuery();      // 조회
//
//            if(rs.next()) {
//                User1 user = new User1();
//                user.setIdx         (rs.getLong("idx"));
//                user.setUser_id     (rs.getString("user_id"));
//                user.setUser_age    (rs.getLong("user_age"));
//                user.setUser_pw     (rs.getString("user_pw"));
//                user.setUser_name   (rs.getString("user_name"));
//                user.setUser_tel    (rs.getString("user_tel"));
//                user.setUser_comment(rs.getString("user_comment"));
//                user.setUser_profile(rs.getString("user_profile"));
//                user.setUser_kakao  (rs.getString("user_kakao"));
//                return Optional.of(user);
//            } else {
//                return Optional.empty();
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    @Override
//    public List<User1> findAll() {
//        String sql = "select * from User1";
//
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);
//
//            rs = pstmt.executeQuery();
//
//            List<User1> users = new ArrayList<>();
//            while(rs.next()) {
//                User1 user = new User1();
//                user.setIdx         (rs.getLong("idx"));
//                user.setUser_id     (rs.getString("user_id"));
//                user.setUser_age    (rs.getLong("user_age"));
//                user.setUser_pw     (rs.getString("user_pw"));
//                user.setUser_name   (rs.getString("user_name"));
//                user.setUser_tel    (rs.getString("user_tel"));
//                user.setUser_comment(rs.getString("user_comment"));
//                user.setUser_profile(rs.getString("user_profile"));
//                user.setUser_kakao  (rs.getString("user_kakao"));
//
//                users.add(user);
//            }
//
//            return users;
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    @Override
//    public Optional<User1> findByName(String name) {
//        String sql = "select * from User1 where name = ?";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            conn = getConnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, name);
//            rs = pstmt.executeQuery();
//            if(rs.next()) {
//                User1 user = new User1();
//                user.setIdx         (rs.getLong("idx"));
//                user.setUser_id     (rs.getString("user_id"));
//                user.setUser_age    (rs.getLong("user_age"));
//                user.setUser_pw     (rs.getString("user_pw"));
//                user.setUser_name   (rs.getString("user_name"));
//                user.setUser_tel    (rs.getString("user_tel"));
//                user.setUser_comment(rs.getString("user_comment"));
//                user.setUser_profile(rs.getString("user_profile"));
//                user.setUser_kakao  (rs.getString("user_kakao"));
//                return Optional.of(user);
//            }
//            return Optional.empty();
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        } finally {
//            close(conn, pstmt, rs);
//        }
//    }
//
//    private Connection getConnection() {
//        return DataSourceUtils.getConnection(dataSource);
//    }
//
//    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
//    {
//        try {
//            if (rs != null) {
//                rs.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (pstmt != null) {
//                pstmt.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (conn != null) {
//                close(conn);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void close(Connection conn) throws SQLException {
//        DataSourceUtils.releaseConnection(conn, dataSource);
//    }
//}
