//alert('employregi.js called');
$(document).ready(function(){

	  //  alert("employregi.js called inside ready function");


	     $("#submit").click(function(){	 

             var empId=$('#empId').val();
             var empName=$('#empName').val();
             var empSalary=$('#empSalary').val();
	         var empAddress=$('#empAddress').val();



	      $.ajax({
	          type: 'GET',    
         url:'/bin/readjson',
         data:'empId='+ empId+'&empName='+ empName+'&empSalary='+ empSalary+'&empAddress='+ empAddress,
         success: function(msg){
           alert(msg); //display the data returned by the servlet

              $('#id').html(empId);
               $('#name').html(empName);
               $('#salary').html(empSalary);
               $('#address').html(empAddress);
	        },
                   $('#id').html(empId);
               $('#name').html(empName);
               $('#salary').html(empSalary);
               $('#address').html(empAddress);
	        error: function(err) {
	             alert("Unable to retrive data "+err);
	        }
	    });
	         });

	});
