<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>C</title>
</head>

<body>

<table align="center" border="0" cellpadding="8" cellspacing="0" width="80%"  style="border:0px solid; border-radius:25px;background-color: white;">
		<tr align="center">
		<td></td>
			<td></td>
			<td align="center">
				${message}
			</td>
			
		</tr>
		<tr>
			
			<td>
				<c:forEach var="productDetail" items="${productDetails}">
				<td>
				<c:choose>
						<c:when test="${productDetail.type == 'Book'}">
						
				 <img src="./acmeviews/images/book.jpg"  width="400px" height="420px"/>
				 </c:when>
				 <c:when test="${productDetail.type == 'Game'}">
				 
				  <img src="./acmeviews/images/games.jpg"  width="400px" height="420px"/>
				 </c:when>
				 </c:choose>
			</td>
					<td>
					<form action = "<%=request.getContextPath()%>/addToCart.cart">
					Title       : ${productDetail.productTitle} <br>
				    Description : ${productDetail.shortDesc} <br>
				    Quantity    : <select name="qty" id="qty">
        							  <option value="1">1</option>
       								  <option value="2">2</option>
        							  <option value="3">3</option>
       								  <option value="4">4</option>
       								  <option value="5">5</option>
       								  <option value="6">6</option>
        							  <option value="7">7</option>
       								  <option value="8">8</option>
       								   <option value="9">9</option>
       								  <option value="10">10</option>
   								 </select>
				    
				  
				    Supplier    :   ${productDetail.supplierName} <br>
				    Cost  Price :${productDetail.costPrice} | Selling  Price : ${productDetail.sellingPrice} 
					<br>
					<input type="hidden" name="id" value=" ${productDetail.productId}"/>
					<input type="hidden" name="supplierId" value=" ${productDetail.supplierID}"/>
					<input type="submit" value="Add to Cart"/>
				</form>
				  </c:forEach>
			</td>
			<td>
			</td>
		</tr>
	</table>
	
</body>

</html>
