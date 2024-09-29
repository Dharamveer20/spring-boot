<%--    Using jsp fragmation to import common html code used in multiple files. ye html code file diye path me stored hai--%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf" %>
<%-- Bootstrap provides us many classes like container,table,etc using which we can enhance the look of our application    --%>
    <div class="container">
        <h1> ${name} your Todos are </h1>

        <table class="table">
            <tr>
                <th>Description</th>
                <th>Target Data</th>
                <th>Is Done?</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
            <c:forEach items="${todos}"  var="todo">
                <tr>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                    <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="add-todo" class="btn btn-success">Add Todo</a>
    </div>
<%@ include file="common/footer.jspf" %>
