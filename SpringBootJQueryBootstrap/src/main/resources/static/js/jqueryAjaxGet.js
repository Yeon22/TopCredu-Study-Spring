$(document).ready(function(){
	ajaxGet();
	
	//DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : window.location + "api/customer/all",
			success : function(result){
				$.each(result, function(i, customer){
					var customerRow = '<tr>' + '<td>' + customer.id + '</td>' +
									'<td>' + customer.name.toUpperCase() + '</td>' +
									'<td>' + customer.age + '</td>' + 
									'<td>' + customer.address.street + '</td>' + 
									'<td>' + customer.address.postcode + '</td>' + 
									'</tr>';
					$('#customerTable tbody').append(customerRow);
				});
				
				$("#customerTable tbody tr:odd").addClass("info");
				$("#customerTable tbody tr:even").addClass("success");
			},
			error : function(e){
				alert("ERROR: ",e);
				console.log("ERROR: ",e);
			}
		});
	}
})