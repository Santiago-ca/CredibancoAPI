angular.module('credibancoApp')
    .controller('CreateTransactionController', function($scope, $http, $uibModal) {
        $scope.transaction = {};

        $scope.createTransaction = function() {
            $http.post('/api/transaction/create', $scope.transaction)
                .then(function(response) {
                    console.log(response);
                    if (response.data.responseCode === '00') {
                        $uibModal.open({
                            template: '<div class="modal-body">{{message}}</div>',
                            controller: function($scope) {
                                $scope.message = response.data.messageCode;
                            }
                        });
                    } else {
                        $uibModal.open({
                            template: '<div class="modal-body">{{message}}</div>',
                            controller: function($scope) {
                                $scope.message = response.data.messageCode + " Error " + response.data.responseCode;
                            }
                        });
                    }
                });
        };
    });