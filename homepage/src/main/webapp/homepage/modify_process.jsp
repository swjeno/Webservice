  <%@ page import="homepage.UserDao" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <jsp:useBean id="user" class="homepage.UserDto"/>
  <jsp:setProperty name="user" property="*"/>
  <%
          UserDao dao = UserDao.getInstance();
          user.setId(((String) session.getAttribute("id")));
          if (dao.updateUser(user) == 1) {
  %>
          <script>
                  alert("회원정보 수정 완료");
                  location.href = "login.jsp";
          </script>
  <%
  } else {
  %>
          <script>
                  alert("회원정보 수정 실패");
                  history.back();
          </script>
  <%
          }
  %>	