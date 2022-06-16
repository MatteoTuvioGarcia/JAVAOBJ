package fr.almeri.beerboard.models;

import java.util.Objects;

public class Marque {
    private String nomMarque;
    private Brasserie brasserie;

    public Marque(){}


    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public Brasserie getBrasserie() {
        return brasserie;
    }

    public void setBrasserie(Brasserie brasserie) {
        this.brasserie = brasserie;
    }

    @Override
    public String toString() {
        return "Marque{" +
                "nomMarque='" + nomMarque + '\'' +
                ", brasserie=" + brasserie +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marque marque = (Marque) o;
        return Objects.equals(nomMarque, marque.nomMarque) && Objects.equals(brasserie, marque.brasserie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomMarque, brasserie);
    }
}
