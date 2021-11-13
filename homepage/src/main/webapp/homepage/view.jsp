<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="styles.css">
<meta charset="UTF-8">
<title>view</title>
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
    
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글 보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">글 제목</td>
						<td colspan="2">테스트</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2">taemin</td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2">2021-11-14</td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="2" style="height: 200px; text-align: left;">내용 잘 들어갔냐</td>
					</tr>
				</tbody>
			</table>
			<a href="main.jsp" class="btn btn-primary">목록</a>
			

		</div>
	</div>
</body>
</html>