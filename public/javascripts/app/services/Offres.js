APP.factory('Offres', function($resource) {
   var Offres = $resource('/offres/:id',
    {id:'@id'}, {
        'get':    {method:'GET'},
        'save':   {method:'POST'},
        'query':  {method:'GET', isArray:true},
        'update': {method:'PUT'},
        'delete': {method:'DELETE'}
    });
    
   
    return Offres;
});

// TROUVE,REJETE,CONTACT_PRIS,REPONSE_NEGATIVE,REPONSE_POSITIVE,ENTRETIENS_EN_COURS,RECRUTEMENT_EN_COURS