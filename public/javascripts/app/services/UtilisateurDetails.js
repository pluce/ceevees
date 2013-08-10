APP.factory('UtilisateurDetails', function($resource) {
   var UtilisateurDetails = $resource('/utilisateur/details',{}, {
        'get':    {method:'GET'},
        'save':   {method:'POST'}
    });
    return UtilisateurDetails;
});