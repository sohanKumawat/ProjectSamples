/**
 * http://usejsdoc.org/
 */
/**
 * http://usejsdoc.org/
 */


(function(){
	
var app =angular.module('intentAppService', []);

app.service('intentService', function() {
	
      var scope;

      var setScope=function($scope){
		  
		  scope=$scope;
		  
	  };
   var expressionAnalyzation = function(data) {
		  
		  console.log("data.name *** "+data.name);
		  scope.name=data.name;

	  };
	  
	  return {
		  expressionAnalyzation: expressionAnalyzation,
		setScope:setScope 
	  };

	});
})();