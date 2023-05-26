<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<h1>Welcome To Add ToDo Page Mr/Mrs. ${userName}</h1>
<hr>
<div class="container">
	<h2>Enter Your ToDo Details</h2>
	<form:form method="post" modelAttribute="toDo">
		<fieldset class="mb-3">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="text" path="targetDate" required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>


		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="status" />
		<form:input type="hidden" path="targetDate" />
		<input type="submit" class="btn btn-success" />
	</form:form>
</div>
<%@include file="common/footer.jspf"%>
<script
	src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd',
	});
</script>
