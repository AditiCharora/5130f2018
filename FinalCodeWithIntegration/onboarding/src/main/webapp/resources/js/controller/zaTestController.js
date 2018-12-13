$(document).ready(function() {
	angular.bootstrap(document.getElementById("testDiv"),['testApp']);
});

(function(angular, $, undefined) {

	var testApp = angular.module("testApp",['ngMaterial','ngRoute','ui.bootstrap','ngSanitize','ngMessages']);
	
	testApp.config(['$routeProvider' , '$locationProvider' , '$httpProvider',
     function($routeProvider,$locationProvider,$httpProvider) {
		$routeProvider.
 		when('/test', {
		  	title: 'Onboarding',
		  	templateUrl: '/resources/html/test.html',
		    reloadOnSearch:false
		}); 

     $locationProvider.html5Mode(true);
     
     if (!$httpProvider.defaults.headers.get) {
         $httpProvider.defaults.headers.get = {};    
     }    
     $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

	}]);

	testApp.run(['$rootScope','$location', '$routeParams','$http','$anchorScroll', function($rootScope, $location, $routeParams,$http,$anchorScroll){
		
		$rootScope.$on('$routeChangeSuccess', function(e, current, pre) {

			if($location.path() == '/test'){	
		 		$rootScope.$broadcast('list');
		 	}else{
		 		window.location.href= window.location.href;
		 	}
		});
	}]);

	testApp.controller("testController",['$scope', '$http', '$location', '$window', '$routeParams','$timeout','$rootScope','$anchorScroll','$interval','$sce','$q','$compile','$mdDialog',function($scope, $http, $location, $window, $routeParams,$timeout,$rootScope,$anchorScroll,$interval,$sce,$q,$compile,$mdDialog)
	{
		$scope.data = {
		        selectedIndex: 0,

		      };
		  $scope.myDate = new Date();
	      $scope.isOpen = false;

	      this.openMenu = function($mdOpenMenu, ev) {
	         originatorEv = ev;
	         $mdOpenMenu(ev);
	      };
	      $scope.next = function() {
	          $scope.data.selectedIndex = Math.min($scope.data.selectedIndex + 1, 2) ;
	        };
	      $scope.previous = function() {
	          $scope.data.selectedIndex = Math.max($scope.data.selectedIndex - 1, 0);
	        };
	      $scope.uploadFile=function(){
	            var file = $scope.myFile;

	            console.log('file is ' );
	            console.dir(file);

	            var uploadUrl = "/fileUpload";
	            fileUpload.uploadFileToUrl(file, uploadUrl);
	          };
	      $scope.showAdvanced = function(ev) {
	              $mdDialog.show({
	                controller: DialogController,
	                templateUrl: '/resources/html/dialog1.tmpl.html',
	                parent: angular.element(document.body),
	                targetEvent: ev,
	                clickOutsideToClose:true
	              })
	              .then(function(answer) {
	                $scope.status = 'You said the information was "' + answer + '".';
	              }, function() {
	                $scope.status = 'You cancelled the dialog.';
	              });
	            };
         function DialogController($scope, $mdDialog) {
	                $scope.hide = function() {
	                  $mdDialog.hide();
	                };

	     $scope.cancel = function() {
	                  $mdDialog.cancel();
	                };

	      $scope.streams = [
	                    { name: 'twitter',  img: '/resources/img/icons/twitter.png', newMessage: true },
	                    { name: 'linkedIn', img: '/resources/img/icons/linkedin.png', newMessage: false },
	                    { name: 'facebook', img: '/resources/img/icons/facebook.png', newMessage: false }
	                  ];

	      $scope.goToStream = function(stream, event) {
	          $mdDialog.show(
	            $mdDialog.alert()
	           .title('Navigating')
	           .textContent('Inspect ' + person)
	           .ariaLabel('Person inspect demo')
	           .ok('Neat!')
	           .targetEvent(event)
	       );
	     };
         }
	}]);

}(angular,$));