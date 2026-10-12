package com.example3.tp;

import java.util.Scanner;


public class TestBibliotheque {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        do {
            System.out.print("Capacité de la bibliothèque (minimum 2) : ");
            n = sc.nextInt();
        } while (n < 2);

        sc.nextLine();

        Bibliotheque b = new Bibliotheque(n);

        // Initialisation avec deux documents
        b.ajouter(new Roman(
                "Les Misérables", "Victor Hugo", 500, 150.0));

        b.ajouter(new Revue(
                "Science et Vie", "Octobre", 2026));

        int choix;

        do {
            System.out.println("\n===== MENU BIBLIOTHÈQUE =====");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Afficher les documents");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Rechercher un document");
            System.out.println("5. Afficher les auteurs");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {

                case 1:
                    System.out.println("Type de document :");
                    System.out.println("1. Roman");
                    System.out.println("2. Manuel");
                    System.out.println("3. Revue");
                    System.out.println("4. Dictionnaire");
                    System.out.print("Votre choix : ");

                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Titre : ");
                    String titre = sc.nextLine();

                    Document doc = null;

                    switch (type) {
                        case 1:
                            System.out.print("Auteur : ");
                            String auteurR = sc.nextLine();

                            System.out.print("Nombre de pages : ");
                            int pagesR = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Prix : ");
                            double prix = sc.nextDouble();
                            sc.nextLine();

                            doc = new Roman(
                                    titre, auteurR, pagesR, prix);
                            break;

                        case 2:
                            System.out.print("Auteur : ");
                            String auteurM = sc.nextLine();

                            System.out.print("Nombre de pages : ");
                            int pagesM = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Niveau : ");
                            String niveau = sc.nextLine();

                            doc = new Manuel(
                                    titre, auteurM, pagesM, niveau);
                            break;

                        case 3:
                            System.out.print("Mois : ");
                            String mois = sc.nextLine();

                            System.out.print("Année : ");
                            int annee = sc.nextInt();
                            sc.nextLine();

                            doc = new Revue(titre, mois, annee);
                            break;

                        case 4:
                            System.out.print("Langue : ");
                            String langue = sc.nextLine();

                            doc = new Dictionnaire(titre, langue);
                            break;

                        default:
                            System.out.println("Type invalide.");
                    }

                    if (doc != null) {
                        if (b.ajouter(doc)) {
                            System.out.println(
                                    "Document ajouté. Numéro : "
                                    + doc.getNumEnreg());
                        } else {
                            System.out.println(
                                    "Échec : bibliothèque pleine.");
                        }
                    }
                    break;

                case 2:
                    b.afficherDocuments();
                    break;

                case 3:
                    System.out.print("Numéro du document à supprimer : ");
                    int numSupp = sc.nextInt();
                    sc.nextLine();

                    Document docSupp = b.document(numSupp);

                    if (docSupp != null && b.supprimer(docSupp)) {
                        System.out.println("Document supprimé.");
                    } else {
                        System.out.println("Document introuvable.");
                    }
                    break;

                case 4:
                    System.out.print("Numéro du document à rechercher : ");
                    int numRecherche = sc.nextInt();
                    sc.nextLine();

                    Document resultat = b.document(numRecherche);

                    if (resultat != null) {
                        System.out.println(resultat);
                    } else {
                        System.out.println("Document introuvable.");
                    }
                    break;

                case 5:
                    b.afficherAuteurs();
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        sc.close();
    }
}

