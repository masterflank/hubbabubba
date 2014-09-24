'use strict';

// Declare app level module which depends on views, and components
angular.module('playerApp', [
  'ngRoute',
  'playerApp.playerlist',
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/playerlist'});
}]);
