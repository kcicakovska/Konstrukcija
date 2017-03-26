'use strict';

app.controller('rezervacijaController',['$scope','$window','RezervacijaService','HotelServices', function($scope,$window,RezervacijaService,HotelServices) {
    var self = this;
    self.FilterAtReservation=[];
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
    self.pomoshHotel='';
    self.rezervacija={
        datumDo:'',
        datumOd:'',
        datumOdjava:'',
        ocenka:'',
        komentar:'',
        sobaByIdSoba:{},
        korisnikKupuvacByIdKorisnik:{},
    };
    self.hotels=[];

    self.FetchAll = function () {
        RezervacijaService.FetchAll()
            .then(
                function(d){
                    self.rezervacii = d;
                    self.Filter(1);
                },
                function(errResponse){
                    console.log('Error while fetching all Reservation in RezervacijaController');
                }

            )
    };

    self.findReservation = function(){
        console.log(self.rezervacija.datumOd+" "+self.rezervacija.datumDo);
        if(self.rezervacija.datumOd!="" && self.rezervacija.datumDo!="") {
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

    self.makeReservation = function(korisnik,pomosh,ime){
        //console.log(korisnik);
        console.log(pomosh);
        var boolea = false;
        self.rezervacija.korisnikKupuvacByIdKorisnik.id = korisnik.id;
        for(var i = 0; i < self.hotels.length; i++){
            if(self.hotels[i].ime==ime) {
                for (var k = 0; k < self.hotels[i].sobasById.length; k++) {
                    console.log(self.hotels[i].sobasById[k]);
                    if (pomosh.brSoba == self.hotels[i].sobasById[k].brSoba) {
                        console.log(self.hotels[i].sobasById[k]);
                        self.rezervacija.sobaByIdSoba = self.hotels[i].sobasById[k];
                        self.pomoshHotel = ime;
                        boolea = true;
                        break;
                    }
                }
            }
            if(boolea)
                break;
        }
        var oneDay = 24*60*60*1000;
        var firsDay = new Date(self.rezervacija.datumOd);
        var lastDay = new Date(self.rezervacija.datumDo);
        var diffDay = Math.round(Math.abs((firsDay.getTime()-lastDay.getTime())/oneDay));
        self.DenoviRezervirani = diffDay;
        console.log(diffDay);
        console.log(self.rezervacija);
       // self.saveReservation();
        var url = location.href;
        url = url.substr(0,url.length-11);
        location.href = url +"payment";
    };

    self.saveReservation = function(){
        console.log(self.rezervacija);
        RezervacijaService.saveReservation(self.rezervacija)
            .then(
                function(d){
                    self.rezervacija = d;
                },
                function(errResponse){
                    console.log('Error while saving reservation in reservationController');
                }
            )
    };
    self.fetchAllHotels = function(){
        HotelServices.FetchAll()
            .then(
                function(d){
                    console.log("Tuka sum");
                    self.hotels = d;
                },
                function(errResponse){
                    console.log('Error while fetching all hotel in RezervacijaControlller')
                }
            )
    };
    self.Filter=function(id){

        for (var i =0; i<self.rezervacii.length;i++){
            if(self.rezervacii[i].sobaByIdSoba.hotelByHotelId.id==id){
                self.FilterAtReservation.push(self.rezervacii[i]);
            }


        }
    };
    self.fetchAllHotels();
    self.FetchAll();

}]);