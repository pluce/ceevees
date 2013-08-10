function DetailsOffreCtrl($scope,$location,$routeParams,Offres,EtapesOffre,OffresContact){
    $scope.idOffre = $routeParams.idOffre;
    $scope.offre = Offres.get({id: $scope.idOffre});
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
       },function(){
           //nok
       });
   }
   
   $scope.deleteAnnonce = function(){
       Offres.delete({"id":$scope.idOffre},function(){
           $location.path("/");
       });
   }
   
   $scope.saveContact = function(){
       $scope.offre.contact.offreId = $scope.offre.id;
       OffresContact.save($scope.offre.contact,function(){
           //ok
       },function(){
           //nok
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