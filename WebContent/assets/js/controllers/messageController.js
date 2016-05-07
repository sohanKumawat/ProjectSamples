/**
 * http://usejsdoc.org/
 */
'user strict'


var mainApp = angular.module('messageModuleApp', ['appService']);

mainApp.controller('messagesCtrl', ['$scope', '$http',function ($scope, $http) {
	
	console.log('hello entity module controller');
	
}])