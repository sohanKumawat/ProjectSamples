/**
 * http://usejsdoc.org/
 */
'user strict'


var mainApp = angular.module('entityAnalyzerApp', ['appService']);

mainApp.controller('entityAnalyzerCtrl', ['$scope', '$http',function ($scope, $http) {
	
	console.log('hello entity module controller');
	
}])