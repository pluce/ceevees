APP.factory('Toaster',function($rootScope){
    var service = {};
    service.messages = [];
    service.to = undefined;
    service.nextId = 0;
    service.toast = function(msg,type){
        service.messages.push({id: service.nextId++, message: msg, type: type});
        setTimeout(service.untoast,8000);
    }
    service.untoast = function(){
        //alert("plof");
        $rootScope.$apply(function(){
            service.messages.shift();
        });
    }
    service.info = function(msg){
        service.toast(msg,"info");
    }
    service.success = function(msg){
        service.toast(msg,"success");
    }
    service.error = function(msg){
        service.toast(msg,"error");
    }
    return service;
});