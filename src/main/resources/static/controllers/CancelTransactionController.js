angular.module('credibancoApp')
    .controller('CancelTransactionController', function($scope, $http, $uibModal) {
        $scope.transaction = {};

        $scope.cancelTransaction = function() {
            $http.post('/api/transaction/cancel', $scope.transaction)
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