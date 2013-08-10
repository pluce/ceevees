function DetailsOffreCtrl($scope,$location,$routeParams,Offres,EtapesOffre,OffresContact,Toaster){
    $scope.idOffre = $routeParams.idOffre;
    $scope.offre = Offres.get({id: $scope.idOffre},function(){},function(){
        $location.path("/404");
    });
   $scope.changeState = function(newState){
       EtapesOffre.save(
        {"offreId":$scope.idOffre,"newState":newState},
        function() {
           $scope.offre.etat = newState;
        }
       )
   }
   
   $scope.justSaved = true;
   
   $scope.dirtyLetter = function(){
       $scope.justSaved = false;
   }
   
   $scope.saveLettre = function(){
       Offres.update($scope.offre,function(){
          $scope.justSaved = true;
          Toaster.success("Lettre sauvegardée.");
       },function(){
          Toaster.error("La lettre n'a pas été sauvegardée.");
       });
   }
   
   $scope.deleteAnnonce = function(){
       Offres.delete({"id":$scope.idOffre},function(){
           Toaster.success("Annonce supprimée.");
           $location.path("/");
       },function(){
           Toaster.error("L'annonce n'a pas été supprimée.");
       });
   }
   
   $scope.saveContact = function(){
       $scope.offre.contact.offreId = $scope.offre.id;
       OffresContact.save($scope.offre.contact,function(){
          Toaster.success("Contact sauvegardé.");
       },function(){
          Toaster.error("Le contact n'a pas pu être sauvegardé.");
       });
   }
   
   $scope.getAlertClasse = function(offre){
        if(offre.etat == "TROUVE") return "info";
        if(offre.etat == "REJETE") return "warning";
        if(offre.etat == "CONTACT_PRIS") return "info";
        if(offre.etat == "REPONSE_NEGATIVE") return "danger";
        if(offre.etat == "REPONSE_POSITIVE") return "success";
        if(offre.etat == "ENTRETIENS_EN_COURS") return "success";
        if(offre.etat == "RECRUTEMENT_EN_COURS") return "success";
        return "info";
    }
    
    
    $scope.getStateLabel = function(offre){
        if(offre.etat == "TROUVE") return "Repéré";
        if(offre.etat == "REJETE") return "Mis de côté";
        if(offre.etat == "CONTACT_PRIS") return "CV/Lettre envoyés";
        if(offre.etat == "REPONSE_NEGATIVE") return "Réponse négative";
        if(offre.etat == "REPONSE_POSITIVE") return "Réponse positive";
        if(offre.etat == "ENTRETIENS_EN_COURS") return "Entretien(s) programmé(s)";
        if(offre.etat == "RECRUTEMENT_EN_COURS") return "Processus de recrutement engagé";
        return offre.etat;
    }
};