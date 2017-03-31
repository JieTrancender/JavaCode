// $(function(){
	$.ajax({
	type:'post',
	url:'http://localhost:8080/AddServlet',
	data:'name=Jason&phone=18681700917&email=jie-email@jie-trancender.org&title=ajax-test&content=i am trying post data by ajax',
	cache:'false',
	dataType:'string',
	success:function(data){
		alert("Success!")
	}
});
// });