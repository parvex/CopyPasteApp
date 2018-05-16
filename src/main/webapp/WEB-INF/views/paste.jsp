<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css"> 


	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


	<title>Paste your paste!</title>


<!-- Create a simple CodeMirror instance -->
<link rel="stylesheet" href="resources/js/codemirror/lib/codemirror.css">
<script src="resources/js/codemirror/lib/codemirror.js"></script>

</head>

<body>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <ul class="nav nav-pills">
            <li class="nav-item">
              <a class="active nav-link">
                <i class="fa fa-copy"></i>CopyPasteApp</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="/profile">${user.nick}<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="/paste">Paste<span class="sr-only">(current)</span></a>
           </li>
           <li class="nav-item active pull-right">
              <a class="nav-link" href="logout">logout<span class="sr-only">(current)</span></a>
           </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
 <form:form modelAttribute="paste" action="savePaste" method="POST">
  		 <form:hidden path="id"/>
  		 <form:hidden path="path"/>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <form:input path="title" type="title" name="title" class="form-control" placeholder="Title" style="margin-top: 50px;"/> </div>
        <div class="col-md-4"></div>
      </div>
    </div>
  </div>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <form:input path="author" type="author" name="author" class="form-control" placeholder="Author"/> </div>
      </div>
    </div>
  </div>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
            <div class="w-100 h-50">
            	<pre>
              	<form:textarea path="paste" id="code" class="form-control" name="code" rows="20" tabindex="4" />
         	    </pre>
              <script>
                  var editor = CodeMirror.fromTextArea(document.getElementById("code"), {
                    lineNumbers: true
                     });
              </script>
      </div>
    </div>
  </div>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
		  <label><form:checkbox path="syntax"/>Syntax Highlight</label>
          <input type="submit" value="Generate Link" class="btn btn-primary pull-right m-2" href="#" style="margin-right:20px;" />
        </div>
      </div>
    </div>
  </div>
 </form:form>



<script>
$(function() {
	$(".lined").linedtextarea(
		{selectedLine: 1}
	);
});
</script>


</body>
</html>