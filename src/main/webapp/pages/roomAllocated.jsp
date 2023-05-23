<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="/pages/include.jsp"/>





<div align="right"><table><tr><td>  
<spring:url var="fetchurl" value="/secure/logout"/>
<a href="${fetchurl}"> Logout  </a>  </td></tr>
<tr><td><p><br/></p></td></tr>
<tr><td><p><br/></p></td></tr>
</table></div> 


<div align="center">
<TABLE WIDTH=40% BORDER=1 BORDERCOLOR="#aabbcc">
<tr><td>Room has been allocated</td></tr>
<tr><td> 		<spring:url var="fetchurl" value="/secure/home"	/>


<a href="${fetchurl}"> Home </a>
</td></tr>
</TABLE>