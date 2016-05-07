/**
 * http://usejsdoc.org/
 */
'user strict'


var mainApp = angular.module('dashboardApp', ['appService','dashboardAppService']);

mainApp.controller('dashboardController', ['$scope', '$http','httpService','dashboardService',function ($scope, $http,httpService,dashboardService) {
	
	dashboardService.setScope($scope)
	
	var inputParam={
			id:'21e3214',
			name:'sohan kumawat'
	};
	httpService.httpRequestWithBody('/fetchDeshboardDetails',inputParam).then(function(response){
		
		console.log('request is completed successfully with response data ** '+angular.toJson(response));
		dashboardService.viewInitilization($scope,response);
		
	},function(err){
	
		console.log('request not completed successfully');
	
	});
	//httpGet: getRequest,
	console.log('hello dashboard module controller');
	
}])
    