<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<tiles:insertAttribute name="header"></tiles:insertAttribute>
</head>


<body data-spy="scroll" data-target=".navbar-collapse" data-offset="50">
	<!-- Preloader section
================================================== -->
	<section class="preloader">

	<div class="sk-rotating-plane"></div>
	</section>

	<!-- Navigation section
================================================== -->
	<section class="navbar navbar-fixed-top custom-navbar"
		role="navigation">
	<div class="container">

		<div class="navbar-header">
			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon icon-bar"></span> <span class="icon icon-bar"></span>
				<span class="icon icon-bar"></span>
			</button>
			<a href="${pageContext.request.contextPath}/"
				class="smoothScroll navbar-brand">Map n Compass</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right">

				<li><a href="${pageContext.request.contextPath}/"
					class="smoothScroll">HOME</a></li>


				<li><a href="${pageContext.request.contextPath}/about"
					class="smoothScroll">ABOUT</a></li>
				<li><a href="${pageContext.request.contextPath}/team"
					class="smoothScroll">TEAM</a></li>
				<!--  <li><a href="${pageContext.request.contextPath}/gallery" class="smoothScroll">GALLERY</a></li>  -->
				<li><a href="${pageContext.request.contextPath}/packages"
					class="smoothScroll">PACKAGES</a></li>
				<li><a href="${pageContext.request.contextPath}/contactus"
					class="smoothScroll">CONTACT</a></li>
				
				<sec:authorize access="isAuthenticated()">
					<li><a href="${pageContext.request.contextPath}/getqueries">QUERIES</a></li>
				</sec:authorize>
				
				<sec:authorize access="isAuthenticated()">
					<li><a href="${pageContext.request.contextPath}/createpackage">CREATE PACKAGE</a></li>
				</sec:authorize>
				
				<sec:authorize access="!isAuthenticated()">
					<li><a href="${pageContext.request.contextPath}/login">LOG IN</a></li>
				</sec:authorize>
				
				<sec:authorize access="isAuthenticated()">
					<li><a href="${pageContext.request.contextPath}/logout">LOG OUT</a></li>
				</sec:authorize>
			</ul>
		</div>

	</div>
	</section>
	<tiles:insertAttribute name="body"></tiles:insertAttribute>
	<hr>
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</body>
</html>