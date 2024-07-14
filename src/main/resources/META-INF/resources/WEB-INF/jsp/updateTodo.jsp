<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
    <link
      href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <title>Update Todo Page</title>
  </head>
  <body>
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
        Due Date:
        <form:input type="text" path="dueDate" required="required" />
        <form:errors path="dueDate" cssClass="text-warning" />
       </fieldset>
       <input type="submit" class="btn btn-success" />
      </form:form>

      <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
      <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </div>
  </body>
</html>
