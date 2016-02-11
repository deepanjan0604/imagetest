var app = angular.module('app', ['ngRoute']);

app.config([
		'$httpProvider',
		function($httpProvider) {
			$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
		} ]);



app.config(['$routeProvider',
         function($routeProvider) {
           $routeProvider
           .when('/image', {
               templateUrl: 'image.html',
               controller: 'imagectrl'
           })   

         }]);
		 
	 


app.controller('imagectrl',[ '$scope', '$rootScope','$http',
                          	     function($scope,$rootScope, $http)
                          	     {
	$scope.itemimages={};
	$scope.saveImage=function(){
	$http({
		method : 'POST',
		url : '/upload',
		data:$scope.itemimages
	}).then(function(response) {
		$rootScope.itemimages =angular.copy(response.data);
		 
	});
	};
                          			  }]);


  
  
