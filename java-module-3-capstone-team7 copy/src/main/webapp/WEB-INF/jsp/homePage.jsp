<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Parks Home Page"/>
<%@include file="common/header.jspf" %>
<c:url var="parksHomePageUrl" value="/"/>


<c:forEach var="parks" items="${parks}">
	<div class="parkDiv">
		<div class="parkImage">

		<c:url var="parkImageUrl" 
			   value="/img/parks/${parks.lowerCaseParkCode}.jpg"/>
		<img src="${parkImageUrl}"/>
		
		</div>
		<div class="parkDetails">
								
		<c:url var= "parkDetailsUrl" value="/parkdetails?parkCode=${parks.parkCode}"/>
			 <h1><a class= "parkName" href="${parkDetailsUrl}"><c:out value="${parks.parkName}" /></a></h1>
		<c:out value="${parks.parkDescription}"/>
		<br/>
		</div>
</div>
</c:forEach>

