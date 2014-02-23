
var officeManagerModule = angular.module('officemanager', ['admin']);
var adminModule = angular.module('admin', ['ngResource']);

officeManagerModule.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/designations', {
                templateUrl: 'views/admin/designation/list.html',
                controller: 'DesignationListCtrl',
                resolve: {
                    designations: function(DesignationService){
                        return DesignationService.findAll();
                    }
                }
            }).
            otherwise({
                redirectTo: '/'
            });
    }]);

