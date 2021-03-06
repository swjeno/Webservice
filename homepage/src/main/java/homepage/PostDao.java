package homepage;

import homepage.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDao {
        public static int POST_EXISTENT = 1;
        public static int POST_NONEXISTENT = 2;
        public static int POST_JOIN_SUCCESS = 3;
        public static int POST_LOGIN_SUCCESS = 4;
        public static int POST_LOGIN_FAIL = 5;
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
                String query = "INSERT INTO POST VALUES (?,?,?,?)";
                try {
                        conn = DatabaseUtil.getConnection();

                        if (conn == null) return rt;

                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, post.getPnum());
                        pstmt.setString(2, post.getPname());
                        pstmt.setString(3, post.getPcontent());
                        pstmt.setString(4, post.getId());
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
        public PostDto getPostNum(String pnum) {//글 불러오기(글번호)
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
        
        public PostDto getPostId(String id) {//글 불러오기(작성자)
            int rt = 0;
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            PostDto post = null;

            String query = "SELECT * FROM POST WHERE ID = ?";

            try {
                    conn = DatabaseUtil.getConnection();

                    if (conn == null) return post;
                    pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, id);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                            post = new PostDto(rs.getString("pnum"),
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
        
        public PostDto getPostPname(String pname) {//글 불러오기(글제목)
            int rt = 0;
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            PostDto post = null;

            String query = "SELECT * FROM POST WHERE PNAME = ?";

            try {
                    conn = DatabaseUtil.getConnection();

                    if (conn == null) return post;
                    pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, pname);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                            post = new PostDto(rs.getString("pnum"),
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
        
    	public int getNext() {//글번호 부여
    		//현재 게시글을 내림차순으로 조회하여 가장 마지막 글의 번호를 구한다
            int rt = 0;
            Connection conn = null;
            ResultSet rs = null;
            PostDto post = null;
    		String sql = "select pnum from post order by pnum desc";
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
    	

        public String getPostName(int Pnum)        // 삭제할 파일명을 가져온다.
        {
            String fileName = null;
            
            try {
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                StringBuffer sql = new StringBuffer();
                sql.append("SELECT PNAME from POST where PNUM=?");
                
                pstmt = conn.prepareStatement(sql.toString());
                pstmt.setInt(1, Pnum);
                
                rs = pstmt.executeQuery();
                if(rs.next()) fileName = rs.getString("PNAME");
                
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
            
            close();
            return fileName;
        } // end getFileName
            
        // 게시글 삭제
        public boolean deletePost(int Pnum) 
        {
            boolean result = false;
     
            try {
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                StringBuffer sql = new StringBuffer();
                conn.setAutoCommit(false); // 자동 커밋을 false로 한다.
     
                sql.append("DELETE FROM POST");
                sql.append(" WHERE PNUM = ?");
                
                pstmt = conn.prepareStatement(sql.toString());
                pstmt.setInt(1, Pnum);
                
                int flag = pstmt.executeUpdate();
                if(flag > 0){
                    result = true;
                    conn.commit(); // 완료시 커밋
                }    
                
            } catch (Exception e) {
                try {
                	Connection conn = null;
					conn.rollback(); // 오류시 롤백
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
                throw new RuntimeException(e.getMessage());
            }
     
            close();
            return result;
        } // end deleteBoard
        
        // DB 자원해제
        private void close()
        {
        	Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                if ( pstmt != null ){ pstmt.close(); pstmt=null; }
                if ( conn != null ){ conn.close(); conn=null;    }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } // end close()


}