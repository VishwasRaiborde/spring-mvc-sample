<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<table align="center" border="0" cellpadding="8" cellspacing="0"
		width="80%"
		style="border: 0px solid; border-radius: 25px; background-color: white;">

		
		<form name='f' action="<c:url value='j_spring_security_check' />"	method='POST'>
		<tr>
		<td></td>
		<td align="left"><c:if test="${not empty error}">
				Your login attempt was not successful, try again.
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</c:if></td>
		</tr>
		<tr>
			<td align="center">User:</td>
			<td><input type='text' name='j_username' value=''></td>
		</tr>
		<tr>
			<td align="center">Password:</td>
			<td><input type='password' name='j_password' /></td>
		</tr>
		<tr>
			<td align="center"></td>
			<td><input class="button" name="submit" type="submit"
				value="submit" /> <input class="button" name="reset" type="reset" />
			</td>
		</tr>
			</form>
	</table>
