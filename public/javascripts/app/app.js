var APP = angular.module('ceevees', ['ngResource']);

APP.config(function($routeProvider,$locationProvider){
   $routeProvider.
       when('/',{controller: HomeCtrl, templateUrl: 'public/view/home.html'}).
       otherwise({redirectTo: '/'});
});