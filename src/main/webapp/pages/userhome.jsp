<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/pages/include.jsp"/>



<div align="right"><table><tr><td>
<spring:url var="fetchurl" value="/secure/logout"/>
<a href="${fetchurl}"> Logout  </a> 

                                                        </td></tr>
<tr><td><p><br/></p></td></tr>
<tr><td><p><br/></p></td></tr>
</table></div> 


<div align="center">Welcome to user home
<p />User : <c:out value="$(sessionScope.user.username)"/>
<p />Select a menu to continue
<p />
<ul>
	<li>  	<spring:url var="fetchurl" value="/general/getAvailableRooms"/>
            <a href="${fetchurl}">  Get Room Availability </a>   </li>

	<li> 	<spring:url var="fetchurl" value="/general/getAvailableRooms"/>
            <a href="${fetchurl}">  Allocate Room</a>  </li>

	<li>   	<spring:url var="fetchurl" value="/secure/getOccupiedRooms"/>
            <a href="${fetchurl}">  Deallocate Room</a>     </li>
	
</ul>
</div>
<P STYLE="margin-bottom: 0cm"><BR>
</P>



</body>
</html>