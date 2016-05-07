<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html >
<head>
<meta charset="utf-8">
<title>MSG.AI</title>
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=Standards" />
<link href="<c:url value='/assest/images/ico/favicon.ico' />" rel="shortcut icon" type="image/vnd.microsoft.icon">
<link href= "<c:url value='/assest/css/style.css' />" media="screen" rel="stylesheet" type="text/css">
<style>
[ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak, .ng-hide {
    display: none !important;
}
</style>
<script  src="<c:url value='/assest/js/utilApiJs/jquery-1.12.0.min.js'/>" ></script>
<script  src="<c:url value='/assest/js/utilApiJs/angular.min.js'/>" ></script>
<script  src="<c:url value='/assest/js/utilApiJs/bootstrap.min.js'/>" ></script>

</head>
<body ng-app="trainingApp" ng-controller="trainingController" ng-init='enabletab=1'>

<!--Don't Delete These Divs--> <div class="topDontDel"></div><!--  <div class="botDontDel"></div> -->	<!--End Don't Delete These Divs-->

<div class="wrapper"> 
 
    <div class="gutter">
      
<div class="TopHeadSticky"> 
    <header class="page-header">
        <div class="clearfix"><h1> Cards </h1></div>
     </header>
     <div class="clearfix"></div> 
     </div>
     
     <div>
     <ul>
     <li ><input type ="button"  ng-click="enabletab=1" value='Agent'></li>
     <li> <input type ="button"  ng-click="enabletab=2" value='Entity'></li>
     <li><input type ="button"  ng-click="enabletab=3" value='Intent'></li>
     </ul>
     </div>
     <div>
     <div ng-show="enabletab=='1'">
     <input type="text" placeHolder='enter agent name' ng-model='agent'>
     <input type="button" value='save' ng-click='saveIntent()'>
     </div>
     <div ng-show="enabletab=='2'">
     <ul>
     <li ng-repeat='entry in entityList'>
     <input type="text" placeHolder='enter entity name' ng-model='entry.entityName'>
      <input type="text" placeHolder='enter synonyms' ng-model='entry.entitySynonyms'>
     </li>
         
     </ul>
     <input type="button" value='save' ng-click='saveEntity()'>
     </div>
     
     <div ng-show="enabletab=='3'"></div>
     </div>
<!-- End Header Part -->
</div>
</div>
<script>
var tariningApp=angular.module("trainingApp",[])

tariningApp.controller("trainingController",function($scope,$http){
	
	$scope.entityList=[];
	for(var i=0;i<5;i++){
		var entityObject={
				entityName:'',
				entitySynonyms :''
		}
		$scope.entityList.push(entityObject);
	
	}
	
})

</script>


</body>
</html>
