app.factory('UserService', ['$http', '$q', function($http, $q){
    return{
        LogginUser:function(tmp){
            console.log(tmp.korisnickoIme+" "+tmp.lozinka);
          return $http.post('http://localhost:9080/login',tmp)
                .then(
                function(d){
                   return d.data[0];
                },
                function(errResponse){
                    console.log('Error while logging in LogginUser UserService');
                }
    )},
        RegisterUser:function(tmp){
            return $http.post('http://localhost:9080/register',tmp)
                .then(
                    function(d){
                        return d.data;
                    },
                    function(errResponse){
                        console.log('Error while registering in LogginUser UserService');
                    }
                )

        },
        FetchAll:function(){
            return $http.post('http://localhost:9080/users')
                .then(
                    function(d){
                        return d.data;
                    },
                    function(errResponse){
                        console.log('Error while fetching all users in UserService');
                    }
                )
        },
        FetchByName:function(name){
            return $http.get('http://localhost:9080/user/'+name)
                .then(
                    function(d){
                        return d.data;
                    },
                    function (errResponse) {
                        console.log('Error while populating userByName in UserService')
                    }
                )
        }
			}
}]);