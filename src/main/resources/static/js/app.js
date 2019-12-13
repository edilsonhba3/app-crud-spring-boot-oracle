$(document).ready(function () {
	console.log("app.js");
	var baseUrl = "user";
	var domainUrl = "/app-crud-spring-boot-oracle";
	var POST = "POST";
	
	$(document).on("click", '.seeUser', function(){
		//console.log("btnSee");
		var id = $(this).attr("data-info");
		//console.log(id);
		$("#btnUpdateSave").hide();
		loadDataUser(false, id);	
	});
	
	$(document).on("click", '.editUser', function(){
		console.log("btnEdit");
		var id = $(this).attr("data-info");
		//console.log(id);
		
		loadDataUser(true, id);
		$("#btnUpdateSave").show();
	});
	
	function loadDataUser(edit, id)
	{
		if(edit)
		{
			enableInputs();
			loadData("seeUserModal", id);
		}
		else
		{
			disableInputs();
			loadData("seeUserModal", id);
		}
	}
	
	function disableInputs()
	{
		$("#seeUserName").prop("disabled", true);
		$("#seeUserLastname").prop("disabled", true);
		$("#seeUserEmail").prop("disabled", true);
	}
	
	function enableInputs()
	{
		$("#seeUserName").prop("disabled", false);
		$("#seeUserLastname").prop("disabled", false);
		$("#seeUserEmail").prop("disabled", false);
	}
	
	function loadData(modal, id)
	{
		$.ajax({
			type : POST,
	 		url  : baseUrl + "/findOne",	
	 		data : ({id : id}),
	 		success: function (data){
	 			//console.log(data);
	 			$("#seeUserId").val(data.pk);
	 			$("#seeUserName").val(data.name);
	 			$("#seeUserLastname").val(data.lastName);
	 			$("#seeUserEmail").val(data.email);
	 			$('#'+ modal).modal('show');	 			
	 		},
	 		error: function (error){
	 			console.log(error);
	 		}
		});
	}
	
	$('#btnUpdateSave').click(function(){	
		var id 		  = $("#seeUserId").val();
		var firstname = $("#seeUserName").val();
		var lastname  = $("#seeUserLastname").val();
		var email     = $("#seeUserEmail").val();
		
		$.ajax({
			type : POST,
	 		url  : baseUrl + "/update",	
	 		data : ({id : id, firstname : firstname, lastname : lastname, email : email}),
	 		success: function (data){
	 			console.log(data);
	 			$('#seeUserModal').modal('hide');	
	 			window.location = domainUrl;
	 		},
	 		error: function (error){
	 			console.log(error);
	 		}
		});
	});
	
	$(document).on("click", '.removeUser', function(){
		var id = $(this).attr("data-info");
		$("#idDeleteUser").val(id);
		$('#deleteModal').modal('show');
	});
	
	$('#btnRemoveConfirm').click(function(){
		var id = $("#idDeleteUser").val();
		// $('#seeUserModal').modal('show');
		$.ajax({
			type : POST,
	 		url  : baseUrl + "/remove",	
	 		data : ({id : id}),
	 		success: function (data){
	 			$('#deleteModal').modal('hide');	
	 			window.location = domainUrl;
	 		},
	 		error: function (error){
	 			console.log(error);
	 		}
		});
	});
	
	$("#btnNewAjax").click(function(){
		$('#newUserModal').modal('show');
	});
	
	
	$('#btnSaveNew').click(function() {	
		var firstname = $("#userNameNew").val();
		var lastname  = $("#userLastnameNew").val();
		var email     = $("#userEmailNew").val();
		var pass 	  = $("#userPassNew").val();
		
		$.ajax({
			type : POST,
	 		url  : baseUrl + "/saveAjax",	
	 		data : ({firstname : firstname, lastname : lastname, email : email, pass : pass}),
	 		success: function (data){
	 			console.log(data);
	 			$('#seeUserModalNew').modal('hide');	
	 			window.location = domainUrl;
	 		},
	 		error: function (error){
	 			console.log(error);
	 		}
		});
	});
	
});