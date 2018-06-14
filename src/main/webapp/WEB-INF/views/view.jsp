<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
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

  <title>${paste.title}</title>


<!-- Create a simple CodeMirror instance -->
<link rel="stylesheet" href="/resources/js/codemirror/lib/codemirror.css">
<script src="/resources/js/codemirror/lib/codemirror.js"></script>



  <!-- highlight <pre><code>here...-->
  <link rel="stylesheet"
      href="https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@9.12.0/build/styles/default.min.css">
  <script src="https://cdn.jsdelivr.net/gh/highlightjs/cdn-release@9.12.0/build/highlight.min.js"></script>
  <script>
  if(${paste.syntax} == true)
  	hljs.initHighlightingOnLoad();</script>
  	
  <script>
  function htmlEncode(value){
	  return $('<div/>').text(value).html();
	}
  </script>
  <script>
  function CopyToClipboard(containerid) {
	  if (document.selection) { 
	      var range = document.body.createTextRange();
	      range.moveToElementText(document.getElementById(containerid));
	      range.select().createTextRange();
	      document.execCommand("copy"); 

	  } else if (window.getSelection) {
	      var range = document.createRange();
	       range.selectNode(document.getElementById(containerid));
	       window.getSelection().addRange(range);
	       document.execCommand("copy");
	  }}
  </script>

</head>

<body>
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
          </ul>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 center-block">
          <button  onclick="CopyToClipboard('copy')" class="btn btn-primary center-block" style = "margin-bottom: 10px;">Copy</button>
        </div>
      </div>
 <div class="container">
  <h1>Title: ${paste.title}</h1>
  <h2>Author: ${paste.author}</h2>

  <pre>
  <code id="copy">${paste.paste}</code>
   </pre>

<textarea id="code" class="form-control" name="code" rows="20" tabindex="4">${paste.paste}</textarea>

<script>
var editor = CodeMirror.fromTextArea(document.getElementById("code"), {
  lineNumbers: true
   });
</script>


      <div class="row">
        <div class="col-md-12">

        </div>
      </div>
    </div>

   </div>



</body>

</html>