/**
 * @author <a href="mailto:koolrich@gmail.com">Richard Nduka</a>
 */

'use strict'

adminModule.factory('Designation', ['$resource',
    function($resource){
        return $resource('api/designations/:id', {id: '@designationId'});
    }
]);

adminModule.factory('DesignationService', ['Designation', '$q',
    function(Designation, $q){
        return{
            findAll: function(){
                var delay = $q.defer();
                Designation.query(function(designations){
                    delay.resolve(designations);
                }, function(){
                    delay.reject('Unable to fetch designations');
                });
                return delay.promise;
            },

            findById: function(designationId){
                var delay = $q.defer();
                Designation.get({id: designationId}, function(designation){
                    delay.resolve(designation);
                }, function(){
                    delay.reject('Unable to find designation' + designationId);
                });
                return delay.promise;
            }
        }
    }
]);
