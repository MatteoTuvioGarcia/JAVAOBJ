package fr.almeri.beerboard.models;

import java.util.Objects;

public class Region {
    private String nomRegion;
    private Pays pays;
    public Region(){}


    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Region{" +
                "nomRegion='" + nomRegion +
        '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(nomRegion, region.nomRegion) && Objects.equals(pays, region.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomRegion, pays);
    }
}
