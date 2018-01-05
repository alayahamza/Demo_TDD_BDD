app.controller('AppIndexCntrl', [
	'$scope',
	'$http',
	'$state',
	'$timeout',
	'$window',
	'$rootScope',
	'AppIndexService',
	function($scope, $http, $state, $timeout, $window, $rootScope,
		AppIndexService) {

	    $scope.users;
	    $scope.getUsers = function() {
		AppIndexService.getUsers().then(function(data) {
		    $scope.users = data;
		})
	    }
	    
	    /*******************************************/
	    $scope.getUsers();
	} ]);