  <%@ include file="common/header.jspf" %>
  <%@ include file="common/navigation.jspf" %>	
    <div class="container">
      <div>Welcome to Update Todo Page - ${name}</div>
      <div><a href="/list-todos">Manage</a> your todos.</div>

      <form:form action="/update-todo?id=${todo.id}" method="post" modelAttribute="todo">
        <fieldset class="mb-3">
        Description:
        <form:input type="text" path="description" required="required" />
        <form:errors path="description" cssClass="text-warning" />
       </fieldset>
       <fieldset class="mb-3">				
			<form:label path="dueDate">Due Date</form:label>
			<form:input type="text" path="dueDate" required="required"/>
			<form:errors path="dueDate" cssClass="text-warning"/>
		</fieldset>
       <input type="submit" class="btn btn-success" />
      </form:form>

	<%@ include file="common/footer.jspf" %>	
	
 	<script type="text/javascript">
		$('#dueDate').datepicker({
		    format: 'yyyy-mm-dd'
		});
	</script>

	