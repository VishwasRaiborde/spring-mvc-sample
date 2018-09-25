<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>

<table align="center"  cellpadding="8"  width="80%" style="border:0px solid; border-radius:-25px;background-color:red; ">
	<tbody>
	
		<tr align="left" >
			
			<td align="left" style="background-image: ">
			<a class="navwhite" href="product.cart">
			<font color="white" size="3">All Products <font color="white" >&nbsp;&nbsp;|</font></font></a>
			
			
			
			<a class="navwhite" href="profile.cart">
			<font color="white" size="3">
			<sec:authorize access="isAuthenticated()">&nbsp;&nbsp;Profile&nbsp; <font color="white">&nbsp;&nbsp;|</font></sec:authorize></font> </a>
			
		
			<a class="navwhite" href="getCart.cart">
			<font color="white" size="3"><sec:authorize access="isAuthenticated()">&nbsp;&nbsp;Cart &nbsp;<font color="white">&nbsp;&nbsp;|</font></sec:authorize></font></a>
			
			
			<a class="navwhite" href="login.cart">
			<font color="white" size="3"><sec:authorize ifNotGranted="ROLE_USER">&nbsp;&nbsp;Login &nbsp; <font color="white">&nbsp;&nbsp;|</font></sec:authorize></font></a>
			
			
			<a class="navwhite" href="j_spring_security_logout"><font color="white">
			<sec:authorize access="isAuthenticated()">&nbsp;&nbsp;Logout &nbsp;<font color="white">&nbsp;&nbsp;|</font></sec:authorize></font></a>
			</td>
			<td align="right" >
					<sec:authorize access="isAuthenticated()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome <sec:authentication property="principal.username"/></sec:authorize></td>
			</td>
		</tr>
		
	</tr>
	
	</tbody>
</table>