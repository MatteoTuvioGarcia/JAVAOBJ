package fr.almeri.beerboard.models;

import java.util.Objects;

public class Pays {

    private String nomPays;
    private double consommation;
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
