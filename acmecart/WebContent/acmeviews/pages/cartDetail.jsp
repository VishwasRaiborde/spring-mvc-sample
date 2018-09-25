<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table align="center" border="0" cellpadding="8" cellspacing="0"
	width="80%"
	style="border: 0px solid; border-radius: 25px; background-color: white;">
	<tr>
		<td>
			${message}
		</td>
	</tr>
	
	<tr>
		<td>
			<table align="center" width="60%" >
			<tr>
						
						<td ><b>Title<b/></p></td>
						<td ><b>Supplier Name<b/></td>
						<td ><b>Price<b/> </td>
						<td ><b>Quantity<b/></td>
						<td ><b>Edit<b/></td>
						<td ><b>Remove<b/></td>
						
				</tr>
			<c:forEach items="${purchaseOrders}" var="purchaseOrder">
			
					<tr>
						
						<td >${purchaseOrder.productTitle}</p></td>
						<td >${purchaseOrder.supplierName}</td>
						<td >${purchaseOrder.quantity * purchaseOrder.price}</td>
						<td >${purchaseOrder.quantity}</td>
						
						<td valign="top"> 
							<a	href="<%=request.getContextPath()%>/showDetails.cart?id=${purchaseOrder.productId}">
												<img src="./acmeviews/images/book.jpg"height="30" />
												<img src="./acmeviews/images/games.jpg"height="20" />
									</a>
						</td>
						<td >
							<a	href="<%=request.getContextPath()%>/removeOrder.cart?orderID=${purchaseOrder.orderId}&id=${purchaseOrder.productId}">
								<img alt="product" src="./acmeviews/images/remove.png"	height="30">
								
							</a>
						</td>
						
					</tr>
			</c:forEach>
			</table>
			</td>
	</tr>
</table>

