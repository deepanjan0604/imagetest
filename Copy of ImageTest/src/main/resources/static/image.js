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
               controller: 'myctrl'
           })   
           .when('/imagedisplay', {
               templateUrl: 'imagedisplay.html',
               controller: 'displayctrl'
           })   

         }]);
		 
	 


/*app.controller('imagectrl',[ '$scope', '$rootScope','$http',
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
*/




app.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

app.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function(file, uploadUrl){
        var fd = new FormData();
        fd.append('file', file);
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(){
        })
        .error(function(){
        });
    }
}]);

app.controller('myCtrl', ['$scope', 'fileUpload','$http', function($scope, fileUpload, $http){
    
    $scope.uploadFile = function(){
        var file = $scope.myFile;
        console.log('file is ' );
        console.dir(file);
        var uploadUrl = "/upload";
        fileUpload.uploadFileToUrl(file, uploadUrl);
        
       
       
    };
    
}]);



app.controller('displayctrl',[ '$scope', '$rootScope','$http',
	     function($scope,$rootScope, $http)
	     {
	debugger;
	
		   	$scope.itemimages={};
		    $scope.image = "data:image/"
                + $scope.itemimages.extn
                + ";base64,"
                + $scope.itemimages.url;
		   		$http({
		   			method : 'GET',
		   			url : '/display',
		   		}).then(function(response) {
		   			$rootScope.itemimages = response.data;
		});	   
	     }]);
  
  
