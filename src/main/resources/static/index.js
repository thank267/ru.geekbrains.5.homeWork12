angular.module('app', ['ngStorage']).controller('indexController', function ($scope, $rootScope, $http, $localStorage) {
    const contextPath = 'http://localhost:8189/app';

    if ($localStorage.springWebUser) {
        $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.springWebUser.token;
    }


    $scope.loadProducts = function () {

        $http({
            url: contextPath + '/products/v1',
            method: 'GET',
            params: {
                page: $scope.flt ? $scope.flt.page: 1,
                min: $scope.flt ? $scope.flt.min: 0,
                max: $scope.flt ? $scope.flt.max: null
            }
        })
        .then(function (response) {
            console.log(response.data.pageable)
            $scope.products = response.data.content;

        });
    };

    $scope.deleteProduct = function (id) {
        $http.get(contextPath + '/products/delete/' + id)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.tryToAuth = function () {
        $http.post(contextPath + '/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.springWebUser = {username: $scope.user.username, token: response.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;
                }
            }, function errorCallback(response) {
            });
    };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        if ($scope.user.username) {
            $scope.user.username = null;
        }
        if ($scope.user.password) {
            $scope.user.password = null;
        }
    };

    $scope.clearUser = function () {
        delete $localStorage.springWebUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $rootScope.isUserLoggedIn = function () {
        if ($localStorage.springWebUser) {
            return true;
        } else {
            return false;
        }
    };

    $scope.addUser = function () {
        console.log($scope.addUser.roles);
        $http({
            url: contextPath + '/users/v1',
            method: 'POST',
            data: JSON.stringify({ username: $scope.addUser.username,  email: $scope.addUser.email, password: $scope.addUser.password,roles: $scope.addUser.roles.model.map(function(id) {
                    return {id:id};
                })}),

        }).then(function (response) {
                console.log(response.data)

        }).catch(function (response) {

                alert(response.data.status+" "+response.data.error)

        });
    };

    $scope.loadRoles = function () {

        $http({
            url: contextPath + '/roles/v1',
            method: 'GET',

        })
            .then(function (response) {
                console.log(response.data)
                $scope.addUser.roles = {
                    model: null,
                    roleOptions: response.data
                };

            });
    };

    $scope.loadProducts();
    $scope.loadRoles();

});
