<%@ page import="homepage.UserDao" %>
  <%@ page import="java.sql.Timestamp" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <jsp:useBean id="user" class="homepage.UserDto"/>
  <jsp:setProperty name="user" property="*"/>
  <%
          UserDao dao = UserDao.getInstance();
          if (dao.confirmId(user.getId()) == UserDao.USER_EXISTENT) {
  %>
                  <script>
                          alert("이미 존재하는 아이디 입니다.")
                          history.back();
                  </script>
  <%
          } else {
                  user.setDate(new Timestamp(System.currentTimeMillis()));
                  if (dao.insertUser(user) == UserDao.USER_JOIN_SUCCESS) {
  %>
                  <script>
                          alert("회원가입을 성공 했습니다.");
                          location.href = 'login.jsp';
                  </script>
  <%
                  }else{
  %>
                  <script>
                          alert("회원가입을 실패 했습니다.");
                          location.href = 'login.jsp';
                  </script>
  <%
                  }
          }
  %>