package com.example.Model;

import javax.persistence.*;


@Entity
@Table(name = "recepcioner", schema = "example", catalog = "")
public class Recepcioner {
    private int id;
    private Direktor direktorByIdDirektor;
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

        Recepcioner that = (Recepcioner) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "id_direktor", referencedColumnName = "ID", nullable = false)
    public Direktor  getDirektorByIdDirektor() {
        return direktorByIdDirektor;
    }

    public void setDirektorByIdDirektor(Direktor  direktorByIdDirektor) {
        this.direktorByIdDirektor = direktorByIdDirektor;
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
