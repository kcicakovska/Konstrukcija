package com.example.Model;

import javax.persistence.*;


@Entity
@Table(name = "validator", schema = "example", catalog = "")
public class Validator {
    private int id;
    private Korisnik korisnikById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Validator that = (Validator) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToOne
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false,insertable=false, updatable=false)
    public Korisnik getKorisnikById() {
        return korisnikById;
    }

    public void setKorisnikById(Korisnik  korisnikById) {
        this.korisnikById = korisnikById;
    }
}
