'use strict';

describe('ciApp.playerlist module', function() {

  beforeEach(module('ciApp.playerlist'));

  describe('PlayerListCtrl', function(){

    it('should contain 2 player', inject(function($controller) {
    	var scope = {}, ctrl = $controller('PlayerListCtrl', {$scope:scope});
    	expect(scope.playerList.length).toBe(2);
    }));

  });
});