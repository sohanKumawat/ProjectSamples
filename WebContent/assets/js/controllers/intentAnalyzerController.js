/**
 * http://usejsdoc.org/
 */
'user strict'


var mainApp = angular.module('intentAnalyzerApp', ['appService','nsPopover','intentAppService']);

mainApp.directive("contenteditable", ['$sce', function($sce) {
	  return {
	    restrict: "A",
	    require: "ngModel",
	    link: function(scope, element, attrs, ngModel) {

	      function read() {
	        ngModel.$setViewValue(element.html());
	      }

	      ngModel.$render = function() {
	        element.html(ngModel.$viewValue || "");
	      };
	      element.find('input').focus().select();
	      console.log("focus ** "+element.find('input').focus().select());

	      element.bind("blur keyup change", function() {
	        scope.$apply(read);
	      });
	    }
	  };
	}]);

mainApp.controller('intentAnalyzerCtrl', ['$scope', '$http','httpService','intentService','$sce',function ($scope, $http,httpService,intentService,$sce) {

	intentService.setScope($scope)

/**  module variable declaration */	
	// master variable for show & hide fields
	$scope.show_hide={};
	$scope.show_hide.intentPopup=false;
	// master intent objects
	$scope.rootIntent={};
	$scope.rootIntent.intent={};
	$scope.rootIntent.intent.globalAttributes=[];
	$scope.rootIntent.intentAttributes=[];
	$scope.rootIntent.intentExpressonList=[];
	$scope.rootIntent.gloableIntentAttribute={};
	$scope.rootIntent.intentAttribute={};
	$scope.rootIntent.prompt={};
		   $scope.snippet =
           '<p style="color:blue">an html\n' +
           '<em onmouseover="this.textContent=\'PWN3D!\'">click here</em>\n' +
           'snippet</p>';
	 

//		     'I am an <code>HTML</code>string with ' +
//		     '<a href="#">links!</a> and other <em>stuff</em>';
//		
	   $scope.text= '<input type="text"  placeholder="Enter an expression…" class="form-control"  ng-model="rootIntent.intent.expressionText" ng-keypress="($event.which === 13)?expressionAnalyzer($event):0" >';
	   
	   $scope.rootIntent.intent.expressionText= 'i want to book hotel in'+ 
	   ' <span  selection-value="@sys.geo-city" selection-alias="geo-city" style="background-color: rgb(255, 209, 175);">'+
	   ' delhi'+
	   ' </span>'+
	   ' on this'+
	   ' <span selection-value="@sys.address" selection-alias="address" style="background-color: rgb(210, 195, 234);">'+
	   ' monday'+
	   ' </span>'
	   
         $scope.deliberatelyTrustDangerousSnippet = function(text) {
         
        	 return $sce.trustAsHtml(text);
       
         };
        
         $scope.getSelectedWord=function() {
        	    var selectedWord;
        	    if (window.getSelection && window.getSelection().getRangeAt) {
        	    	selectedWord = window.getSelection().getRangeAt(0);
        	        $scope.show_hide.intentPopup=true;
        	    } 
        	}
          
          
	$scope.saveIntent=function(){
		
	}

	$scope.removeIntentExpression=function(index){
		$scope.rootIntent.intentExpressonList.splice(index,1);
	}
    $scope.expressionAnalyzer=function(event){
    	
    	if($scope.rootIntent.intent.expressionText===null || $scope.rootIntent.intent.expressionText===""){
    		return;
    	}
    	inputParam="expression="+$scope.rootIntent.intent.expressionText;
    	
    	$scope.rootIntent.intentExpressonList.push($scope.rootIntent.intent.expressionText);
    	$scope.rootIntent.intent.expressionText=null;
    	
    	httpService.httpRequestWithBody('/fetchIntentAttribute',inputParam).then(function(response){
    		
    	$scope.rootIntent.intentAttribute.attributeList=response;
    		
    	},function(err){
    	
    		console.log('request not completed successfully ** error is '+err);
    	
    	});

    	/*
    	 * var inputParam={
    			id:'21e3214',
    			name:'sohan kumawat'
    	};
    	httpService.httpPostWithBody('/intentExpressionAnalyzer?',inputParam).then(function(response){
    	*/
    
    }

    $scope.intentAttributeAssociation=function(attribute){
    	var intent=$scope.rootIntent.intent;
    	intent.name="@hotel_booking";
    	intent.
    	attribute.intentName=$scope.rootIntent.intent.intentName;
    	  $scope.rootIntent.intentAttributes.push(attribute);
    	 $scope.show_hide.intentPopup=false;
    	httpService.httpRequestWithBody('/intentAttributeAssociation',$scope.rootIntent.intentAttribute).then(function(response){
    		
    		console.log(response);
        		
        	},function(err){
        	
        		console.log('request not completed successfully ** error is '+err);
        	
        	});
    }
    
	
	
	
	
	
	 $scope.items = [{
	        name: "Action"
	      }, {
	        name: "Another action"
	      }, {
	        name: "Something else here"
	      }];

	      $scope.shouldDisplayPopover = function() {
	        return $scope.displayPopover;
	    };
    
}])