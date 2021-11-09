<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%
          if (session.getAttribute("isLogin") != null) {
                  pageContext.forward("main.jsp");
          }
  %>
  <html>
  <head>
          <script src="form.js"></script>
          <link rel="stylesheet" href="styles.css">
          <title>Login</title>

  </head>
  <body>
  <div class="login__form">
  	<h2>산기대 Q&A 게시판</h2>
    <form action="login_process.jsp" method="post" name="login_form">
          <table>
                  <tr>
                          <td>
                                  ID :
                          </td>
                          <td>
                                  <input type="text" name="id"></label><br/>
                          </td>
                  </tr>
                  <tr>
                          <td>
                                  Password : 
                          </td>
                          <td>
                                  <input type="password" name="pw">
                          </td>
                  </tr>
          </table>
          <br/>

		<button type="button" onclick="confirmLogin()">로그인</button>
         <button type="button" onclick="location.href='join.html'">회원 가입</button>
  	</form>
  </div>

  </body>
  </html>