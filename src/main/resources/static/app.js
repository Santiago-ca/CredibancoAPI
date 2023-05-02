var app = angular.module('credibancoApp', ['ngRoute','ui.bootstrap']);;

app.config(function($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl: 'views/home.html',
        controller: 'HomeController'
    })
    .when('/create-card', {
        templateUrl: 'views/create-card.html',
        controller: 'CreateCardController'
    })
    .when('/enroll-card', {
        templateUrl: 'views/enroll-card.html',
        controller: 'EnrollCardController'
    })
    .when('/consult-card', {
        templateUrl: 'views/consult-card.html',
        controller: 'ConsultCardController'
    })
    .when('/delete-card', {
        templateUrl: 'views/delete-card.html',
        controller: 'DeleteCardController'
    })
    .when('/create-transaction', {
        templateUrl: 'views/create-transaction.html',
        controller: 'CreateTransactionController'
    })
    .when('/cancel-transaction', {
        templateUrl: 'views/cancel-transaction.html',
        controller: 'CancelTransactionController'
    })
    .otherwise({
        redirectTo: '/'
    });
});

app.controller('HomeController', function() {
  
});