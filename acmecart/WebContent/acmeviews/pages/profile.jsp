<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

<table align="center" border="0" cellpadding="8" cellspacing="0" width="80%"  style="border:0px solid; border-radius:25px;background-color: white;">
		<form name="user" action="<%=request.getContextPath()%>/saveProfile.cart" method="post">
			
							<tr>
								<td></td>
								<td align="right">My Profile</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="2">${message}</td>
							</tr>
							<tr>
								<td align="right">User Id:</td>
								<td><input  type="text" name="userID" 	value="${userID}"></input></td>
							</tr>
							<tr>
								<td align="right">Name:</td>
								<td ><input  type="text" name="userName" value="${userName}" /></input></td>
							</tr>
							<tr>
								<td align="right">Password:</td>
								<td><input  type="password" name="password"	value="${password}" /></input></td>
							</tr>
							
					<c:choose>
						<c:when test="${user.type == 'p'}">
							
								<tr  colspan="2">
									<td></td>
									<td  >Person</td>
								</tr>
								<tr>
									<td align="right">First Name:</td>
									<td><input type="text" name="firstName"
										value="${user.firstName}"
										></input></td>
								</tr>
								<tr>
									<td align="right">Last Name:</td>
									<td><input type="text" name="lastName"
										value="${user.lastName}"
										></input></td>
								</tr>
							<input type="hidden" name="type" value="${user.type}"></input>
							<input type="hidden" name="companyName" value=""></input>
							<input type="hidden" name="vatNo" value=""></input>
						</c:when>
						<c:when test="${user.type == 'c'}">
							<input type="hidden" name="type" value=""></input>
							<input type="hidden" name="firstName" value=""></input>
							<input type="hidden" name="lastName" value=""></input>
						
								<tr>
									<td></td>
									<td colspan="2"  >Company</td>
								</tr>
								<tr>
									<td align="right">Company Name:</td>
									<td><input type="text" name="companyName"
										value="${user.companyName}"
										></input></td>
								</tr>
								<tr>
									<td align="right">Vat No:</td>
									<td><input type="text" name="vatNo"
										value="${user.vatNo}"
										></input></td>
								</tr>
						</c:when>
					</c:choose>
				<tr >
				    <td></td>
					<td>
					<input type="submit" name="save" value="save"/>
					</td>
				</tr>

		</form>
</table>
</body>
</html>