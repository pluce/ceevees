APP.factory('OffresContact', function($resource) {
   var OffresContact = $resource('/offres/:offreId/contact',{offreId:'@offreId'}, {       
        'save':   {method:'POST'}
    });
    return OffresContact;
});