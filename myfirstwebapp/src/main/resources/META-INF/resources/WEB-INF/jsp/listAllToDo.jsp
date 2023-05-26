<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<h1>Welcome To ToDo List Page Mr/Mrs. ${userName}</h1>
<hr>
<div class="container">
	<h2>Your ToDos</h2>
	<table class="table">
		<thead>
			<tr>
				<!-- <th>ID</th> -->
				<th>UserName</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>Status</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<%-- <td>${todo.id}</td> --%>
					<td>${todo.userName}</td>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.status}</td>
					<td><a href="delete-todo?id=${todo.id}"
						class="btn btn-warning">DELETE</a></td>
					<td><a href="update-todo?id=${todo.id}"
						class="btn btn-success">UPDATE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Add ToDo</a>
</div>
<%@include file="common/footer.jspf"%>