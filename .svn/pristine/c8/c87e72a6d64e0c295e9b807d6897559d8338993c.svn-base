package com.example.Model;

import javax.persistence.*;


@Entity
@Table(name = "odgovor_za_pomosh", schema = "example")
@IdClass(OdgovorZaPomoshPK.class)
public class OdgovorZaPomosh {
    private int id;
    private int idTehnicka;
    private String odgovor;
    private String problem;
    private Korisnik korisnikById;
    private Tehnickapodrshka tehnickapodrshkaByIdTehnicka;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "id_tehnicka")
    public int getIdTehnicka() {
        return idTehnicka;
    }

    public void setIdTehnicka(int idTehnicka) {
        this.idTehnicka = idTehnicka;
    }

    @Basic
    @Column(name = "odgovor")
    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    @Basic
    @Column(name = "problem")
    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OdgovorZaPomosh that = (OdgovorZaPomosh) o;

        if (id != that.id) return false;
        if (idTehnicka != that.idTehnicka) return false;
        if (odgovor != null ? !odgovor.equals(that.odgovor) : that.odgovor != null) return false;
        if (problem != null ? !problem.equals(that.problem) : that.problem != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idTehnicka;
        result = 31 * result + (odgovor != null ? odgovor.hashCode() : 0);
        result = 31 * result + (problem != null ? problem.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false,insertable=false, updatable=false)
    public Korisnik getKorisnikById() {
        return korisnikById;
    }

    public void setKorisnikById(Korisnik korisnikById) {
        this.korisnikById = korisnikById;
    }

    @ManyToOne
    @JoinColumn(name = "id_tehnicka", referencedColumnName = "ID", nullable = false,insertable=false, updatable=false)
    public Tehnickapodrshka getTehnickapodrshkaByIdTehnicka() {
        return tehnickapodrshkaByIdTehnicka;
    }

    public void setTehnickapodrshkaByIdTehnicka(Tehnickapodrshka tehnickapodrshkaByIdTehnicka) {
        this.tehnickapodrshkaByIdTehnicka = tehnickapodrshkaByIdTehnicka;
    }
}
