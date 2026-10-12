package com.example3.tp;

public class Bibliotheque {
    private int capacite;
    private Document[] documents;
    private int nbDocuments;

    public Bibliotheque(int capacite) {
        this.capacite = capacite;
        this.documents = new Document[capacite];
        this.nbDocuments = 0;
    }

    public void afficherDocuments() {
        if (nbDocuments == 0) {
            System.out.println("La bibliothèque est vide.");
            return;
        }

        for (int i = 0; i < nbDocuments; i++) {
            System.out.println(documents[i]);
        }
    }

    public boolean ajouter(Document doc) {
        if (doc == null || nbDocuments == capacite) {
            return false;
        }

        documents[nbDocuments] = doc;
        nbDocuments++;
        return true;
    }

    public boolean supprimer(Document doc) {
        if (doc == null) {
            return false;
        }

        for (int i = 0; i < nbDocuments; i++) {
            if (documents[i] == doc) {
                for (int j = i; j < nbDocuments - 1; j++) {
                    documents[j] = documents[j + 1];
                }

                documents[nbDocuments - 1] = null;
                nbDocuments--;
                return true;
            }
        }

        return false;
    }

    public Document document(int numEnrg) {
        for (int i = 0; i < nbDocuments; i++) {
            if (documents[i].getNumEnreg() == numEnrg) {
                return documents[i];
            }
        }

        return null;
    }

    public void afficherAuteurs() {
        boolean trouve = false;

        for (int i = 0; i < nbDocuments; i++) {
            if (documents[i] instanceof Livre) {
                Livre livre = (Livre) documents[i];

                if (livre.getAuteur() != null
                        && !livre.getAuteur().trim().isEmpty()) {
                    System.out.println(livre.getAuteur());
                    trouve = true;
                }
            }
        }

        if (!trouve) {
            System.out.println("Aucun auteur trouvé.");
        }
    }
}
