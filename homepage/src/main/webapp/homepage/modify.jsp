  <%@ page import="homepage.UserDto" %>
  <%@ page import="homepage.UserDao" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%
          if (session.getAttribute("isLogin") == null) {
  %>
  <script>
          alert("로그인이 필요합니다.");
          location.href = "login.jsp";
  </script>
  <%
  } else {
          UserDto user = UserDao.getInstance().getUser((String) session.getAttribute("id"));

  %>
  <html>
  <head>
          <script src="form.js"></script>
          <title>Join</title>
          <style>
                  table {
                          /*width: 100%;*/
                          border: 1px solid #444444;
                          padding: 5px;
                          margin-left: auto;
                          margin-right: auto;
                  }

                  td {
                          /*width: 100%;*/
                          /*border: 1px solid #444444;*/
                  }

                  .c {
                          text-align: center;
                  }
          </style>
  </head>
  <body>

  <p class="c">회원 정보 수정</p>

  <form action="modify_process.jsp" method="post" name="modify_form">
          <table>
                  <tr>
                          <td>ID</td>
                          <td><%= user.getId()%>
                          </td>
                  </tr>

                  <tr>
                          <td>Password</td>
                          <td><input type="password" name="pw"></td>
                  </tr>

                  <tr>
                          <td>이름</td>
                          <td><%= user.getName()%>
                          </td>
                  </tr>

                  <tr>
                          <td>학번</td>
                          <td><%= user.getSnum()%></td>
                  </tr>


          </table>
          <br/>
          <div class="c">
          		  <button onclick="location.href='modify_process.jsp'">수정</button>
          		  <button onclick="location.href='main.jsp'">취소</button>
          </div>
  </form>

  </body>
  </html>
  <%
          }
  %>