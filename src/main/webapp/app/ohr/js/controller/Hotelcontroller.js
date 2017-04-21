/**
 * Created by Muttley on 8/7/2016.
 */
'use strict';

app.controller('HotelController',['$scope', 'HotelServices' , function($scope, HotelServices) {
    var self = this;
    self.hotels = [];
    self.pomosh={
        brSoba:'',
        tipSoba:''
    };
    self.hotel={
        ime:'',
        adresa:'',
        opis:'',
        brojNaSobi:'',
        //sliki:'',
        internet:'',
        parking:'',
        klima:'',
        parno:'',
        lift:'',
        bazen:'',
        spaIFitnes:'',
        sobnaUsloga:'',
        pojadokVoSoba:'',
        restorant:'',
        bar:'',
        terasa:'',
        milenicijaDozvoluva:'',
        direktorByIdDirektor:{},
        sobasById:{},
        zvezdi:'',
    };
  /**
   * Fetching all hotels
   */
  self.FetchAll = function () {
        HotelServices.FetchAll()
            .then(
                function (d) {
                    self.hotels = d;
                },
                function (errResponse) {
                    console.log('Error while fetching ticket in TicketController');
                }
            );
    };
    self.setHotel = function(hotel){
        self.hotel = hotel;
    };
    self.FetchAll();
}]);