<%@page import="dog_shoppingmall_proj.dto.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dogCartList.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="script/jquery.ajax-cross-origin.min.js"></script>
<script>
$(function(){
	
	$("#allCheck").click(function(){
		alert("하");
		if($("#allCheck").prop("checked")){
			$(".remove").prop("checked", true);
		}else{
			$(".remove").prop("checked", false);
		}
	});
		
	
	
	
	$(".upImage").click(function(){
		var kind = $(this).data("kind");
			location.href="dogCartQtyUp.do?kind="+ encodeURIComponent(kind);
	});
	$(".downImage").click(function(){
		var kind = $(this).data("kind");
		var qty = $(this).data("qty");
		if(qty != 1){
			location.href="dogCartQtyDown.do?kind="+ encodeURIComponent(kind);
		}
		
	});
	
});
</script>
</head>
<body>
<c:if test="${startMoney !=null }">
	<c:set var="startMoney" value="${startMoney}"></c:set>
</c:if>
<c:if test="${endMoney !=null }">
	<c:set var="endMoney" value="${endMoney}"></c:set>
</c:if>
<section id="listForm">
	<c:if test="${cartList !=null && cartList.size()>0 }">
   <h2>장바구니 목록</h2>
<form method="post">
      <table>
    	<tr id="select">
    		<td colspan="6">
    		<select id = "startMoney" name="startMoney">
    			<option>=최하=</option>
    			<c:choose>
    				<c:when test="${startMoney==1000 }">
    					<option selected="selected">1000</option>
    					<option>2000</option>
    					<option>3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${startMoney==2000 }">
    					<option>1000</option>
    					<option selected="selected">2000</option>
    					<option>3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${startMoney==3000 }">
    					<option>1000</option>
    					<option>2000</option>
    					<option selected="selected">3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${startMoney==4000 }">
    					<option>1000</option>
    					<option>2000</option>
    					<option>3000</option>
	    				<option selected="selected">4000</option>
    				</c:when>
    				<c:otherwise>
    					<option>1000</option>
    					<option>2000</option>
    					<option>3000</option>
    					<option>4000</option>
    				</c:otherwise>
    			</c:choose>
    		</select>
    		<select id = "endMoney" name="endMoney">
    			<option>=최고=</option>
    			<c:choose>
    				<c:when test="${endMoney==1000 }">
    					<option selected="selected">1000</option>
    					<option>2000</option>
    					<option>3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${endMoney==2000 }">
    					<option>1000</option>
    					<option selected="selected">2000</option>
    					<option>3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${endMoney==3000 }">
    					<option>1000</option>
    					<option>2000</option>
    					<option selected="selected">3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${endMoney==4000 }">
    					<option>1000</option>
    					<option>2000</option>
    					<option>3000</option>
	    				<option selected="selected">4000</option>
    				</c:when>
    				<c:otherwise>
    					<option>1000</option>
    					<option>2000</option>
    					<option>3000</option>
    					<option>4000</option>
    				</c:otherwise>
    			</c:choose>
    		</select>
    		<input type="submit" value="검색" formaction="dogCartSearch.do"/>
    		</td>
    	</tr>
        <tr class = "tr_top">
        	<td><input type="checkbox" id ="allCheck" name="allCheck" onclick="checkAll(this.form)"/> </td>
             <td>번호</td>
             <td>상품 이미지</td>
             <td>상품명</td>
             <td>가격</td>
             <td>수량</td>
         </tr>

        <c:forEach var="cart" items="${cartList }" varStatus="status">
        
        <tr>
        	<td>
        		<input type="checkbox" class="remove" name="remove" value="${cart.kind }"/>
        	</td>
             <td>
             
             ${status.index+1}<!-- 번호값계산 -->
            </td>
             <td>
             <img src = "images/${cart.image }" id ="cartImage"/>
            </td>
             <td>
             ${cart.kind }
            </td>
             <td>
             ${cart.price }
            </td>
             <td>
             <%-- <a href="dogCartQtyUp.do?kind=${cart.kind }">
             <img src="images/up.jpg" id = "upImage" border=0/>
             </a><br> --%>
             <img src="images/up.jpg" data-kind="${cart.kind }" data-qty="${cart.qty }" class ="upImage" border=0 style="cursor:pointer"/><br>
             <span>${cart.qty }</span><br>
             <img src="images/down.jpg" data-kind="${cart.kind }" data-qty="${cart.qty }" class ="downImage" border=0 style="cursor:pointer"/><br>
             <%-- <a href="javascript:checkQty('${cart.kind}',${cart.qty})">
             <img src="images/down.jpg" id = "downImage" border=0/>
             </a> --%>
            </td>
         </tr>
        </c:forEach>
      <tr>
         <td colspan="5" style="text-align:center;">
            총 금액 : ${totalMoney}원
         </td>
      </tr>
      <tr>
         <td colspan="5" style="text-align:center;">
         	<input type="submit" value="삭제" formaction="dogCartRemove.do"/>
         </td>
      </tr>
      </table>
</form>
	</c:if>
	<c:if test="${cartList == null }">
      <section class="div_empty">
      개정보가 없습니다.
      </section>
	</c:if>
   <nav id="commandList">
   		<a href="doglist.do">쇼핑 계속하기</a>
   </nav>
   
</section>
</body>
</html> 