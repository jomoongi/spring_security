<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>member</h5>
<form action="/cf_da_rest/deploy" method="POST">
    <div>
      <label>어플리케이션명</label>
      <input name="applicationName" />
    </div>
    <div>
      <label>version</label>
      <input name="version"/>
    </div>
    <button type="submit">전송</button>
</form>
</body>
</html>