<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table >
	
	<tr>
		<c:forEach var="book" items="${books}">
		<table align="center"  width="80%"  
			align="center" border="0" cellpadding="8" cellspacing="0" width="80%"  
				style="border:0px solid; background-color: white;">
			<td width="1%">
				<a	href="<%=request.getContextPath()%>/showDetails.cart?id=${book.productId}">
					
					<img src="./acmeviews/images/book.jpg" width="220px" height="220px" /><br>
				&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<font color="grey" size="4"><c:out	value="${book.productTitle}" /></font><br>
				</a>
			</td>
			<td width="10%">
					 <font color="grey" size="3"><c:out	value="${book.shortDesc}" /></font>
			</td>
			</table>
		</c:forEach>
	</tr>
	
	<tr>
		<c:forEach var="game" items="${games}">
		<table align="center"  width="80%"  
			style="border:0px solid; background-color: white;">
		
			<td width="1%"><a	href="<%=request.getContextPath()%>/showDetails.cart?id=${game.productId}">
					<img src="./acmeviews/images/games.jpg" width="220px" height="220px" /><br>
				  
				   &nbsp;&nbsp; &nbsp;&nbsp; <font color="grey" size="4"><c:out	value="${game.productTitle}" /></font><br>
				</a></td>
			<td width="10%">
				 <font color="grey" size="3"><c:out	value="${game.shortDesc}" /></font>
			</td>
			</table>
		</c:forEach>
	</tr>
</table>
