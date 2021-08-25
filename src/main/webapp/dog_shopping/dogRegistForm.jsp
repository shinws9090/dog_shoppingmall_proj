<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dogRegist.css">
</head>
<body>

<section id="writeForm">
		<h2>게시판 글등록</h2>
		<form action="dogRegist.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td class="td_left"><label for="kind">품종</label></td>
					<td class="td_right"><input type="text" name="kind"
						id="kind" required></td>
				</tr>
				<tr>
					<td class="td_left"><label for="price">가격</label></td>
					<td class="td_right"><input type="text" name="price"
						id="price" required></td>
				</tr>
				<tr>
					<td class="td_left"><label for="height">신장</label></td>
					<td class="td_right"><input type="text" name="height"
						id="height" required></td>
				</tr>
				<tr>
					<td class="td_left"><label for="weight">체중</label></td>
					<td class="td_right"><input type="text" name="weight"
						id="weight" required></td>
				</tr>
				<tr>
					<td class="td_left"><label for="country">원산지</label></td>
					<td class="td_right"><input type="text" name="country"
						id="country" required></td>
				</tr>
				<tr>
					<td class="td_left"><label for="content">내용</label></td>
					<td class="td_right"><textarea cols="40" rows="15"
							name="content" id="content" required> </textarea></td>
				</tr>
				<tr>
					<td class="td_left"><label for="image">사진 첨부</label></td>
					<td class="td_right"><input type="file" name="image"
						id="image" required></td>
				</tr>
			</table>
			<section id = "commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp; <input
					type="reset" value="다시쓰기">&nbsp;&nbsp;
				<a href="doglist.do">쇼핑계속하기</a>
			</section>
		</form>
</section>

</body>
</html>