'use strict';

app.controller('rezervacijaController',['$scope','$window','RezervacijaService','HotelServices', function($scope,$window,RezervacijaService,HotelServices) {
    var self = this;
    self.hotelsFree = [];
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
    self.rezervaciiFiltered = [];
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
    self.findReservation = function(){
        console.log(self.rezervacija.datumOd+" "+self.rezervacija.datumDo);
        if(self.rezervacija.datumOd!="" || self.rezervacija.datumDo!="") {
            RezervacijaService.FindReservation(self.rezervacija.datumOd, self.rezervacija.datumDo)
                .then(
                    function (d) {
                        self.hotelsFree = d;
                        console.log(d);
                    },
                    function (errResponse) {
                        console.log('Error while fetching filtered reservaction in RezervacijaController');
                    }
                )
        }else{
            HotelServices.FetchAll()
                .then(
                    function(d){
                        console.log("Tuka sum");
                        self.hotelsFree = d;
                    },
                    function(errResponse){
                        console.log('Error while fetching all hotel in RezervacijaControlller')
                    }
                )
        }
    };

    self.FetchAll();

}]);