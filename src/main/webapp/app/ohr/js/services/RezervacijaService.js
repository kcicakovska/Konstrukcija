
app.factory('RezervacijaService',['$http','$q',function($http,$q){
    return{
        CreateOrSave:function(tmp){
            return $http.post('http://localhost:9080/rezerviraj',tmp)
                .then(
                    function(d){
                        console.log(d);
                        return d.data;
                    },
                    function(errResponse){
                        console.log('Error while creating or updating reservation in RezervacijaService');
                    }
                )
        },
        FindReservation:function(from,to){
            console.log(from+" "+to);
            return $http.get('http://localhost:9080/rezervacii/'+from+"/"+to)
                .then(
                    function(d){
                        console.log(d);
                        return d.data;
                    },
                    function(errResponse){
                        console.log('Error while finding reservation in RezervacijaService');
                    }
                )
        },
        FetchAll:function(){
            return $http.get('http://localhost:9080/rezervacii')
                .then(
                    function(d){
                        console.log(d);
                        return d.data;
                    },
                    function(errResponse){
                        console.log('Error while fetching all reservation in RezervacijaService')
                    }
                )
        },
        saveReservation: function (rezervacija) {
            return $http.post('http://localhost:9080/rezerviraj',rezervacija)
                .then(
                    function(d){
                        return d.data;
                    },
                    function(errResponse){
                        console.log('Error while saving the reservation in rezeracijaController');
                    }
                )
        },
        reservationById:function(korisnik){
            console.log(korisnik +"   pecatam korisnik");
            return $http.post('http://localhost:9080/rezervacii/korisnik/',korisnik)
                .then(
                    function(d){
                        return d.data;
                    },
                    function(errResponse){
                        console.log('Error while geting all reservation by id');
                    }
                )
        }

    }
}]);