function HomeCtrl($scope,Offres,EtapesOffre){
    $scope.offres = Offres.query();
   //  ng-class="{'alert-info':o.etat == 'TROUVE','alert-danger':o.etat == 'REJETE'}"
   $scope.changeState = function(offre,newState){
       EtapesOffre.save(
        {"offreId":offre.id,"newState":newState},
        function() {
           offre.etat = newState;
        }
       )
   }
   
   $scope.deleteAnnonce = function(offre){
       Offres.delete({"id":offre.id},function(){
           $scope.offres = Offres.query();
       });
   }
   
   $scope.annonce = {};
   
   $scope.orderAnnonceByState = function(offre){
        if(offre.etat == "TROUVE") return 1;
        if(offre.etat == "REJETE") return 6;
        if(offre.etat == "CONTACT_PRIS") return 2;
        if(offre.etat == "REPONSE_NEGATIVE") return 7;
        if(offre.etat == "REPONSE_POSITIVE") return 4;
        if(offre.etat == "ENTRETIENS_EN_COURS") return 3;
        if(offre.etat == "RECRUTEMENT_EN_COURS") return 5;
        return 0;
   }
   
   $scope.filterForColumnLeft = function(o){
       if(o.etat == 'TROUVE' || o.etat == 'REJETE' || o.etat == 'REPONSE_NEGATIVE') return true;
   }
   $scope.filterForColumnMiddle = function(o){
       if(o.etat == 'CONTACT_PRIS' || o.etat == 'REPONSE_POSITIVE') return true;
   }
   $scope.filterForColumnRight = function(o){
       if(o.etat == 'ENTRETIENS_EN_COURS' || o.etat == 'RECRUTEMENT_EN_COURS') return true;
   }
   
   $scope.enregistrerAnnonce = function(){
       $scope.annonce.etat = "TROUVE";
       Offres.save($scope.annonce,function(data){
           $scope.offres.push(data);
           $scope.annonce = {};
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
    
    $scope.getColClasse = function(index,cols){
        if(index%cols==0) return "left";
        if(index%cols==cols-1) return "right";
        return "middle";
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