'use strict';
angular.module('playerApp.playerService', [])
.factory('playerService', [ '$http',
        function(httpSvc) {
			return new PlayerService(httpSvc);
		} ]);

function PlayerService(httpSvc) {
	this.getAllPlayers = function() {
		return httpSvc({
			method : 'GET',
			url : '/CI-GUI/api/player/'
		});
	};
	
	this.addPlayer = function(jpql) {
		return httpSvc({
			method : 'POST',
			url : 'hubba',
			data : jpql,
			headers : {
				"Content-Type" : "text/plain"
			}
		});
	};
}