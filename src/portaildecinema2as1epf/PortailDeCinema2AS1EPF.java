/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package portaildecinema2as1epf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Hugo
 */
public class PortailDeCinema2AS1EPF {
public static void main(String[] args) throws IOException {
Scanner sc = new Scanner(System.in);




        Portail données = new Portail();
        données.donnéesFilms();
        données.donnéesSeance();
        données.donnéesCinema();
        List<Séance> SéanceTrouvés = new ArrayList<Séance>();
        List<Films> FilmsTrouvés = new ArrayList<Films>();
        List<Cinéma> CinémaTrouvés = new ArrayList<Cinéma>();
        boolean boucle = true;
        int filtre = 2;
        int resultat;

        //Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue!");
        System.out.println("");
        System.out.println("Vous voici au portail de Cinéma realisé par Hugo Bordier et Nicolas Danquigny");
        System.out.println("Pour acceder a notre plateforme, merci d'entrée votre identifiant: ");
        String identifiant = sc.nextLine();
        System.out.println("");
        Utilisateur utilisateur;
        if ("admin".equals(identifiant)) {
            utilisateur = new Utilisateur(identifiant, true);
        } else {
            utilisateur = new Utilisateur(identifiant, false);
        }

        if (utilisateur.getVerification() == true) {
            System.out.println("Bonjour, ");
            System.out.println("Vous possedez des droits d'administrateur.");

            while (boucle == true) {
                System.out.println("que souhaitez vous faire?");
                System.out.println("");
                System.out.println("1: Consulter les Films de la base de données");
                System.out.println("2: Consulter les Cinémas de la base de données");
                System.out.println("3: Consulter les Séances de la base de données");
                System.out.println("");
                System.out.println("4: Ajouter un films dans la base de données");
                System.out.println("5: Ajouter une séance dans la base de données");
                System.out.println("6: Ajouter un cinéma dans la base de données");
                System.out.println("");
                System.out.println("7: Rechercher un film");
                System.out.println("8: Rechercher une séance");
                System.out.println("9: Rechercher un cinéma");
                System.out.println("");
                System.out.println("");
                System.out.println("Merci d'entrer le numéro associé a votre choix: ");
                int choix = sc.nextInt();
                System.out.println("");
                System.out.println("");

                if (choix == 1) {
                    données.donnéesFilmAfficher();
                }

                if (choix == 2) {
                    données.donnéesSéanceAfficher();
                }

                if (choix == 3) {
                    données.donnéesCinémaAfficher();
                }

                if (choix == 4) {
                    données.ajouterFilm();

                }

                if (choix == 5) {
                   données.ajouterSeance();
                }

                if (choix == 6) {
                    données.ajouerCinema();
                }

                if (choix == 7) {
                    if (filtre == 2) {
                        System.out.println("notre portail offre un vaste choix de critère pour trouver le film qui vous correspondra");
                        System.out.println("quel critère souhaitez vous renseigner afin de trouver votre film? ");
                        System.out.println("");
                        System.out.println("1: Un titre");
                        System.out.println("2: Un ou les differents genres");
                        System.out.println("3: Une date de Sortie");
                        System.out.println("4: Un ou plusieurs acteurs");
                        System.out.println("5: Un realisateur");
                        System.out.println("6: Des mots clefs");
                        System.out.println("7: Une note");
                        System.out.println("8: Un ou plusieurs lieux de projections (villes)");
                        System.out.println("9: Une durée");
                        System.out.println("");
                        int choixF = sc.nextInt();
                        System.out.println("");

                        if (choixF == 1) {
                            FilmsTrouvés = données.rechercherFilmsTitre(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 2) {
                            FilmsTrouvés = données.rechercherFilmsGenre(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 3) {

                            FilmsTrouvés = données.rechercherFilmsDateSortie(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 4) {

                            FilmsTrouvés = données.rechercherFilmsAct(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 5) {

                            FilmsTrouvés = données.rechercherFilmsReal(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 6) {

                            FilmsTrouvés = données.rechercherFilmsRésume(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 7) {

                            FilmsTrouvés = données.rechercherFilmsNote(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 8) {

                            FilmsTrouvés = données.rechercherFilmsLieuxProj(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 9) {

                            FilmsTrouvés = données.rechercherFilmsDurée(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        System.out.println("Souhaitez vous effectuer une nouvelle recherche, afin de filtrer par un autre critere la liste de films obtenu? ");
                        System.out.println("entrer 1 si oui, ou 2 si non: ");
                        filtre = sc.nextInt();
                    }

                    while (filtre == 1) {
                        System.out.println("quel critère souhaitez vous renseigner afin de trouver votre film? ");
                        System.out.println("");
                        System.out.println("1: Un titre");
                        System.out.println("2: Un ou les differents genres");
                        System.out.println("3: Une date de Sortie");
                        System.out.println("4: Un ou plusieurs acteurs");
                        System.out.println("5: Un realisateur");
                        System.out.println("6: Des mots clefs");
                        System.out.println("7: Une note");
                        System.out.println("8: Un ou plusieurs lieux de projections (villes)");
                        System.out.println("9: Une durée");

                        System.out.println("");
                        int choixF = sc.nextInt();
                        System.out.println("");

                        if (choixF == 1) {
                            FilmsTrouvés = données.rechercherFilmsTitre(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 2) {
                            FilmsTrouvés = données.rechercherFilmsGenre(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 3) {

                            FilmsTrouvés = données.rechercherFilmsDateSortie(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 4) {

                            FilmsTrouvés = données.rechercherFilmsAct(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 5) {

                            FilmsTrouvés = données.rechercherFilmsReal(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 6) {

                            FilmsTrouvés = données.rechercherFilmsRésume(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 7) {

                            FilmsTrouvés = données.rechercherFilmsNote(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 8) {

                            FilmsTrouvés = données.rechercherFilmsLieuxProj(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 9) {

                            FilmsTrouvés = données.rechercherFilmsDurée(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        System.out.println("Souhaitez vous effectuer une nouvelle recherche, afin de filtrer par un autre critere la liste de films obtenu? ");
                        System.out.println("entrer 1 si oui, ou 2 si non: ");
                        filtre = sc.nextInt();
                    }
                }
                if (choix == 8) {
                    if (filtre == 2) {
                        System.out.println("notre portail offre un vaste choix de critère pour trouver la séance qui vous correspondra");
                        System.out.println("quel critère souhaitez vous renseigner afin de trouver votre séance? ");
                        System.out.println("");
                        System.out.println("1: Un jour");
                        System.out.println("2: Une durée");
                        System.out.println("3: Un film");
                        int choixS = sc.nextInt();
                        System.out.println("");
                        System.out.println("");

                        if (choixS == 1) {
                            SéanceTrouvés = données.rechercherSéanceJour(données.getListeSéance(), false);
                            System.out.println("Voici les séances qui ont été trouvé: ");
                            données.listeSéanceTrouvésAfficher(SéanceTrouvés);
                        }
                        if (choixS == 2) {
                            SéanceTrouvés = données.rechercherSéanceDurée(données.getListeSéance(), false);
                            System.out.println("Voici les séances qui ont été trouvé: ");
                            données.listeSéanceTrouvésAfficher(SéanceTrouvés);
                        }
                        if (choixS == 3) {
                            SéanceTrouvés = données.rechercherSéanceFilm(données.getListeSéance(), false);
                            System.out.println("Voici les séances qui ont été trouvé: ");
                            données.listeSéanceTrouvésAfficher(SéanceTrouvés);
                        }
                        System.out.println("Souhaitez vous effectuer une nouvelle recherche, afin de filtrer par un autre critere la liste de films obtenu? ");
                        System.out.println("entrer 1 si oui, ou 2 si non: ");
                        filtre = sc.nextInt();
                    }

                    while (filtre == 1) {
                        System.out.println("quel critère souhaitez vous renseigner afin de trouver votre séance? ");
                        System.out.println("");
                        System.out.println("1: Un jour");
                        System.out.println("2: Une durée");
                        System.out.println("3: Un film");
                        int choixS = sc.nextInt();
                        System.out.println("");
                        System.out.println("");

                        if (choixS == 1) {
                            SéanceTrouvés = données.rechercherSéanceJour(SéanceTrouvés, true);
                            System.out.println("Voici les séances qui ont été trouvé: ");
                            données.listeSéanceTrouvésAfficher(SéanceTrouvés);
                        }
                        if (choixS == 2) {
                            SéanceTrouvés = données.rechercherSéanceDurée(SéanceTrouvés, true);
                            System.out.println("Voici les séances qui ont été trouvé: ");
                            données.listeSéanceTrouvésAfficher(SéanceTrouvés);
                        }
                        if (choixS == 3) {
                            SéanceTrouvés = données.rechercherSéanceFilm(SéanceTrouvés, true);
                            System.out.println("Voici les séances qui ont été trouvé: ");
                            données.listeSéanceTrouvésAfficher(SéanceTrouvés);
                        }
                        System.out.println("Souhaitez vous effectuer une nouvelle recherche, afin de filtrer par un autre critere la liste de films obtenu? ");
                        System.out.println("entrer 1 si oui, ou 2 si non: ");
                        filtre = sc.nextInt();
                    }
                }

                if (choix == 9) {
                    if (filtre == 2) {
                        System.out.println("notre portail offre un vaste choix de critère pour trouver le film qui vous correspondra");
                        System.out.println("quel critère souhaitez vous renseigner afin de trouver votre film? ");
                        System.out.println("");
                        System.out.println("1: Une ville");
                        System.out.println("2: Une note");
                        System.out.println("3: Un ou plusieurs films projetés");
                        System.out.println("4: Une ou plusieures séances");

                        int choixC = sc.nextInt();
                        System.out.println("");
                        System.out.println("");

                        if (choixC == 1) {
                            CinémaTrouvés = données.rechercherCinémaVille(données.getListeCinéma(), false);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        if (choixC == 2) {
                            CinémaTrouvés = données.rechercherCinémaNote(données.getListeCinéma(), false);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        if (choixC == 3) {
                            CinémaTrouvés = données.rechercherCinémaListeFilmsProj(données.getListeCinéma(), false);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        if (choixC == 4) {
                            CinémaTrouvés = données.rechercherCinémaListeSéanceJour(données.getListeCinéma(), false);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        System.out.println("Souhaitez vous effectuer une nouvelle recherche, afin de filtrer par un autre critere la liste de films obtenu? ");
                        System.out.println("entrer 1 si oui, ou 2 si non: ");
                        filtre = sc.nextInt();
                    }
                    while (filtre == 1) {
                        System.out.println("quel critère souhaitez vous renseigner afin de trouver votre film? ");
                        System.out.println("");
                        System.out.println("1: Une ville");
                        System.out.println("2: Une note");
                        System.out.println("3: Un ou plusieurs films projetés");
                        System.out.println("4: Une ou plusieures dates de séances");

                        int choixC = sc.nextInt();
                        System.out.println("");
                        System.out.println("");

                        if (choixC == 1) {
                            CinémaTrouvés = données.rechercherCinémaVille(CinémaTrouvés, true);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        if (choixC == 2) {
                            CinémaTrouvés = données.rechercherCinémaNote(CinémaTrouvés, true);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        if (choixC == 3) {
                            CinémaTrouvés = données.rechercherCinémaListeFilmsProj(CinémaTrouvés, true);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        if (choixC == 4) {
                            CinémaTrouvés = données.rechercherCinémaListeSéanceJour(CinémaTrouvés, true);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        System.out.println("Souhaitez vous effectuer une nouvelle recherche, afin de filtrer par un autre critere la liste de films obtenu? ");
                        System.out.println("entrer 1 si oui, ou 2 si non: ");
                        filtre = sc.nextInt();

                    }
                }
                System.out.println("voulez vous quitter notre plateforme?");
                System.out.println("entrer 1 si oui, ou 2 si non: ");

                resultat = sc.nextInt();
                if (resultat == 1) {
                    boucle = false;
                } else {
                    boucle = true;
                }
            }

        } else {
            System.out.println("Bonjour, ");
            while (boucle == true) {
                System.out.println("que souhaitez vous faire?");
                System.out.println("");
                System.out.println("1: Rechercher un film");
                System.out.println("2: Rechercher une séance");
                System.out.println("3: Rechercher un cinéma");
                System.out.println("");
                System.out.println("");
                System.out.println("Merci d'entrer le numéro associé a votre choix: ");
                int choix = sc.nextInt();
                System.out.println("");
                System.out.println("");

                if (choix == 1) {
                    if (filtre == 2) {
                        System.out.println("notre portail offre un vaste choix de critère pour trouver le film qui vous correspondra");
                        System.out.println("quel critère souhaitez vous renseigner afin de trouver votre film? ");
                        System.out.println("");
                        System.out.println("1: Un titre");
                        System.out.println("2: Un ou les differents genres");
                        System.out.println("3: Une date de Sortie");
                        System.out.println("4: Un ou plusieurs acteurs");
                        System.out.println("5: Un realisateur");
                        System.out.println("6: Des mots clefs");
                        System.out.println("7: Une note");
                        System.out.println("8: Un ou plusieurs lieux de projections (villes)");
                        System.out.println("9: Une durée");
                        System.out.println("");
                        int choixF = sc.nextInt();
                        System.out.println("");

                        if (choixF == 1) {
                            FilmsTrouvés = données.rechercherFilmsTitre(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 2) {
                            FilmsTrouvés = données.rechercherFilmsGenre(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 3) {

                            FilmsTrouvés = données.rechercherFilmsDateSortie(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 4) {

                            FilmsTrouvés = données.rechercherFilmsAct(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 5) {

                            FilmsTrouvés = données.rechercherFilmsReal(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 6) {

                            FilmsTrouvés = données.rechercherFilmsRésume(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 7) {

                            FilmsTrouvés = données.rechercherFilmsNote(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 8) {

                            FilmsTrouvés = données.rechercherFilmsLieuxProj(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 9) {

                            FilmsTrouvés = données.rechercherFilmsDurée(données.getListeFilms(), false);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        System.out.println("Souhaitez vous effectuer une nouvelle recherche, afin de filtrer par un autre critere la liste de films obtenu? ");
                        System.out.println("entrer 1 si oui, ou 2 si non: ");
                        filtre = sc.nextInt();
                    }

                    while (filtre == 1) {
                        System.out.println("quel critère souhaitez vous renseigner afin de trouver votre film? ");
                        System.out.println("");
                        System.out.println("1: Un titre");
                        System.out.println("2: Un ou les differents genres");
                        System.out.println("3: Une date de Sortie");
                        System.out.println("4: Un ou plusieurs acteurs");
                        System.out.println("5: Un realisateur");
                        System.out.println("6: Des mots clefs");
                        System.out.println("7: Une note");
                        System.out.println("8: Un ou plusieurs lieux de projections (villes)");
                        System.out.println("9: Une durée");

                        System.out.println("");
                        int choixF = sc.nextInt();
                        System.out.println("");

                        if (choixF == 1) {
                            FilmsTrouvés = données.rechercherFilmsTitre(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 2) {
                            FilmsTrouvés = données.rechercherFilmsGenre(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 3) {

                            FilmsTrouvés = données.rechercherFilmsDateSortie(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 4) {

                            FilmsTrouvés = données.rechercherFilmsAct(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 5) {

                            FilmsTrouvés = données.rechercherFilmsReal(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 6) {

                            FilmsTrouvés = données.rechercherFilmsRésume(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 7) {

                            FilmsTrouvés = données.rechercherFilmsNote(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 8) {

                            FilmsTrouvés = données.rechercherFilmsLieuxProj(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        if (choixF == 9) {

                            FilmsTrouvés = données.rechercherFilmsDurée(FilmsTrouvés, true);
                            System.out.println("Voici les films qui ont été trouvé: ");
                            données.listeFilmTrouvésAfficher(FilmsTrouvés);
                        }
                        System.out.println("Souhaitez vous effectuer une nouvelle recherche, afin de filtrer par un autre critere la liste de films obtenu? ");
                        System.out.println("entrer 1 si oui, ou 2 si non: ");
                        filtre = sc.nextInt();
                    }

                }

                if (choix == 2) {
                    if (filtre == 2) {
                        System.out.println("notre portail offre un vaste choix de critère pour trouver la séance qui vous correspondra");
                        System.out.println("quel critère souhaitez vous renseigner afin de trouver votre séance? ");
                        System.out.println("");
                        System.out.println("1: Un jour");
                        System.out.println("2: Une durée");
                        System.out.println("3: Un film");
                        int choixS = sc.nextInt();
                        System.out.println("");
                        System.out.println("");

                        if (choixS == 1) {
                            SéanceTrouvés = données.rechercherSéanceJour(données.getListeSéance(), false);
                            System.out.println("Voici les séances qui ont été trouvé: ");
                            données.listeSéanceTrouvésAfficher(SéanceTrouvés);
                        }
                        if (choixS == 2) {
                            SéanceTrouvés = données.rechercherSéanceDurée(données.getListeSéance(), false);
                            System.out.println("Voici les séances qui ont été trouvé: ");
                            données.listeSéanceTrouvésAfficher(SéanceTrouvés);
                        }
                        if (choixS == 3) {
                            SéanceTrouvés = données.rechercherSéanceFilm(données.getListeSéance(), false);
                            System.out.println("Voici les séances qui ont été trouvé: ");
                            données.listeSéanceTrouvésAfficher(SéanceTrouvés);
                        }
                        System.out.println("Souhaitez vous effectuer une nouvelle recherche, afin de filtrer par un autre critere la liste de films obtenu? ");
                        System.out.println("entrer 1 si oui, ou 2 si non: ");
                        filtre = sc.nextInt();
                    }

                    while (filtre == 1) {
                        System.out.println("quel critère souhaitez vous renseigner afin de trouver votre séance? ");
                        System.out.println("");
                        System.out.println("1: Un jour");
                        System.out.println("2: Une durée");
                        System.out.println("3: Un film");
                        int choixS = sc.nextInt();
                        System.out.println("");
                        System.out.println("");

                        if (choixS == 1) {
                            SéanceTrouvés = données.rechercherSéanceJour(SéanceTrouvés, true);
                            System.out.println("Voici les séances qui ont été trouvé: ");
                            données.listeSéanceTrouvésAfficher(SéanceTrouvés);
                        }
                        if (choixS == 2) {
                            SéanceTrouvés = données.rechercherSéanceDurée(SéanceTrouvés, true);
                            System.out.println("Voici les séances qui ont été trouvé: ");
                            données.listeSéanceTrouvésAfficher(SéanceTrouvés);
                        }
                        if (choixS == 3) {
                            SéanceTrouvés = données.rechercherSéanceFilm(SéanceTrouvés, true);
                            System.out.println("Voici les séances qui ont été trouvé: ");
                            données.listeSéanceTrouvésAfficher(SéanceTrouvés);
                        }
                        System.out.println("Souhaitez vous effectuer une nouvelle recherche, afin de filtrer par un autre critere la liste de films obtenu? ");
                        System.out.println("entrer 1 si oui, ou 2 si non: ");
                        filtre = sc.nextInt();
                    }
                }

                if (choix == 3) {
                    if (filtre == 2) {
                        System.out.println("notre portail offre un vaste choix de critère pour trouver le film qui vous correspondra");
                        System.out.println("quel critère souhaitez vous renseigner afin de trouver votre film? ");
                        System.out.println("");
                        System.out.println("1: Une ville");
                        System.out.println("2: Une note");
                        System.out.println("3: Un ou plusieurs films projetés");
                        System.out.println("4: Une ou plusieures séances");

                        int choixC = sc.nextInt();
                        System.out.println("");
                        System.out.println("");

                        if (choixC == 1) {
                            CinémaTrouvés = données.rechercherCinémaVille(données.getListeCinéma(), false);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        if (choixC == 2) {
                            CinémaTrouvés = données.rechercherCinémaNote(données.getListeCinéma(), false);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        if (choixC == 3) {
                            CinémaTrouvés = données.rechercherCinémaListeFilmsProj(données.getListeCinéma(), false);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        if (choixC == 4) {
                            CinémaTrouvés = données.rechercherCinémaListeSéanceJour(données.getListeCinéma(), false);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        System.out.println("Souhaitez vous effectuer une nouvelle recherche, afin de filtrer par un autre critere la liste de films obtenu? ");
                        System.out.println("entrer 1 si oui, ou 2 si non: ");
                        filtre = sc.nextInt();
                    }
                    while (filtre == 1) {
                        System.out.println("quel critère souhaitez vous renseigner afin de trouver votre film? ");
                        System.out.println("");
                        System.out.println("1: Une ville");
                        System.out.println("2: Une note");
                        System.out.println("3: Un ou plusieurs films projetés");
                        System.out.println("4: Une ou plusieures dates de séances");

                        int choixC = sc.nextInt();
                        System.out.println("");
                        System.out.println("");

                        if (choixC == 1) {
                            CinémaTrouvés = données.rechercherCinémaVille(CinémaTrouvés, true);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        if (choixC == 2) {
                            CinémaTrouvés = données.rechercherCinémaNote(CinémaTrouvés, true);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        if (choixC == 3) {
                            CinémaTrouvés = données.rechercherCinémaListeFilmsProj(CinémaTrouvés, true);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        if (choixC == 4) {
                            CinémaTrouvés = données.rechercherCinémaListeSéanceJour(CinémaTrouvés, true);
                            System.out.println("Voici les cinémas qui ont été trouvé: ");
                            données.listeCinémaTrouvésAfficher(CinémaTrouvés);
                        }
                        System.out.println("Souhaitez vous effectuer une nouvelle recherche, afin de filtrer par un autre critere la liste de films obtenu? ");
                        System.out.println("entrer 1 si oui, ou 2 si non: ");
                        filtre = sc.nextInt();

                    }

                }
                System.out.println("voulez vous quitter notre plateforme?");
                System.out.println("entrer 1 si oui, ou 2 si non: ");

                resultat = sc.nextInt();
                if (resultat == 1) {
                    boucle = false;
                } else {
                    boucle = true;
                }
            }
        }
    }
}

        
        
      /*Scanner scanner = new Scanner(System.in);
      System.out.println("Entrez le titre d'un film :");
      String title = scanner.nextLine();
      a.AddMovie();
      System.out.println("Film ajouté avec succès.");
        // TODO code application logic here*/
    
    

