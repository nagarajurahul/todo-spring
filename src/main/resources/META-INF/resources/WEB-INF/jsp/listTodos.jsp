<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
  <head>
    <title>To Do Page</title>
  </head>
  <body>
    <div>Welcome to Todo - ${name}</div>
    <div>Your todos are</div>
    
    <table class="table">
	    <thead>
	     <tr>
	     	<th>id</th>
	     	<th>Description</th>
	     	<th>Due Date</th>
	     	<th> Is Done?</th>
	     </tr>
	    </thead>
	    
	    <tbody>
	    
 	    	<c:forEach items="${todos}" var="todo"> 
    	
	    		<tr>
	    			<td>${todo.id}</td>
	    			<td>${todo.description}</td>
	    			<td>${todo.dueDate}</td>
	    			<td>${todo.done}</td>
	    		</tr> 
	    		
	    	
    		</c:forEach>
	    
	    </tbody>
    
    	
    	
    	
    </table>
   
  </body>
</html>
