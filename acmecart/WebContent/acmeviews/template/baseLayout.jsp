<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<html>
<head>
<style>
a.navwhite:link { text-decoration: none; color: #ffffff; font-family: Verdana, Arial, sans-serif; font-size: 14px; font-weight: bold; }
a.navwhite:visited { text-decoration: none; color: #ffffff; font-family: Verdana, Arial, sans-serif; font-size: 14px; font-weight: bold; }
a.navwhite:hover { text-decoration: underline; color: #ffffff; font-family: Verdana, Arial, sans-serif; font-size: 14px; font-weight: bold; }
a.navblack:link { text-decoration: none; color: #000000; font-family: Verdana, Arial, sans-serif; font-size: 14px; font-weight: bold; }
a.navblack:visited { text-decoration: none; color: #000000; font-family: Verdana, Arial, sans-serif; font-size: 14px; font-weight: bold; }
a.navblack:hover { text-decoration: underline; color: #000000; font-family: Verdana, Arial, sans-serif; font-size: 14px; font-weight: bold; }
h1 { font-family: Arial, sans-serif; font-size: 30px; color: #a80000;}
h2 { font-family: Arial, sans-serif; font-size: 18px; color: #a80000;}


</style>
</head>
<body style="background-image: url('http://localhost:8080/acmecart/acmeviews/images/background (2).jpg') ; background-repeat: repeat;">

<div id="header" style=" width: 100%;border: thin;">
		<tiles:insertAttribute name="header" />
	</div>
	<div id="menu" style="border: thin; width: 100%">
		<tiles:insertAttribute name="menu" />
	</div>
	<div id="container" style="border: thin;  width: 100%">
		<tiles:insertAttribute name="body" />
	</div>
	<div id="footer" style="border: thin;  width: 100%">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>
