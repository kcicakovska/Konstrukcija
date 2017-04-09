app.factory('TehnickaPodrshkaService', ['$http', '$q', function($http, $q){
  return{
    FetchAll:function(){

      return $http.get('http://localhost:9080/tehpod/lista')
          .then(
              function(d){

                return d.data;
              },
              function(errResponse){
                console.log('Error while fetching all tehnickaPodrshka tickets in TehnickaPodrshkaService');
              }
          )
    },
    CreateNew:function(tehnickaPod){
      return $http.post('http://localhost:9080/tehpod/nov',tehnickaPod)
          .then(
              function(d){
                return d.data;
              },
              function (errResponse) {
                console.log('Error while creating tehnickaPodrsha ticket in TehnickaPodrshkaService')
              }
          )
    }
  }
}]);