'use strict';
angular.module('acomApp', ['ngResource', 'ui.router', 'ui.bootstrap', 'acomRoute', 'ui.tree', 'QuickList'])
    .constant('config',{
        api:{
            timeout: 10000,
            timeoutExceededFunction: function(responce){
              if(responce.config.params !== undefined){
                responce.config.url = responce.config.url + "?";
                for (var key in responce.config.params) {
                  if (responce.config.params.hasOwnProperty(key)) {
                    responce.config.url = responce.config.url + key + "=" + responce.config.params[key]+ "&";
                  }
                }
              }
            }
        }
    })
    .config(['$tooltipProvider','$httpProvider', function($tooltipProvider, $httpProvider){
      $tooltipProvider.setTriggers({'click': 'click'});
    }])
    .run(function ($rootScope, $state, $q, $controller,$timeout, $location, config) {
      $rootScope.isDataLoaded = true;


    }
);
