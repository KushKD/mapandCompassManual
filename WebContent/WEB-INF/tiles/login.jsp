<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


 <section id="plan"></section>

<div class="container" style="margin-top: 20px;">
	<div class="row">
<form name='f' action='${pageContext.request.contextPath}/login' method='POST'>



	<c:if test="${param.error != null}">

		<p class="text-center text-danger">Login failed. Check that your user name and password are correct.</p>

	</c:if>
<center>
	<table >
		<tr>
			<td>User:</td>
			<td><input type='text' name='username' value=''></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type='password' name='password' /></td>
		</tr>
		<tr>
			<td colspan='2'><input class="btn btn-primary col-lg-12" name="submit" type="submit" value="Login" /></td>
		</tr>
	</table>
	</center>
</form>

</div>
</div>
<!--  
<div>
<a href="${pageContext.request.contextPath}/newaccount">Create a new Account if you are not a user.</a>
</div>

-->