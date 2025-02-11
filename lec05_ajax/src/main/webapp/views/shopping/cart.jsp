<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="com.gn.shopping.vo.Product" %>
<%
	List<Product> list = null;
	String cart = "";
	if(session != null){
		list = (List<Product>)session.getAttribute("sessionList");
		cart = (String)session.getAttribute("cart");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카트</title>
</head>
<body>
	<%if(list == null || session == null || "0".equals(session.getAttribute("cart"))){%>
		<p>
			장바구니가 비어 있습니다.
		</p>
	<%} else{%>
		<p>
			<%-- <%for(int i = 0; i < list.size(); i++){ %>
				<%if(cart.equals(list.get(i).getProdCode())){ %>
				<%=list.get(i).getProdName() %>
				<%} %>
			<%} %> --%>
			<%=cart %>
			테스트용2
		</p>
	<%}%>
</body>
</html>