package com.example3.tp;

public class Roman extends Livre {
    private double prix;

    public Roman(String titre, String auteur, int nbrPages, double prix) {
        super(titre, auteur, nbrPages);
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Roman #" + getNumEnreg()
                + ", titre = " + getTitre()
                + ", auteur = " + getAuteur()
                + ", pages = " + getNbrPages()
                + ", prix = " + prix;
    }
}

