<%--    Using jsp fragmation to import common html code used in multiple files. ye html code file diye path me stored hai--%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
    <h1>Welcome in To Do List</h1>
    <p>Name: ${name}</p>
    <a href="list-todos">Manage your todos</a>
    <%--Clicking on this link we will be directed to path ending with list-todos which will result in calling the Controller which has method annotated with RequestMapping with path /list-todos --%>
</div>
<%@ include file="common/footer.jspf"%>
