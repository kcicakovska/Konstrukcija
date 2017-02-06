package com.example.Model;

import javax.persistence.*;

@Entity
@Table(name = "admin", schema = "example")
public class Admin {
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

        Admin that = (Admin) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToOne
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false)
    public Korisnik getKorisnikById() {
        return korisnikById;
    }

    public void setKorisnikById(Korisnik korisnikById) {
        this.korisnikById = korisnikById;
    }
}
