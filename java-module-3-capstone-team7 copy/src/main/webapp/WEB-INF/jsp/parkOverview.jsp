<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="common/header.jspf"%>
<c:set var="pageTitle" value="Park Detail Page" />

<c:url var="parksDetailPageUrl" value="/parkdetails" />

<h1 class="parkTitle">
	<c:out value="${parks.parkName} - ${parks.state}" />
</h1>

<div class=parkOverviewImage>
	<c:url var="parkImageUrl"
		value="/img/parks/${parks.lowerCaseParkCode}.jpg" />
	<img src="${parkImageUrl}">
</div>

<div class="detailsDescription">
	<c:out value="${parks.parkDescription}" />
</div>
<br />
<div>
	<c:out value="${parks.inspirationalQuote}" />
	<br />
	<c:out value="-${parks.inspirationalQuoteSource}" />

</div>
<br />
<br />
<div class="container-fluid">
	<table class="table">
		<tr>
			<th scope="col">Year Founded</th>
			<th scope="col">Entry Fee</th>
			<th scope="col">Acreage</th>
			<th scope="col">Elevation in Feet</th>
			<%--	<th scope="col">Miles of Trail</th> --%>
			<th scope="col">Number of Campsites</th>
			<th scope="col">Climate</th>
			<th scope="col">Annual Visitor Count</th>
			<th scope="col">Number of Animal Species</th>
		</tr>
		<tr>
			<td scope="row">${parks.yearFounded}</td>
			<td>$${parks.entryFee} per day</td>
			<td>${parks.acreage}</td>
			<td>${parks.elevationInFeet}</td>
			<%--<td>${parks.milesoftrail}</td> --%>
			<td>${parks.numberOfCampsites}</td>
			<td>${parks.climate}</td>
			<td>${parks.annualVisitorCount}</td>
			<td>${parks.numberOfAnimalSpecies}</td>
		</tr>

	</table>
</div>
<br/>


<div class="weatherInfo">
	<c:url var="formAction" value="/parkdetails?parkCode=${parks.parkCode}"/>
	<form method="POST" action="${formAction}">
	<label for="tempFormat">Temperature Format</label>
	<select name="isCelsius">
		<option value="false" ${isCelsius ? '' : 'selected'}>Fahrenheit</option>
		<option value="true" ${isCelsius ? 'selected' : ''}>Celcius</option>
	</select>
	<input type="submit" name="submit" class="btn btn-success" value="Go" />
	</form>
	<c:forEach var="weather" items="${weather}">

	<h1>Today's Forecast</h1>
		<div class="todaysWeather">
	<br/>
	<br/>
			<c:url var="weatherImgUrl"
				value="/img/weather/${weather.forecast}.png" />
			<img src="${weatherImgUrl}" />
	<p class="temp">    
			<strong>LOW: </strong>
			<c:choose> 
			<c:when test="${isCelsius }">
				<c:out value="${Math.round((weather.low - 32) * (5/9))} C" />
			</c:when>
			<c:otherwise> 
			<c:out value=" ${weather.low} F" />
			</c:otherwise>
			</c:choose>
			<br/>
			<strong>HIGH: </strong>
				<c:choose> 
			<c:when test="${isCelsius }">
				<c:out value="${Math.round((weather.high - 32) * (5/9))} C" />
			</c:when>
			<c:otherwise> 
			<c:out value=" ${weather.high} F" />
			</c:otherwise>
			</c:choose>
			</p>
			<div>
			<c:choose>
				<c:when test="${weather.forecast == 'snow'}">
					<c:out value="Pack some snowshoes"/>
				</c:when>
					
				<c:when test="${weather.forecast == 'rain'}">
					<c:out value="Pack some rain gear and watershoes"/>
				</c:when>
				
				<c:when test="${weather.forecast == 'thunderstorms'}">
					<c:out value="Seek shelter and avoid hiking on exposed ridges"/>
				</c:when>
				
				<c:when test="${weather.forecast == 'sunny'}">
					<c:out value="Pack some sunblock"/>
				</c:when>
			</c:choose>
			</div>
			
			<div>
			<c:choose>
				<c:when test="${weather.high > 75}">
					<c:out value="Bring an extra gallon of water!"/>
				</c:when>
			</c:choose>
			
			<c:choose>
				<c:when test="${weather.high < 25}">
					<c:out value="Please be aware of dangerous conditions due to low temperatures!"/>
				</c:when>
			</c:choose>
			
			<c:choose>
				<c:when test="${(weather.high-weather.low) >20}">
					<c:out value="Wear some breathable layers!"/>
				</c:when>
			</c:choose>
			
			</div>
			
			<h1>Rest of the week</h1>
			

		</div>
		<br/>
	</c:forEach>
<div class="fourDay">

	<c:forEach var="weather" items="${futureWeather}">
		<c:url var="weatherImgUrl"
			value="/img/weather/${weather.forecast}.png" />
		<img src="${weatherImgUrl}" />
	<p class="temp2">  
		<strong>LOW: </strong>
		<c:choose> 
			<c:when test="${isCelsius }">
				<c:out value="${Math.round((weather.low - 32) * (5/9))} C" />
			</c:when>
			<c:otherwise> 
			<c:out value=" ${weather.low} F" />
			</c:otherwise>
			</c:choose>
		<br/>
		<strong>HIGH: </strong>
		<c:choose> 
			<c:when test="${isCelsius }">
				<c:out value="${Math.round((weather.high - 32) * (5/9))} C" />
			</c:when>
			<c:otherwise> 
			<c:out value=" ${weather.high} F" />
			</c:otherwise>
		</c:choose>
	</p>

	</c:forEach>
	</div>
	
	
</div>


<%@include file="common/footer.jspf"%>


