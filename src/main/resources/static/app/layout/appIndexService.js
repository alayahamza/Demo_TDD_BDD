var appServices = angular.module('App.Services', []).factory('AppIndexService',
	function($q, $http) {
	    return {
		getUsers : function() {
			var deferred = $q.defer();
			var promise = $http.get(
					'/bank/users/getUsers')
					.success(function(data) {

						deferred.resolve(data);
					});

			return deferred.promise;
		}
	    }

	});