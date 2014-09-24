'use strict';

angular.module('playerApp.playerlist', [ 'ngRoute' ])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/playerlist', {
		templateUrl : 'playerlist/playerlist.html',
		controller : 'PlayerListCtrl'
	});
} ])

.controller('PlayerListCtrl',
		['playerService', function(playerService) {
			var self = this;
			self.newPlayer = "";
			self.addedPlayer = "";

			playerService.getAllPlayers().then(function(resp) {
				if (resp.data) {
					self.playerList = resp.data;
				}
			});

			self.add = function() {
				self.addedPlayer = self.newPlayer;
				self.newPlayer = "";
			}
		} ]);
