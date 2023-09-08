<%@
    page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"
    isErrorPage="true"
%>

<h1>Sorry, an error occured</h1>
<p>Exception:&nbsp; <%= exception.getClass().getName() %></p>
<p>Message:&nbsp; <%= exception.getMessage() %></p>
<br>
<a href="<%= request.getContextPath() %>">Back</a>
