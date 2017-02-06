package com.example.Model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "rezervacija", schema = "example", catalog = "")
public class Rezervacija {
    private int id;
    private Date datumDo;
    private Date datumOd;
    private Date datumOdjava;
    private Integer ocenka;
    private String komentar;
    private Soba sobaByIdSoba;
    private KorisnikKupuvac  korisnikKupuvacByIdKorisnik;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "datum_do")
    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    @Basic
    @Column(name = "datum_od")
    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    @Basic
    @Column(name = "datum_odjava")
    public Date getDatumOdjava() {
        return datumOdjava;
    }

    public void setDatumOdjava(Date datumOdjava) {
        this.datumOdjava = datumOdjava;
    }

    @Basic
    @Column(name = "ocenka")
    public Integer getOcenka() {
        return ocenka;
    }

    public void setOcenka(Integer ocenka) {
        this.ocenka = ocenka;
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

        Rezervacija  that = (Rezervacija) o;

        if (id != that.id) return false;
        if (datumDo != null ? !datumDo.equals(that.datumDo) : that.datumDo != null) return false;
        if (datumOd != null ? !datumOd.equals(that.datumOd) : that.datumOd != null) return false;
        if (datumOdjava != null ? !datumOdjava.equals(that.datumOdjava) : that.datumOdjava != null) return false;
        if (ocenka != null ? !ocenka.equals(that.ocenka) : that.ocenka != null) return false;
        if (komentar != null ? !komentar.equals(that.komentar) : that.komentar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datumDo != null ? datumDo.hashCode() : 0);
        result = 31 * result + (datumOd != null ? datumOd.hashCode() : 0);
        result = 31 * result + (datumOdjava != null ? datumOdjava.hashCode() : 0);
        result = 31 * result + (ocenka != null ? ocenka.hashCode() : 0);
        result = 31 * result + (komentar != null ? komentar.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_soba", referencedColumnName = "ID", nullable = false)
    public Soba getSobaByIdSoba() {
        return sobaByIdSoba;
    }

    public void setSobaByIdSoba(Soba sobaByIdSoba) {
        this.sobaByIdSoba = sobaByIdSoba;
    }

    @ManyToOne
    @JoinColumn(name = "id_korisnik", referencedColumnName = "ID", nullable = false)
    public KorisnikKupuvac  getKorisnikKupuvacByIdKorisnik() {
        return korisnikKupuvacByIdKorisnik;
    }

    public void setKorisnikKupuvacByIdKorisnik(KorisnikKupuvac korisnikKupuvacByIdKorisnik) {
        this.korisnikKupuvacByIdKorisnik = korisnikKupuvacByIdKorisnik;
    }

    public Rezervacija(Soba sobaByIdSoba, KorisnikKupuvac korisnikKupuvacByIdKorisnik) {
        this.sobaByIdSoba = sobaByIdSoba;
        this.korisnikKupuvacByIdKorisnik = korisnikKupuvacByIdKorisnik;
    }

    public Rezervacija() {
    }
    @Override
    public String toString(){
        return this.getSobaByIdSoba()+" "+this.getKorisnikKupuvacByIdKorisnik();
    }
}
