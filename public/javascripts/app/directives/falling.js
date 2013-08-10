APP.directive('falling', function() {
    return {
        restrict: 'A',
        link: function(scope, elm, attrs) {
            scope.e = elm;
            
            jQuery(elm).css({ opacity: 0, marginBottom: "800px" }).animate({ opacity: 1, marginBottom:"20px" }, parseInt(attrs.falling));
            setTimeout(function(){
              jQuery(scope.e).animate({marginBottom:"-300px", opacity: 0},attrs.falling);  
            },attrs.falling * 6)
        }
    };
});