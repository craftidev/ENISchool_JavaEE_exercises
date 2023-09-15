<%@
    page language = "java"
    contentType   = "text/html; charset=UTF-8"
    pageEncoding  = "UTF-8" 
    isELIgnored   = "false"
%>


<% // Scriplet
    String caption = "";
    if (request.getParameter("submit") != null) {
        caption = request.getParameter("submit");
    }
    else if (request.getParameter("editAction") != null) {
        caption = request.getParameter("editAction");
    }
    else if (request.getParameter("deleteAction") != null) {
        caption = request.getParameter("deleteAction");
    }
%>

<%! // Class level Java
%>

<div class="button-container">
    <button class="button-select-crud" data-target="div-meals">Add a meal</button>
    <button class="button-select-crud" data-target="div-foods">Food list</button>
</div>


<div class="form-appear-on-button" id="div-foods">
    <form method="POST" action="DBPoolConnectionServlet" data-action="createFood" class="dynamic-form" id="form-foods">
        <label for="nameInput">Name:</label>
        <input type="text" name="nameInput" id="nameInput" maxlength="20" size="10">
        <br>
        <label for="descriptionInput">Description:</label>
        <input type="text" name="descriptionInput" id="descriptionInput">
        <br>
        <input type="submit" value="New food">
        <input type="hidden" name="submit" value="foods">
    </form>
</div>

<div class="form-appear-on-button" id="div-meals">
    <form method="POST" action="DBPoolConnectionServlet" data-action="createMeal" class="dynamic-form" id="form-meals">
        <label for="dateInput">Select a Date:</label>
        <input type="date" name="dateInput" id="dateInput">
        <br>
        <label for="foodSelect">Select the composition of the meal:</label>
        <select type="select" id="foodSelect" name="foodSelect">
            <!-- TODO generated -->
            <option value="1">one</option>
            <option value="2">two</option>
        </select>
        <br>qsdf<br>
        <input type="submit">
        <input type="hidden" name="submit" value="meals">
    </form>
</div>

<table class="dynamic-table">
    <caption>Caption</caption>
    <tr>
        <th>Action</th>
        <th class="even-opacity">Date</th>
        <th>Composition</th>
    <tr>
        <td>
            <Button class="button-POST-editdelete" servlet-action="deleteMeal" element-id="1">x</Button>
            <Button class="button-POST-editdelete" servlet-action="editMeal" element-id="1">edit</Button>
        </td>
        <td class="even-opacity">test3</td>
        <td>this1, that15, some stuff here, and others</td>
    </tr>
    <tr>
        <td>
            <Button class="button-POST-editdelete" servlet-action="deleteMeal" element-id="2">x</Button>
            <Button class="button-POST-editdelete" servlet-action="editMeal" element-id="2">edit</Button>
        </td>
        <td class="even-opacity">test5</td>
        <td>lorem ipsum lorem lorem qsdfiel mq, joeizfjjks, iejf qmlkej</td>
    </tr>
</table>

Form action sent: ${param.action}<br>
Servlet action response: ${dynamicTableContent}<br>
ID: ${param.elementId}<br>

<!-- TODO DB display, food, errorcodes etc. -->