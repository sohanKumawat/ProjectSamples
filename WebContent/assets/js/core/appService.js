(function(){
	
var app =angular.module('appService', []);
	
app.factory('mathfactory',function(){
	
	var factory={};
	factory.multiply=function(a,b){
		return a*b;
	}
	factory.add=function(a,b){
		return a+b;
	}
return factory;

});

app.factory('messages',function(){
	var messages={};
	var list=[];
	messages.addMessage=function(message){
		list.push({id:list.length,text:message});
		return list;
	}
	return messages;
});

app.service('CalcService', function(mathfactory){
this.square=function(a){
	return mathfactory.multiply(a);
}	
this.add=function(a,b){
	return mathfactory.add(a,b);
 }
});

app.service('messageService', function(messages){
	
	this.addMessages=function(msg){
		return messages.addMessage(msg);
	  }
	});
	
app.service('productService', function() {
	  var productList = [];

	  var addProduct = function(newObj) {
	      productList.push(newObj);
	  };

	  var getProducts = function(){
	      return productList;
	  };

	  return {
	    addProduct: addProduct,
	    getProducts: getProducts
	  };

	});

app.service('httpService', function($http,$q) {
	 
	var postWithBody = function(url,params) {
		
		 var deferred = $q.defer();//promises in angular js
		  
		$http.post(url,params).success(function(data, status, headers, config) {
			deferred.resolve(data);
	    }).error(function(data, status, headers, config){
	    	deferred.reject(data);
	    });
		 
		  return deferred.promise;
	  };

		var postWithParam = function(url,params) {
			
			 var deferred = $q.defer();//promises in angular js
			 url=url+"?"+params
			$http.get(url).success(function(data, status, headers, config) {
				deferred.resolve(data);
		    }).error(function(data, status, headers, config){
		    	deferred.reject(data);
		    });
			 
			  return deferred.promise;
		  };

	  
	  var getRequest = function(url){
		  
		  var deferred = $q.defer();
		
		  $http.get(url).success(function(data, status, headers, config) {
			    deferred.resolve(data);
		    }).error(function(data, status, headers, config){
		    	deferred.reject(data);
		    });
		  return deferred.promise
	  
	  };

	  return {
	    httpGet: getRequest,
	    httpRequestWithBody: postWithBody,
	    httpRequestWithParam: postWithParam
	  };

	});


app.factory('Scopes', function ($rootScope) {
    var mem = {};

    return {
        addScope: function (key, value) {
            mem[key] = value;
        },
        getScope: function (key) {
            return mem[key];
        }
    };
});

})();
