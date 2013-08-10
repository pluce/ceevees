var APP = angular.module('ceevees', ['ngResource']);

APP.config(function($routeProvider,$locationProvider){
   $routeProvider.
       when('/',{controller: HomeCtrl, templateUrl: 'public/view/home.html'}).
       when('/compte',{controller: CompteCtrl, templateUrl: 'public/view/profil.html'}).
       when('/offre/:idOffre',{controller: DetailsOffreCtrl, templateUrl: 'public/view/detailsOffre.html'}).
       
       otherwise({redirectTo: '/'});
});