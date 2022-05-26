<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Security - Login</title>

    <!-- Custom fonts for this template-->
    <link href="./resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="./resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                                    </div>
                                    <form class="user" name="f" action="/spring_security/login" method="POST">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                id="username" name="username" aria-describedby="emailHelp"
                                                placeholder="아이디 입력">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="password" name="password" placeholder="비밀번호 입력">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Remember
                                                    Me</label>
                                            </div>
                                        </div>
                                        <input type='submit' class="btn btn-primary btn-user btn-block" value='로그인'>
                                        <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
                                        <hr>
                                        <a href="index.html" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> Login with Google
                                        </a>
                                        <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                            <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                        </a>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="forgot-password.html">Forgot Password?</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="register.html">Create an Account!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="./resources/vendor/jquery/jquery.min.js"></script>
    <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="./resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="./resources/js/sb-admin-2.min.js"></script>

</body>

<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->
<!-- <div class="ui-layout-center"> -->
<!-- <div id="content" class="ui-widget ui-widget-content ui-corner-all ui-front"> -->

<!-- <form name="f" action="/spring_security/login" method="POST"> -->
<!-- 	<table id="errorMessage" align="center"> -->
<!-- 		<tr> -->
<!-- 			<td> -->
<!-- 				<div id="lastError" class="alert alert-danger"></div> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
<!-- <!-- 	<table align="center" > --> -->
<!-- <!-- 		<tr> --> -->
<!-- <!-- 			<td><input type='radio' class="radioClass" name="role" value="admin" ></td> --> -->
<!-- <!-- 			<td width='50'>관리자</td> --> -->
<!-- <!-- 			<td><input type='radio' class="radioClass" name="role" value="user" checked="checked"></td> --> -->
<!-- <!-- 			<td width='90'>일반사용자</td> --> -->
<!-- <!-- 		</tr>		 --> -->
<!-- <!-- 	</table> --> -->
<!-- 	<table id='dimUserTable' align="center"> -->
<!-- 		<tr> -->
<!-- 			<td width="150">User ID</td> -->
<!-- 			<td><input type='text' id='username' name="username" placeholder='User ID' ></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>Password</td> -->
<!-- 			<td><input type='password' id='password' name="password" placeholder='Password.' ></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td> -->
<%-- 				<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"> --%>
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
	
<!-- 	<table id="userTable" align="center" style="display: none;"> -->
<!-- 		<tr> -->
<!-- 			<td width="150">Admin User ID</td> -->
<!-- 			<td><input type='text' id='username' name="username" placeholder='Admin User Id'></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>Admin Password</td> -->
<!-- 			<td><input type='password' id='password' name="password" placeholder='Admin User Password.'></td> -->
<!-- 		</tr> -->
<!-- 	</table>	 -->
<!-- 	<table align="center"> -->
<!-- 		<tr> -->
<!-- 			<td><input type='submit' class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only' id='but-login' value='Login'></td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
<!-- </form> -->

<!--     <font color="red"> -->
<!--         <p>Your login attempt was not successful due to <br/> -->
<%--             ${errormsg}</p> --%>
<!--         <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/> -->
<!--     </font> -->

<!-- <a href="./main">main 페이지 이동</a> -->

<!-- </div> -->
<!-- </div> -->
<!-- </body> -->
</html>