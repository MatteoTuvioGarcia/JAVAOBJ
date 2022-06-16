package fr.almeri.beerboard.models;

import java.util.Objects;

public class Type {
    private int noType;
    private String nomType;
    private String description;
    private String fermentation;
    private String commentaire;

    public Type(){}



    public int getNoType() {
        return noType;
    }

    public String getNoTypeStr(){
        return String.valueOf(noType);
    }

    public void setNoType(int noType) {
        this.noType = noType;
    }
    public void setNoTypeStr(String noType){
        this.noType = Integer.valueOf(noType);
    }
    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFermentation() {
        return fermentation;
    }

    public void setFermentation(String fermentation) {
        this.fermentation = fermentation;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Type{" +
                "noType=" + noType +
                ", nomType='" + nomType + '\'' +
                ", description='" + description + '\'' +
                ", fermentation='" + fermentation + '\'' +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return noType == type.noType && Objects.equals(nomType, type.nomType) && Objects.equals(description, type.description) && Objects.equals(fermentation, type.fermentation) && Objects.equals(commentaire, type.commentaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noType, nomType, description, fermentation, commentaire);
    }
}
