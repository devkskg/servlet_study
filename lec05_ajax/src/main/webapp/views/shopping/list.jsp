<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="com.gn.shopping.vo.Product" %>
<%
	List<Product> resultList = (List<Product>)request.getAttribute("resultList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<form action="/addToCart" method="post">
				<%= resultList.size()	%>
		<select name="product">
			<option value="0">고르세용~</option>
			<%for(int i = 0; i < resultList.size(); i++){%>
					<option value="<%= resultList.get(i).getProdCode() %>">
						<%= resultList.get(i).getProdName() %>
					</option>
				<%}%>
		</select>
		
		<a href="/addToCart"><button>추가</button></a>
		<!-- <button>추가 <a href="/addToCart"></a></button> -->
		<!-- <a href="/addToCart">추가</a> -->
	</form>
</body>
</html>