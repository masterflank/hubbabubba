'use strict';

describe('playerApp.playerlist module', function() {

	beforeEach(module('playerApp.playerlist'));
	beforeEach(module('playerApp.playerService'));
	

	describe('PlayerListCtrl', function() {
	    var ctrl, $httpBackend, service;

	    beforeEach(inject(function(_$httpBackend_, $controller, $injector) {
	      $httpBackend = _$httpBackend_;
	      $httpBackend.expectGET('/CI-GUI/api/player/').
	          respond([{name: 'Zlatan'}, {name: 'Messi'}]);

	      service = $injector.get('playerService', {});
	      ctrl = $controller('PlayerListCtrl', {playerService : service});
	      $httpBackend.flush();
	    }));

		it('should contain 2 players', inject(function($controller) {
			expect(ctrl.playerList.length).toBe(2);
		}));

	});
});