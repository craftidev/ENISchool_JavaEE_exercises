<%@
    page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"
%>

<% // Scriplet
    String caption = request.getParameter("caption");
%>

<%! // Class level Java
%>

<table><caption>${parameter.caption}</caption></table>

<!-- TODO DB display, food, errorcodes etc. -->
<div class="button-container">
    <button class="button-select-crud" data-target="div-meals">My Meals</button>
    <button class="button-select-crud" data-target="div-foods">Food list</button>
</div>

<div class="form-appear-on-button" id="div-meals">
    <form method="POST" action="SPAServlet" data-action="crud" class="dynamic-form">
        <input type="hidden" name="caption" value="List of meals">
        <input type="submit" value="meal">
    </form>
</div>

<div class="form-appear-on-button" id="div-foods">
    <form method="POST" action="SPAServlet" data-action="crud" class="dynamic-form">
        <input type="hidden" name="caption" value="List of foods">
        <input type="submit" value="food">
    </form>
</div>