package com.example.Model;

import javax.persistence.*;


@Entity
@Table(name = "ocena_na_hotel", schema = "example", catalog = "")
@IdClass(OcenaNaHotelPK.class)
public class OcenaNaHotel {
    private int id;
    private int idHotel;
    private Integer ocena;
    private String komentar;
    private Hotel hotelByIdHotel;
    private KorisnikKupuvac korisnikKupuvacByIdKorisnik;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "id_hotel")
    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    @Basic
    @Column(name = "ocena")
    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    @Basic
    @Column(name = "komentar")
    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OcenaNaHotel  that = (OcenaNaHotel) o;

        if (id != that.id) return false;
        if (idHotel != that.idHotel) return false;
        if (ocena != null ? !ocena.equals(that.ocena) : that.ocena != null) return false;
        if (komentar != null ? !komentar.equals(that.komentar) : that.komentar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idHotel;
        result = 31 * result + (ocena != null ? ocena.hashCode() : 0);
        result = 31 * result + (komentar != null ? komentar.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "ID", nullable = false,insertable=false, updatable=false)
    public Hotel getHotelByIdHotel() {
        return hotelByIdHotel;
    }

    public void setHotelByIdHotel(Hotel hotelByIdHotel) {
        this.hotelByIdHotel = hotelByIdHotel;
    }

    @ManyToOne
    @JoinColumn(name = "id_korisnik", referencedColumnName = "ID", nullable = false,insertable=false, updatable=false)
    public KorisnikKupuvac getKorisnikKupuvacByIdKorisnik() {
        return korisnikKupuvacByIdKorisnik;
    }

    public void setKorisnikKupuvacByIdKorisnik(KorisnikKupuvac korisnikKupuvacByIdKorisnik) {
        this.korisnikKupuvacByIdKorisnik = korisnikKupuvacByIdKorisnik;
    }
}
