
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Spring MVC file upload example</h2>

<form method="POST" action="<c:url value='/upload' />"
    enctype="multipart/form-data">


    Please select a file to upload : <input type="file" name="file" /><br>
    <input type="submit" value="upload" />
   

</form>
</body>
</html>