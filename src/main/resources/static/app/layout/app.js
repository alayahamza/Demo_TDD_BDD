var app = angular.module('App', [ 'App.Services', 'ui.router' ]);
app
	.config(function($stateProvider, $urlRouterProvider, $httpProvider) {

	    $urlRouterProvider.otherwise('/home');

	    $stateProvider.state('home', {
		url : '/home',
		templateUrl : '../layout/home.html'
	    });
	    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

	});
