angular.module('acomApp')
    .factory('MainService', function($resource, $http, config) {
        return {
            getFiles: function () {
                var res = $resource('api/v1/files', {}, {
                    'query': {
                        method: 'GET',
                        isArray: true,
                        timeout: config.api.timeout
                    }
                });
                return res.query().$promise;
            },
            getFile: function (id) {
                var res = $resource('api/v1/files/:id', {id:'@id'}, {
                    'query': {
                        method: 'GET',
                        isArray: true,
                        timeout: config.api.timeout
                    }
                });
                return res.query({id:id}).$promise;
            },
            saveFile: function(formData){
                $http.post('api/v1/files', formData, {
                    transformRequest: angular.identity,
                    headers: {'Content-Type': undefined}
                })
                    .success(function(data){
                        console.log(data);
                    })
                    .error(function(data){
                        console.log(data);
                        alert(data.originalException.message);
                    });
            }
        }
    });
