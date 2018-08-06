<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="common/header.jspf" %>
<c:set var="pageTitle" value="Survey Result Page"/>

<c:url var="parksDetailPageUrl" value="/surveyresult" />

<h2>Top 5 Parks by Votes</h2>
		<br>
<c:forEach var="parks" items="${parks}">
	<div class="parkDiv">
		<div class="parkImage">

		<c:url var="parkImageUrl" 
			   value="/img/parks/${parks.lowerCaseParkCode}.jpg"/>
		<img src="${parkImageUrl}">
		
		</div>
		<div class="parkDetails">
								
		<c:url var= "parkDetailsUrl" value="/parkdetails?parkCode=${parks.parkCode}"/>
			 <h1><c:out value="${parks.parkName} - ${parks.state}" /></h1>
			 <h2><c:out value="${parks.voteCount} - Total Votes!"/></h2>
			 <c:out value="${parks.parkDescription}"/>
		<br/>
		</div>
</c:forEach>	
</div>
	



<%@include file="common/footer.jspf" %>