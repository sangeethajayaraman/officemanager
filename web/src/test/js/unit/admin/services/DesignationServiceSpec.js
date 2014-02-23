/**
 * @author <a href="mailto:koolrich@gmail.com">Richard Nduka</a>
 */

'use strict'

describe('DesignationService', function(){
    var mockBackend, designation, designationService;

    beforeEach(module("admin"));

    beforeEach(function(){
        this.addMatchers({
            toEqualData: function(expected){
                return angular.equals(this.actual, expected);
            }
        });

        inject(function($injector){
            designation = $injector.get('Designation');
            mockBackend = $injector.get('$httpBackend');
            designationService = $injector.get('DesignationService');
        });
    });

    describe('findAll', function(){
        it('should find all designations', function(){
            mockBackend.expectGET('api/designations').respond([{designationId:1, name: "Java Developer"},
                {designationId:2, name:"Sales Executive"}]);

            var designations;
            var promise = designationService.findAll();

            promise.then(function(promisedDesignations){
                designations = promisedDesignations;
            });

            expect(designations).toBeUndefined();
            mockBackend.flush();
            expect(designations).toEqualData([{designationId:1, name: "Java Developer"},
                {designationId:2, name:"Sales Executive"}]);
        });
    });

    describe('findById', function(){
        it('should find a designation by id', function(){
            mockBackend.expectGET('api/designations/1').respond({designationId:1, name: "Tester"});

            var designation;
            var promise = designationService.findById(1);

            promise.then(function(promisedDesignation){
                designation = promisedDesignation;
            });

            expect(designation).toBeUndefined();
            mockBackend.flush();
            expect(designation).toEqualData({designationId:1, name: "Tester"});
        });
    });

});
