'use strict';

angular.module('playerApp.playerlist', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/playerlist', {
    templateUrl: 'playerlist/playerlist.html',
    controller: 'PlayerListCtrl'
  });
}])

.controller('PlayerListCtrl', ['$scope', function($scope) {
	$scope.newPlayer = "";
	$scope.addedPlayer = "";
	
	$scope.playerList = [ 
	  {'name' : 'Ronaldo'}, 
	  {'name' : 'Messi'} 
	];
	
	$scope.add = function() {
		$scope.addedPlayer = $scope.newPlayer;
		$scope.newPlayer = "";
	}
}] );