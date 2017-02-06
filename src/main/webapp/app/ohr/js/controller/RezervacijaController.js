'use strict';

app.controller('rezervacijaController',['$scope','$window','RezervacijaService','HotelServices', function($scope,$window,RezervacijaService,HotelServices) {
    var self = this;
    self.rezervacii = [];
    self.rezervacija={
        datumDo:'',
        datumOd:'',
        datumOdjava:'',
        ocenka:'',
        komentar:'',
        sobaByIdSoba:{},
        korisnikKupuvacByIdKorisnik:{},
        primer:'Ajde'
    };
    self.hotels=[];
    self.FetchAll = function () {
        RezervacijaService.FetchAll()
            .then(
                function(d){
                    self.rezervacii = d;
                },
                function(errResponse){
                    console.log('Error while fetching all Reservation in RezervacijaController');
                }

            )
    };
    self.fetchHotels = function(){
      HotelServices.FetchAll()
          .then(
              function(d){
                  self.hotels = d;
              }
          )
    };
    self.findReservation = function(){
        console.log(self.hotels[0].sobasById.length);
        var map=[];
        var flag = true;
        for(var i = 0; i < self.rezervacii.length; i++){
            console.log("AAAAAAAAA");
            for(var j = 0; j < self.hotels.length; j++){
                console.log("da");
                for(var t= 0; t < self.hotels[j].sobasById.length; t++){
                    console.log(self.hotels[j].sobasById[t].id+" "+self.rezervacii[i].sobaByIdSoba[0].id);
                    if(self.hotels[j].sobasById[0].id != self.rezervacii[i].sobaByIdSoba.id){
                        console.log(self.hotels[j].ime);
                        map.push(self.hotels[j].ime);
                        flag = false;
                        break;
                    }
                    console.log("Yes");
                }
                if(!flag){
                    flag = true;
                    break;
                }
            }
        }
    };

    self.FetchAll();
    self.fetchHotels();

}]);