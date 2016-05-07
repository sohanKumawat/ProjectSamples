<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>MSG.AI</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=Standards" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<!--   ***********************  THIRD PARTY DEPENDENCY CSS FILE START FROME HERE *************** -->
<link href="assets/css/nsPopover.css" media="screen" rel="stylesheet" type="text/css">


<!--   ***********************   CUSTOM FILES DEPENDENCY ******************* -->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link href="assets/css/intent.css" media="screen" rel="stylesheet" type="text/css">
<link href="assets/css/response.css" media="screen" rel="stylesheet" type="text/css">

<!-- *************************   CSS FILE DEPENDENCY END HERE **************** -->
<style>
.TopHeadSticky {margin-bottom:0px;}
</style>
 <!--      **********************  third party dependency ************************-->
<script type="text/javascript" src="assets/js/thirdPartyApi/jQuery-2.1.4.min.js"></script> 
<script type="text/javascript" src="assets/js/thirdPartyApi/angular.min.js"></script> 
<script type="text/javascript" src="assets/js/thirdPartyApi/angular-route.min.js"></script> 
<script type="text/javascript" src="assets/js/thirdPartyApi/bootstrap.min.js"></script> 
<script type="text/javascript" src="assets/js/thirdPartyApi/enscroll-0.6.1.min.js"></script> 
<script type="text/javascript" src="assets/js/thirdPartyApi/nsPopover.js"></script>
<script type="text/javascript" src="assets/js/thirdPartyApi/angular-sanitize.min.js"></script>


<script type="text/javascript" src="assets/js/thirdPartyApi/mainScriptTraining.js"></script>
<script type="text/javascript" src="assets/js/thirdPartyApi/mainScript.js"></script> 

 <!--  *********************App route & service configuration dependency***************** -->
   <script type="text/javascript" src="assets/js/core/appModule.js"></script> 
   <script type="text/javascript" src="assets/js/core/config.route.js"></script> 
   <script type="text/javascript" src="assets/js/core/appService.js"></script> 
 
 <!-- **********************Custom module service configuration****************** -->
  <script type="text/javascript" src="assets/js/moduleServices/dashboardService.js"></script> 
  <script type="text/javascript" src="assets/js/moduleServices/IntentModuleService.js"></script>
  <script type="text/javascript" src="assets/js/moduleServices/messageService.js"></script>
 
 <!-- **********************Custom module configuration****************** -->
   <script type="text/javascript" src="assets/js/modules/dashboardModule.js"></script>
   <script type="text/javascript" src="assets/js/modules/intentModule.js"></script>
   <script type="text/javascript" src="assets/js/modules/entityModule.js"></script>
   <script type="text/javascript" src="assets/js/modules/messageModule.js"></script>
 
 <!-- **********************Custom controller configuration************** -->
   <script type="text/javascript" src="assets/js/controllers/dashboardController.js"></script>
   <script type="text/javascript" src="assets/js/controllers/intentAnalyzerController.js"></script>
   <script type="text/javascript" src="assets/js/controllers/entityAnalyzerController.js"></script>
   <script type="text/javascript" src="assets/js/controllers/messageController.js"></script>


   <script>
      function disableClick(){
        document.onclick=function(event){
          if (event.button == 2) {
            return false;
          }
        }
      }
    </script>

</head>
<body onLoad="disableClick()">
<sec:authorize access="hasRole('ROLE_USER')">
		<form action="/j_spring_security_logout" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
<div class="topDontDel"></div>
<div class="wrapper" ng-app='msgaiTrainingApp' ng-contrpller='msgaiTrainingCtrl' ng-init="tab='Dashboard'"> 
<!-- Left Side NavBar -->
  <aside class="left-panel"> 
  <div id="logoContainer">
  <a ng-class="{active: isActive('/Dashboard') }" href="#dashboard" id="logo">MSG.AI</a>
  </div>
 <!-- -->
    <nav class="main-nav height100per" style="padding-top:8px;">
      <ul class="list-unstyled">
      <li ng-class="{'active':tab=='Dashboard'}" ><a href="#dashboard" title="dashboard" ng-click="tab='Dashboard'"><i class="nav-ico dashboard" ></i><span>Dashboard</span></a></li>
      <li ng-class="{'active':tab=='Intent'}" ><a href="#intent" title="intent" ng-click="tab='Intent'"><i class="nav-ico dashboard"></i><span>Intent</span></a></li>
      <li ng-class="{'active':tab=='Entity'}" ><a href="#entity" ng-click="tab='Entity'"><i class="nav-ico cards"></i><span>Entity</span></a></li>
      <li ng-class="{'active':tab=='message'}" ><a href="#message" ng-click="tab='message'"><i class="nav-ico conversations"></i><span>Messages</span></a></li>
      <li ng-class="{'active':tab=='Settings'}" ><a href="#Setting" ng-click="tab='Settings'"><i class="nav-ico settings"></i><span>Settings</span></a></li>
      </ul>
    </nav>
<nav class="bottom-nav">
      <ul class="nav-justified list-unstyled">
	       <li>
	       <img src="${userSessionBean.tenant.brandImage}" class="img-circle mask" width="30px">
	         <span class=" hidden-name"> &nbsp;&nbsp;&nbsp;${userSessionBean.user.firstName}
	         </span>
	         </li>
	        <li><button class="btn btn-default btn-xs" onclick="formSubmit()">Logout</button></li>
      </ul>
</nav>
</aside>
  <div class="gutter">
   <ng-view></ng-view>
  </div>
 </div>
</sec:authorize>
<script>
var mainApp = angular.module('msgaiTrainingApp').controller('msgaiTrainingCtrl', ['$scope', '$http',function ($scope, $http) {
}]);
</script>
</body>
</html>