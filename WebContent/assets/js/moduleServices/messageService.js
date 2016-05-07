/**
 * http://usejsdoc.org/
 */


(function(){
	
var app =angular.module('messageAppService', []);

app.service('messageService', function() {
	
      var scope;
      
	  var dataManipulation = function($scope,data) {
		  
		  console.log("data.name *** "+data.name);
		  scope.name=data.name;

	  };

	  var setScope=function($scope){
		  
		  scope=$scope;
		  
	  };
   var dataManipulation = function($scope,data) {
		  
		  console.log("data.name *** "+data.name);
	      $scope.name=data.name;

	  };
	  
	  return {
		viewInitilization: dataManipulation,
		setScope:setScope 
	  };

	});

})();