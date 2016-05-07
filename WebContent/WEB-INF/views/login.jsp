<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>MSG-AI Portal Login</title>

<link href='/assets/css/bootstrap.css' rel="stylesheet" type="text/css"></link>
<link href='/assets/css/login.css' rel="stylesheet" type="text/css"></link>


<script>
	function validation()
	{
		if($.trim($('#loginId').val()) == '' && $.trim($('#password').val()) == '')
		{
			$("#loginId").addClass("error");
			$("#password").addClass("error");
			return false;
		}
		else if($.trim($('#loginId').val()) != '' && $.trim($('#password').val()) == '')
		{
			$("#loginId").removeClass("error");
			$("#password").addClass("error");
			return false;
		}
		else if($.trim($('#loginId').val()) == '' && $.trim($('#password').val()) != '')
		{
			$("#loginId").addClass("error");
			$("#password").removeClass("error");
			return false;
		}
		else
		{
			return true;
		}
	}
</script>

</head>
<body>
  	  <div class="loginwrapper">
          <div class="logoArea"><a href="#">MSG.AI</a></div>
          <div class="loginareaBlock">
                         
<form  name='loginForm' action="<c:url value='/login' />" method="POST" class="form-signin">
 <div class="form-group">
        <input type="text" placeholder="Email" class="form-control"  id="loginId" name="loginId" autofocus="autofocus">
        
      </div>
      <div class="form-group">
        <input type="password" placeholder="Password" class="form-control" id="password" name="password">
      </div>
      
 <div class="marBot29px">

       <c:if test="${not empty error}">
		<div class="error">Invalid email or Password.</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="error">Invalid email or Password.</div>
		</c:if>
</div>
      <div>
        <input type="submit" class="btn btn-default" value="Login">
      </div>
 
 </form>
          </div>
        </div>
     <!-- footer -->
  <footer class="login clearfix">msg.ai © 2016</footer>

</body>
</html>