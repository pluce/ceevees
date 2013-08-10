function CompteCtrl($scope,UtilisateurDetails,Toaster){
   $scope.details = UtilisateurDetails.get();
   
   $scope.save = function(){
       UtilisateurDetails.save($scope.details,function(){
           Toaster.success("Détails enregistrés.");
       },function(){
           Toaster.error("Les détails n'ont pas pu être enregistrés.");
       });
   }
};