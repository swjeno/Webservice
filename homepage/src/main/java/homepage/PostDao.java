package homepage;

import homepage.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDao {
        public static int USER_EXISTENT = 1;
        public static int USER_NONEXISTENT = 2;
        public static int USER_JOIN_SUCCESS = 3;
        public static int USER_LOGIN_SUCCESS = 4;
        public static int USER_LOGIN_FAIL = 5;
        private static PostDao instance = new PostDao();

        public static PostDao getInstance() {
                return instance;
        }

        private PostDao() {
        }

        public int insertPost(PostDto post) {//글작성
                int rt = 0;
                Connection conn = null;
                PreparedStatement pstmt = null;
                String query = "INSERT INTO POST VALUES (?,?,?,?,?)";
                try {
                        conn = DatabaseUtil.getConnection();

                        if (conn == null) return rt;

                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, post.getPnum());
                        pstmt.setString(2, post.getPname());
                        pstmt.setString(3, post.getPcontent());
                        pstmt.setString(4, post.getId());
                        pstmt.setTimestamp(5, post.getDate());
                        pstmt.executeUpdate();
                        rt = USER_JOIN_SUCCESS;
                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (pstmt != null) pstmt.close();
                                if (conn != null) conn.close();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }

                return rt;
        }

        public int updatePost(PostDto post) {//글변경
                int rt = 0;

                Connection conn = null;
                PreparedStatement pstmt = null;
                String query = "UPDATE POST SET PNAME=?, PCONTENT=? WHERE PNUM=?";
                try {
                        conn = DatabaseUtil.getConnection();

                        if (conn == null) return rt;

                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, post.getPname());
                        pstmt.setString(2, post.getPname());
                        pstmt.setString(3, post.getPnum());
                        rt = pstmt.executeUpdate();
                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (pstmt != null) pstmt.close();
                                if (conn != null) conn.close();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }
                return rt;
        }

        public int confirmPost(String pnum) {//글확인
                int rt = 0;
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                String query = "SELECT PNUM FROM POST WHERE PNUM = ?";

                try {
                        conn = DatabaseUtil.getConnection();
                        if (conn == null) return rt;
                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, pnum);
                        rs = pstmt.executeQuery();
                        if (rs.next())
                                rt = USER_EXISTENT;
                        else
                                rt = USER_NONEXISTENT;
                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (rs != null) rs.close();
                                if (pstmt != null) pstmt.close();
                                if (conn != null) conn.close();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }

                return rt;
        }
/*
        public int confirmLogin(String id, String pw) {
                int rt = 0;
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                String query = "SELECT PW FROM MEMBERS WHERE ID = ?";

                try {
                        conn = DatabaseUtil.getConnection();

                        if (conn == null) return rt;
                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, id);
                        rs = pstmt.executeQuery();
                        if (rs.next()) {
                                if (pw.equals(rs.getString("pw")))
                                        rt = USER_LOGIN_SUCCESS;
                                else
                                        rt = USER_LOGIN_FAIL;
                        } else
                                rt = USER_NONEXISTENT;
                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (rs != null) rs.close();
                                if (pstmt != null) pstmt.close();
                                if (conn != null) conn.close();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }
                return rt;
        }
*/
        public PostDto getPost(String pnum) {//글 불러오기
                int rt = 0;
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                PostDto post = null;

                String query = "SELECT * FROM POST WHERE PNUM = ?";

                try {
                        conn = DatabaseUtil.getConnection();

                        if (conn == null) return post;
                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, pnum);
                        rs = pstmt.executeQuery();
                        if (rs.next()) {
                                post = new PostDto(rs.getString("pnum"),
                                                rs.getString("pname"),
                                                rs.getString("pcontent"),
                                                rs.getString("id"),

                                                rs.getTimestamp("date"));
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (rs != null) rs.close();
                                if (pstmt != null) pstmt.close();
                                if (conn != null) conn.close();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }
                return post;
        }

}