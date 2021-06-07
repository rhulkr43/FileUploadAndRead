<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read File</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<h1>Home</h1>
<div class="container">
<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12">
<nav class="navbar navbar-expand-sm bg-primary navbar-dark fixed-top">
  <a class="navbar-brand" href="#">File  Reader</a>
 
</nav>
</div>
</div>
<div class="row" style="margin-top: 6%;">
<div class="col-lg-4 col-sm-4"></div>
<div class="col-lg-4 col-sm-4">

<form action="" method="POST" enctype="multipart/form-data">

 <div class="custom-file mb-3">
      <input type="file" class="custom-file-input" id="customFile" name="file">
      <label class="custom-file-label" for="customFile">Choose file</label>
    </div>
    <i class="fa fa-file-pdf-o" style="font-size:48px;color:red"></i>
    <i class="fa fa-file-text-o" style="font-size:48px;color:red"></i>
    <i class="fa fa-file-word-o" style="font-size:48px;color:red"></i>
    <i class="fa fa-file-text" style="font-size:48px;color:red"></i>
    <i class="fa fa-file-excel-o" style="font-size:48px;color:red"></i><br><br>
    <input type="submit" value="Upload" class="btn btn-primary"/>
    </form>
</div>
<div class="col-lg-4 col-sm-4"></div>
</div>
<div class="row" style="margin-top:2%">
<div class="col-lg-12 col-md-12 col-sm-12">
<c:if test="${message!=null}">
<div class="alert alert-${class1}">
${message}
</div>
</c:if>
<hr style="margin-top: 1rem;
    margin-bottom: 1rem;
    border: 1px;
    border-top: 1px solid rgb(67 64 64);">
<table class="table table-bordered" id="datatable">

<tbody>
<c:forEach var="list" items="${list}">
<tr>
<td>${list.getId()}</td>
<td>${list.getAccount_type()}</td>
<td>${list.getPtype()}</td>
<td>${list.getAmount()}</td>
<td>${list.getRemark()}</td>
<td>${list.getName()}</td>
</tr>
</c:forEach>

</tbody>
</table>
</div>
</div>
<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12">
<div class="text-center">
<c:if test="${data!=null}">
${data}
</c:if>
</div>
</div>
</div>
</div>
<script>
$('#datatable').DataTable();
</script>
</body>
</html>