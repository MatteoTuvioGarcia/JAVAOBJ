package fr.almeri.beerboard.models;

import java.util.Objects;

public class Biere {
    private Marque marque;
    private String version;
    private Type type;
    private String couleurBIere;
    private Double tauxAlcool;
    private String caracteristiques;
    private String noTypeStr;



    public Biere(){}


    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCouleurBIere() {
        return couleurBIere;
    }

    public void setCouleurBIere(String couleurBIere) {
        this.couleurBIere = couleurBIere;
    }

    public Double getTauxAlcool() {
        return tauxAlcool;
    }

    public void setTauxAlcool(Double tauxAlcool) {
        this.tauxAlcool = tauxAlcool;
    }

    public String getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(String caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public String getNoTypeStr() {
        return noTypeStr;
    }

    public void setNoTypeStr(String noTypeStr) {
        this.noTypeStr = noTypeStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Biere biere = (Biere) o;
        return Objects.equals(marque, biere.marque) && Objects.equals(version, biere.version) && Objects.equals(type, biere.type) && Objects.equals(couleurBIere, biere.couleurBIere) && Objects.equals(tauxAlcool, biere.tauxAlcool) && Objects.equals(caracteristiques, biere.caracteristiques) && Objects.equals(noTypeStr, biere.noTypeStr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marque, version, type, couleurBIere, tauxAlcool, caracteristiques, noTypeStr);
    }
}
