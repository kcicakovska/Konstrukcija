app.factory('HotelServices', ['$http', '$q', function($http, $q){
    return{
        FetchAll:function(){
          return $http.get('http://localhost:9080/hotels')
                .then(
                function(d){

                   return d.data;
                },
                function(errResponse){
                    console.log('Error while fetching all hotels in HotelService');
                }
    )},
    Register:function(tmp){
            tmp.action='registerAUser';
            tmp.role='admin';

          return $http.post('./src/dummyTestPhp/phpDummyTest.php',tmp)
                .then(
                function(d){

                   return d.data;
                        //console.log(JSON.stringify(self.event.tag_list)+" pri fetching");
                },
                function(errResponse){
                    console.log('Error while fetching all events in EventController');
                }
    )}
}
}]);