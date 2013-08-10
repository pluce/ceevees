function CompteCtrl($scope,UtilisateurDetails){
   $scope.details = UtilisateurDetails.get();
   
   $scope.save = function(){
       UtilisateurDetails.save($scope.details,function(){
           //ok
       },function(){
           //nok
       });
   }
};