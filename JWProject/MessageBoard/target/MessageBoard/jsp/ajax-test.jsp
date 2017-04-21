<%--
  Created by IntelliJ IDEA.
  User: JTrancender
  Date: 2017/3/31
  Time: 6:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
	<title>Title</title>
	<script src="../js/vendor/jquery/jquery.min.js"></script>
	<script>
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
	</script>
</head>
<body>
	fsadfasdfasdf
</body>
</html>
