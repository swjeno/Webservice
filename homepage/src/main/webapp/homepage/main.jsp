 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="styles.css">
    <title>Home</title>
</head>
<body>
    <div class="mainpage__header">
        <div>
            <a href="modify.jsp">
                <img class="user__image" src="user.png"/>
            </a>
            <button onclick="location.href='logout.jsp'">로그아웃</button>
        </div>
        <div>
            <h1>산기대 Q&A 게시판</h1>
        </div>
        <div>
            <h4><%= session.getAttribute("name")%>님 안녕하세요</h4>
        </div>
    </div>
    <hr>

    <table class="table">
        <thead>
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th class="num" scope="row">3</th>
                <td class="title">글제목</td>
                <th class="writer">ddd</th>
            </tr>
            <tr>
                <th class="num" scope="row">2</th>
                <td class="title">ㅎㅇ</td>
                <th class="writer">sss</th>
            </tr>
            <tr>
                <th class="num" scope="row">1</th>
                <td class="title">ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ.</td>
                <th class="writer">zzz</th>
            </tr>
        </tbody>
    </table>
    <div class="search__box">
        <form>
            <select name="search" class="search__select">
                <option value="name">글제목</option>
                <option value="writer">작성자</option>
            </select>
            <input type="text" name="search__text">
            <input type="submit" value="검색">
        </form>
        <input type="button" value="글쓰기">
    </div>
               
</body>
</html>