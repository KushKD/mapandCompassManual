<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Plan section
================================================== -->
<section id="plan"></section>

<div class="container">
	<div class="row">
		<c:forEach items="${packages}" var="o">
			<!-- Card Projects -->
			<div class="col-md-3 ">
				<div class="card">
					<div class="card-image">
						<img class="img-responsive"
							src="${pageContext.request.contextPath}/mapncompass/images/packages/thumbnail/${o.packagethumbnail}">

					</div>
					<div>
						<span class=" col-lg-12 card-title text-center"
							style="color: #000000;">${o.packagenamemc}</span>
					</div>
					<div class="card-content">
						<p class="col-lg-12 text-center"><span>Rs </span><span class="text-danger">${o.packagerate}</span><span>/-</span>
						</p>
						<hr>
						<p class="text-center"><span class="text-primary">${o.packageshortdesc}</span></p>
					</div>
					<div>
						<a href="${o.package_id}" target="new_blank" style="visibility: hidden;"
							class="btn btn-success col-lg-12 col-sm-12 col-xs-12 col-md-12">More</a>
					</div>
				</div>
			</div>





		</c:forEach>


	</div>
</div>





