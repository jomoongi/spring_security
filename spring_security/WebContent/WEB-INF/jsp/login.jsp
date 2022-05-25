<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="ui-layout-center">
<div id="content" class="ui-widget ui-widget-content ui-corner-all ui-front">

<form name="f" action="/spring_security/login" method="POST">
	<table id="errorMessage" align="center">
		<tr>
			<td>
				<div id="lastError" class="alert alert-danger"></div>
			</td>
		</tr>
	</table>
<!-- 	<table align="center" > -->
<!-- 		<tr> -->
<!-- 			<td><input type='radio' class="radioClass" name="role" value="admin" ></td> -->
<!-- 			<td width='50'>관리자</td> -->
<!-- 			<td><input type='radio' class="radioClass" name="role" value="user" checked="checked"></td> -->
<!-- 			<td width='90'>일반사용자</td> -->
<!-- 		</tr>		 -->
<!-- 	</table> -->
	<table id='dimUserTable' align="center">
		<tr>
			<td width="150">User ID</td>
			<td><input type='text' id='username' name="username" placeholder='User ID' ></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type='password' id='password' name="password" placeholder='Password.' ></td>
		</tr>
		<tr>
			<td>
				<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
			</td>
		</tr>
	</table>
	
	<table id="userTable" align="center" style="display: none;">
		<tr>
			<td width="150">Admin User ID</td>
			<td><input type='text' id='username' name="username" placeholder='Admin User Id'></td>
		</tr>
		<tr>
			<td>Admin Password</td>
			<td><input type='password' id='password' name="password" placeholder='Admin User Password.'></td>
		</tr>
	</table>	
	<table align="center">
		<tr>
			<td><input type='submit' class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only' id='but-login' value='Login'></td>
		</tr>
	</table>
</form>

    <font color="red">
        <p>Your login attempt was not successful due to <br/>
            ${errormsg}</p>
        <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
    </font>

<a href="./main">main 페이지 이동</a>

</div>
</div>
</body>
</html>