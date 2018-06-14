<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css"> 
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        
        <title>CopyPasteApp Profile</title>
    </head>
    <body>
    <div class="container">
    
    
    	 <ul class="nav nav-pills">
            <li class="nav-item">
              <a class="active nav-link">
                <i class="fa fa-copy"></i>CopyPasteApp</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="profile">${user.nick}<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="paste">Paste<span class="sr-only">(current)</span></a>
           </li>
		   <li class="nav-item active pull-right">
              <a class="nav-link" href="logout">logout<span class="sr-only">(current)</span></a>
           </li>
          </ul>
    
    	<div class="mt-3" align="center">
	        <table style="margin-top: 7px;"" class="table" border="1">
	          <thead>
	          	<th scope="col">ID</th>
	        	<th scope="col">Title</th>
	        	<th scope="col">Author</th>
	        	<th scope="col">Syntax</th>
	        	<th scope="col">Link</th>
	        	<th scope="col">Action</th>
	          </thead>
	          <tbody>
				<c:forEach var="paste" items="${listPaste}" varStatus="status">
	        	<tr>
	        		<th scope="row">${paste.id}</th>
	        		<td>${paste.title}</td>
					<td>${paste.author}</td>
					<td>${paste.syntax}</td>
					<td><a target="_blank" href="view/${paste.path}">link</a></td>
					<td>
						<a href="editPaste?id=${paste.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deletePaste?id=${paste.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	
			  </tbody>        	
			</table>
    	</div>
    </div>
    </body>
</html>
