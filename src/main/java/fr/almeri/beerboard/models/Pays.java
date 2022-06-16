package fr.almeri.beerboard.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name = "pays")
public class Pays {
    @Id
    @Column(name = "nom_pays")
    private String nomPays;
    @Column(name = "consommation")
    private double consommation;
    @Column(name = "production")
    private double production;

    public Pays() {}



    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public double getConsommation() {
        return consommation;
    }

    public void setConsommation(double consommation) {
        this.consommation = consommation;
    }

    public double getProduction() {
        return production;
    }

    public void setProduction(double production) {
        this.production = production;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pays pays = (Pays) o;
        return Double.compare(pays.consommation, consommation) == 0 && Double.compare(pays.production, production) == 0 && Objects.equals(nomPays, pays.nomPays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomPays, consommation, production);
    }
}
