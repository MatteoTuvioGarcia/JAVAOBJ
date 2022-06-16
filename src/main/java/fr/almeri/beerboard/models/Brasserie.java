package fr.almeri.beerboard.models;

import java.util.Objects;

public class Brasserie
{
    private String codeBrasserie;
    private String nomBrasserie;
    private String ville;
    private Region region;
    public Brasserie(){}


    public String getCodeBrasserie() {
        return codeBrasserie;
    }

    public void setCodeBrasserie(String codeBrasserie) {
        this.codeBrasserie = codeBrasserie;
    }

    public String getNomBrasserie() {
        return nomBrasserie;
    }

    public void setNomBrasserie(String nomBrasserie) {
        this.nomBrasserie = nomBrasserie;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Brasserie{" +
                "codeBrasserie='" + codeBrasserie + '\'' +
                ", nomBrasserie='" + nomBrasserie + '\'' +
                ", ville='" + ville + '\'' +
                ", region=" + region +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brasserie brasserie = (Brasserie) o;
        return Objects.equals(codeBrasserie, brasserie.codeBrasserie) && Objects.equals(nomBrasserie, brasserie.nomBrasserie) && Objects.equals(ville, brasserie.ville) && Objects.equals(region, brasserie.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeBrasserie, nomBrasserie, ville, region);
    }
}
