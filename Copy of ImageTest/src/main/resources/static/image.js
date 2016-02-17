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
    $scope.image = "data:image/"
        + "jpg"
        + ";base64,"
        + "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";
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
  
  
