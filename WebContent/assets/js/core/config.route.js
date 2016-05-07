(function () {
angular.module("msgaiTrainingApp").config(['$routeProvider',
         function($routeProvider) {
            $routeProvider.
               when('/dashboard', {
                  templateUrl: '/assets/pages/dashboard.html',
                  controller: 'dashboardController',
                //  foodata: 'studentNameProperty',
/*resolve: {
      // I will cause a 1 second delay
      delay: function($q, $timeout) {
        var delay = $q.defer();
        $timeout(delay.resolve, 1000);
        return delay.promise;
      }
    }*/
               }).
               when('/intent', {
                  templateUrl: '/assets/pages/intent.html',
                  controller: 'intentAnalyzerCtrl',
                  //requiresLogin: true
                  
               }).
               when('/entity', {
                   templateUrl: '/assets/pages/entity.html',
                   controller: 'entityAnalyzerCtrl',
                   //requiresLogin: true
                   
                }).
                when('/message', {
                    templateUrl: '/assets/pages/messages.html',
                    controller: 'messagesCtrl',
                 }).
               otherwise({
                  redirectTo: '/dashboard'
               });
         }]);

})();

/*
UI Router ===>

myApp.config(function($stateProvider, $urlRouterProvider, $httpProvider, authProvider) {
	  $urlRouterProvider.otherwise('/login');

	  $stateProvider
	  .state('logout', { url: '/logout', templateUrl: 'views/logout.html', controller: 'LogoutCtrl' })
	  .state('login', { url: '/login', templateUrl: 'views/login.html', controller: 'LoginCtrl' })
	  .state('root', { url: '/', templateUrl: 'views/root.html', controller: 'RootCtrl', data: { requiresLogin: true } });

	});*/
       
