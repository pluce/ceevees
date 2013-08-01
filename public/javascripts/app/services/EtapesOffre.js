APP.factory('EtapesOffre', function($resource) {
   var EtapesOffre = $resource('/offres/:offreId/etapes',
    {offreId:'@offreId'}, {
        'get':    {method:'GET'},
        'save':   {method:'POST'}
    });
    return EtapesOffre;
});