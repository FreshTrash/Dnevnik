angular.module("acomRoute", [])
    .config(function($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/");
        $stateProvider
            .state('index',{
                url: '/',
                views: {
                    content: {
                        templateUrl: 'app/views/main.html',
                        controller: 'MainCtrl'
                    }
                }
            })
            .state('excel',{
                url: '/:id',
                views: {
                    content: {
                        templateUrl: 'app/views/excel.html',
                        controller: 'ExcelCtrl'
                    }
                }
            })

    });
