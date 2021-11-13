<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="styles.css">
<meta charset="UTF-8">
<title>write</title>
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
			<form method="post" action="writeAction.jsp">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="50"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용" name="content" maxlength="1000" style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>
				<!-- 글쓰기 버튼 생성 -->
				<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
			</form>
		</div>
	</div>
	<!-- 게시판 글쓰기 양식 영역 끝 -->
</body>
</html>