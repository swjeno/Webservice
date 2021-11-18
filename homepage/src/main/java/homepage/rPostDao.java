package homepage;

import homepage.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class rPostDao {
        public static int POST_EXISTENT = 1;
        public static int POST_NONEXISTENT = 2;
        public static int POST_JOIN_SUCCESS = 3;
        public static int POST_LOGIN_SUCCESS = 4;
        public static int POST_LOGIN_FAIL = 5;
        private static rPostDao instance = new rPostDao();

        public static rPostDao getInstance() {
                return instance;
        }

        private rPostDao() {
        }

        public int insertrPost(rPostDto post) {//post insert
                int rt = 0;
                Connection conn = null;
                PreparedStatement pstmt = null;
                String query = "INSERT INTO RPOST VALUES (?,?,?,?,?)";
                try {
                        conn = DatabaseUtil.getConnection();

                        if (conn == null) return rt;

                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, post.getPnum());
                        pstmt.setString(2, post.getrPnum());
                        pstmt.setString(3, post.getrPname());
                        pstmt.setString(4, post.getrPcontent());
                        pstmt.setString(5, post.getId());
                        pstmt.executeUpdate();
                        rt = POST_JOIN_SUCCESS;
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

        public int updaterPost(rPostDto post) {//post update
                int rt = 0;

                Connection conn = null;
                PreparedStatement pstmt = null;
                String query = "UPDATE RPOST SET RPNAME=?, RPCONTENT=?, RPNUM=? WHERE PNUM=?";
                try {
                        conn = DatabaseUtil.getConnection();

                        if (conn == null) return rt;

                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, post.getrPname());
                        pstmt.setString(2, post.getrPname());
                        pstmt.setString(3, post.getrPnum());
                        pstmt.setString(4, post.getPnum());
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
/*
        public int confirmPost(String pnum) {//post confirm by pnum
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
                                rt = POST_EXISTENT;
                        else
                                rt = POST_NONEXISTENT;
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
        public rPostDto getPostNum(String pnum) {//getpost by rpnum
                int rt = 0;
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                rPostDto post = null;

                String query = "SELECT * FROM RPOST WHERE PNUM = ?";

                try {
                        conn = DatabaseUtil.getConnection();

                        if (conn == null) return post;
                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, pnum);
                        rs = pstmt.executeQuery();
                        if (rs.next()) {
                                post = new rPostDto(rs.getString("pnum"),
                                				rs.getString("rpnum"),
                                                rs.getString("pname"),
                                                rs.getString("pcontent"),
                                                rs.getString("id"));
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
        
        public rPostDto getrPostId(String id) {//getpost by id
            int rt = 0;
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            rPostDto post = null;

            String query = "SELECT * FROM RPOST WHERE ID = ?";

            try {
                    conn = DatabaseUtil.getConnection();

                    if (conn == null) return post;
                    pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, id);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                            post = new rPostDto(rs.getString("pnum"),
                            				rs.getString("rpnum"),
                                            rs.getString("pname"),
                                            rs.getString("pcontent"),
                                            rs.getString("id"));
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
        
        public rPostDto getrPostPname(String pname) {//getpost by PNAME
            int rt = 0;
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            rPostDto post = null;

            String query = "SELECT * FROM RPOST WHERE PNAME = ?";

            try {
                    conn = DatabaseUtil.getConnection();

                    if (conn == null) return post;
                    pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, pname);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                            post = new rPostDto(rs.getString("pnum"),
                            				rs.getString("rpnum"),
                                            rs.getString("rpname"),
                                            rs.getString("rpcontent"),
                                            rs.getString("id"));
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
        
        
    	public int getNext() {//글번호 부여
    		//현재 게시글을 내림차순으로 조회하여 가장 마지막 글의 번호를 구한다
            int rt = 0;
            Connection conn = null;
            ResultSet rs = null;
            rPostDto post = null;
    		String sql = "select pnum from rpost order by rpnum desc";
    		try {
    			PreparedStatement pstmt = conn.prepareStatement(sql);
    			rs = pstmt.executeQuery();
    			if(rs.next()) {
    				return rs.getInt(1) + 1;
    			}
    			return 1; //첫 번째 게시물인 경우
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		return -1; //데이터베이스 오류
    	}
    	

}