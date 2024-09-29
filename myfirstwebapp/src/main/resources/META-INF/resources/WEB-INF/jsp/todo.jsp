<%--    Using jsp fragmation to import common html code used in multiple files. ye html code file diye path me stored hai--%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf" %>
    <div class="container">
        <h1>Enter To Do</h1>

<%--            <form:form modelAttribute="todo"> use kiya hai. Iska matlab form ka har field Todo object ke kisi property ke saath bind hoga, jaise:
            <form:input path="description" /> ka link Todo object ke description field se hoga.--%>
        <form:form method="post" modelAttribute="todo">
            <fieldset class="mb-3">
                <form:label path="description">Description</form:label>
                <form:input type="text" path="description" required="required"/>
            </fieldset>

            <fieldset class="mb-3">
                <form:label path="targetDate">Change Date</form:label>
                <form:input type="text" path="targetDate" required="required"/>
            </fieldset>
            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="done"/>
            <input type="submit" class="btn btn-success"/>
        </form:form>
    </div>


<%--    Using jsp fragmation to import common html code used in multiple files. ye html code file diye path me stored hai--%>
<%@ include file="common/footer.jspf"%>
<%--        After adding src of DatePicker CSS and JS we can use this script taken after doing google--%>
<script type="text/javascript">
<%--            targetDate is the name of the variable. # id ke liye--%>
$('#targetDate').datepicker({
    format: 'yyyy/mm/dd',
});
</script>