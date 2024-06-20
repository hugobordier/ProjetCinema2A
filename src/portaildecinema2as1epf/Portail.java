/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portaildecinema2as1epf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Moi
 */
public class Portail {

    private List<Films> listeFilms;
    private List<Cinéma> listeEtablissement;
    private List<Séance> listeSéance;

    public Portail() {
        listeFilms = new ArrayList<Films>();
        listeEtablissement = new ArrayList<Cinéma>();
        listeSéance = new ArrayList<Séance>();
    }

    public List<Films> getListeFilms() {
        return listeFilms;
    }

    public List<Cinéma> getListeCinéma() {
        return listeEtablissement;
    }

    public List<Séance> getListeSéance() {
        return listeSéance;
    }

    public void donnéesFilms() throws FileNotFoundException, IOException {
        String FichierFilms = "films.txt";
        File fileF = new File(FichierFilms);
        Scanner scF = new Scanner(fileF);

        while (scF.hasNextLine()) {
            String ligne = scF.nextLine();//lit ligne par ligne grace a la boucle
            String[] tabDonnéesFilms = ligne.split("_");//dispatch les differents élements du films dans un tableau
            String[] tabDonnéesFilmsActs = tabDonnéesFilms[3].split(",");//dispatch les differents acteurs du films dans un autre tableau
            List<String> ListeDonnéesFilmsActs = new ArrayList<>();
            ListeDonnéesFilmsActs = Arrays.asList(tabDonnéesFilmsActs);// conversion tableau en arrayList
            String[] tabDonnéesFilmsLieuxProj = tabDonnéesFilms[7].split(",");//dispatch les differents leiux de projections du films dans un autre tableau
            List<String> ListeDonnéesFilmsLieuxProj = new ArrayList<>();
            ListeDonnéesFilmsLieuxProj = Arrays.asList(tabDonnéesFilmsLieuxProj);// conversion tableau en arrayList

            // convertir les strings selon les types des attributs de la classe Films
            DateTimeFormatter convertisseur = DateTimeFormatter.ofPattern("d/MM/yyyy");
            LocalDate dateSortieF = LocalDate.parse(tabDonnéesFilms[2], convertisseur);
            float notePresse = Float.valueOf(tabDonnéesFilms[6]);
            float durée = Float.valueOf(tabDonnéesFilms[8]);

            //remplissage arraylist de films
            listeFilms.add(new Films(tabDonnéesFilms[0], tabDonnéesFilms[1], dateSortieF, ListeDonnéesFilmsActs, tabDonnéesFilms[4], tabDonnéesFilms[5], notePresse, ListeDonnéesFilmsLieuxProj, durée, tabDonnéesFilms[9]));

        }
        scF.close();
    }

    public void donnéesFilmAfficher() {
        //affichage de la liste 
        for (int cpt = 0; cpt < listeFilms.size(); cpt++) {
            System.out.println(listeFilms.get(cpt).ToString());
            System.out.println("");
        }
    }

    public void donnéesSeance() throws FileNotFoundException, IOException {
        String FichierSéance = "seance.txt";
        File fileS = new File(FichierSéance);
        Scanner scS = new Scanner(fileS);
        int cpt = 0;
        while (scS.hasNextLine()) {
            String ligne = scS.nextLine();//lit ligne par ligne grace a la boucle

            String[] tabDonnéesSéance = ligne.split("_");//dispatch les differents élements de la seance dans un tableau
            String[] tabDonnéesSéanceTarifsString = tabDonnéesSéance[4].split(",");//dispatch les differents acteurs du films dans un autre tableau
            float Tarif1 = Float.valueOf(tabDonnéesSéanceTarifsString[0]);
            float Tarif2 = Float.valueOf(tabDonnéesSéanceTarifsString[1]);
            float Tarif3 = Float.valueOf(tabDonnéesSéanceTarifsString[2]);
            Float[] tabDonnéesSéanceTarifs = new Float[3];
            tabDonnéesSéanceTarifs[0] = Tarif1;
            tabDonnéesSéanceTarifs[1] = Tarif2;
            tabDonnéesSéanceTarifs[2] = Tarif3;
            List<Float> ListeDonnéesSéanceTarifs = new ArrayList<>();
            ListeDonnéesSéanceTarifs = Arrays.asList(tabDonnéesSéanceTarifs);

            String[] tabDonnéesSéanceHoraire = tabDonnéesSéance[5].split("-");
            List<String> ListeDonnéesSéanceHoraires = new ArrayList<>();
            ListeDonnéesSéanceHoraires = Arrays.asList(tabDonnéesSéanceHoraire);

            // convertir les strings selon les types des attributs de la classe Seance
            DateTimeFormatter convertisseur = DateTimeFormatter.ofPattern("d/MM/yyyy");
            LocalDate jour = LocalDate.parse(tabDonnéesSéance[0], convertisseur);
            float durée = Float.valueOf(tabDonnéesSéance[1]);

            // on cherche l'identifiant dans la liste de films et on chope le film correspondant) 
            int place = 0;
            for (int i = 0; i < listeFilms.size(); i++) {
                if (listeFilms.get(i).contientIdF(tabDonnéesSéance[2])) {
                    place = i;
                }
            }
            Films FilmSéance = listeFilms.get(place);

            //remplissage arraylist de seance
            listeSéance.add(new Séance(jour, durée, FilmSéance, tabDonnéesSéance[3], ListeDonnéesSéanceTarifs, ListeDonnéesSéanceHoraires));
        }
        scS.close();
    }

    public void donnéesSéanceAfficher() {
        //affichage de la liste 
        for (int cpt = 0; cpt < listeSéance.size(); cpt++) {
            System.out.println(listeSéance.get(cpt).ToString());
            System.out.println("");
        }
    }

    public void donnéesCinema() throws FileNotFoundException, IOException {
        String FichierCinéma = "cinema.txt";
        File fileC = new File(FichierCinéma);
        Scanner scC = new Scanner(fileC);
        int cpt = 0;
        while (scC.hasNextLine()) {
            String ligne = scC.nextLine();//lit ligne par ligne grace a la boucle

            String[] tabDonnéesCinéma = ligne.split("_");//dispatch les differents élements du cinéma dans un tableau
            String[] tabDonnéesFilmsProj = tabDonnéesCinéma[3].split(",");//dispatch les differents tarifs dans un autre tableau
            String[] tabDonnéesSéanceC = tabDonnéesCinéma[4].split(",");//dispatch les differents horaires de films dans un autre tableau

            // convertir les strings selon les types des attributs de la classe Seance
            float noteEtablissement = Float.valueOf(tabDonnéesCinéma[2]);

            // on cherche l'identifiant dans la liste de films et on chope le film correspondant) 
            ArrayList<Films> listeFilmsTrouvés = new ArrayList<Films>();
            for (int j = 0; j < tabDonnéesFilmsProj.length; j++) {
                boolean trouve = false;
                for (int i = 0; i < listeFilms.size() && trouve == false; i++) {
                    if (tabDonnéesFilmsProj[j].equals(listeFilms.get(i).getIdentifiantF())) {
                        listeFilmsTrouvés.add(listeFilms.get(i));
                        trouve = true;
                    }
                }
            }
            // on cherche l'identifiant dans la liste de films et on chope le film correspondant) 
            ArrayList<Séance> listeSéanceTrouvés = new ArrayList<Séance>();

            for (int j = 0; j < tabDonnéesSéanceC.length; j++) {
                for (int i = 0; i < listeSéance.size(); i++) {
                    if (tabDonnéesSéanceC[j].equals(listeSéance.get(i).getIdentifiant())) {
                        listeSéanceTrouvés.add(listeSéance.get(i));
                    }
                }
            }
            //remplissage arraylist de seance
            listeEtablissement.add(new Cinéma(tabDonnéesCinéma[0], tabDonnéesCinéma[1], noteEtablissement, listeFilmsTrouvés, listeSéanceTrouvés));

        }
    }

    public void donnéesCinémaAfficher() {
        //affichage de la liste 
        for (int cpt = 0; cpt < listeEtablissement.size(); cpt++) {
            System.out.println(listeEtablissement.get(cpt).ToString());
            System.out.println("");
        }
    }

    public void donnéesAdministration() throws FileNotFoundException, IOException {
        String Fichieradmin = "administration.txt";
        File fileA = new File(Fichieradmin);
        Scanner scA = new Scanner(fileA);
        while (scA.hasNextLine()) {
            String ligne = scA.nextLine();
            System.out.println(ligne);
        }
        scA.close();
    }

    public ArrayList<Films> rechercherFilmsTitre(List<Films> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeFilms = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        String titreCherché;
        ArrayList<Films> listeFilmsTrouvés = new ArrayList<Films>();
        System.out.println("Entrer le nom du film ou une partie du nom: ");
        titreCherché = sc.nextLine();

        titreCherché = titreCherché.toUpperCase();
        for (int i = 0; i < listeFilms.size(); i++) {
            if (listeFilms.get(i).contientTitre(titreCherché)) {
                listeFilmsTrouvés.add(listeFilms.get(i));
            }
        }
        return listeFilmsTrouvés;
    }

    public ArrayList<Films> rechercherFilmsGenre(List<Films> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeFilms = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        String genreCherché;
        ArrayList<Films> listeFilmsTrouvés = new ArrayList<Films>();
        System.out.println("Entrer le genre du film: ");
        genreCherché = sc.nextLine();

        genreCherché = genreCherché.toUpperCase();
        for (int i = 0; i < listeFilms.size(); i++) {
            if (listeFilms.get(i).contientGenre(genreCherché)) {
                listeFilmsTrouvés.add(listeFilms.get(i));
            }
        }
        return listeFilmsTrouvés;
    }

    public ArrayList<Films> rechercherFilmsReal(List<Films> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeFilms = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        String realCherché;
        ArrayList<Films> listeFilmsTrouvés = new ArrayList<Films>();
        System.out.println("Entrer le réalisateur: ");
        realCherché = sc.nextLine();

        realCherché = realCherché.toUpperCase();
        for (int i = 0; i < listeFilms.size(); i++) {
            if (listeFilms.get(i).contientReal(realCherché)) {
                listeFilmsTrouvés.add(listeFilms.get(i));
            }
        }
        return listeFilmsTrouvés;
    }

    public ArrayList<Films> rechercherFilmsDateSortie(List<Films> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeFilms = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        LocalDate DateSortieCherché;
        ArrayList<Films> listeFilmsTrouvés = new ArrayList<Films>();
        System.out.println("Souhaitez vous renseigner une date complète?, un jour?, un mois?, ou une année?");
        System.out.println("Pour une date complète, tapez 0:");
        System.out.println("Pour un jour seul, tapez 1:");
        System.out.println("Pour un mois seul, tapez 2:");
        System.out.println("Pour une année seule, tapez 3:");
        int demandeUtilisateur = sc.nextInt();

        if (demandeUtilisateur == 0) {

            System.out.println("Entrer le numéro du jour: ");
            int jourCherché = sc.nextInt();
            while (jourCherché < 1 || jourCherché > 31) {
                System.out.println("Veuillez saisir une nouvelle fois le numéro du jour: ");
                System.out.println("Il doit etre compris entre 1 et 31");
                jourCherché = sc.nextInt();
            }

            System.out.println("Entrer le numéro du mois: ");
            int moisCherché = sc.nextInt();
            while (moisCherché < 1 || moisCherché > 12) {
                System.out.println("Veuillez saisir une nouvelle fois le numéro du mois: ");
                System.out.println("Il doit etre compris entre 1 et 12");
                moisCherché = sc.nextInt();
            }

            System.out.println("Entrer l'année: ");
            int annéeCherché = sc.nextInt();
            while (annéeCherché < 1900 || annéeCherché > 2022) {
                System.out.println("Veuillez saisir une nouvelle fois l'année: ");
                annéeCherché = sc.nextInt();
            }
            DateSortieCherché = LocalDate.of(annéeCherché, moisCherché, jourCherché);
            for (int i = 0; i < listeFilms.size(); i++) {
                if (listeFilms.get(i).contientdateSortieParticuliere(DateSortieCherché)) {
                    listeFilmsTrouvés.add(listeFilms.get(i));
                }
            }
        }
        if (demandeUtilisateur == 1) {
            System.out.println("Entrer le numéro du jour: ");
            int jourCherché = sc.nextInt();
            while (jourCherché < 1 || jourCherché > 31) {
                System.out.println("Veuillez saisir une nouvelle fois le numéro du jour: ");
                System.out.println("Il doit etre compris entre 1 et 31");
                jourCherché = sc.nextInt();
            }
            for (int i = 0; i < listeFilms.size(); i++) {
                if (listeFilms.get(i).contientdateSortieNuméroJour(jourCherché)) {
                    listeFilmsTrouvés.add(listeFilms.get(i));
                }
            }
        }
        if (demandeUtilisateur == 2) {
            System.out.println("Entrer le numéro du mois: ");
            int moisCherché = sc.nextInt();
            while (moisCherché < 1 || moisCherché > 12) {
                System.out.println("Veuillez saisir une nouvelle fois le numéro du mois: ");
                System.out.println("Il doit etre compris entre 1 et 12");
                moisCherché = sc.nextInt();
            }

            for (int i = 0; i < listeFilms.size(); i++) {
                if (listeFilms.get(i).contientdateSortieMois(moisCherché)) {
                    listeFilmsTrouvés.add(listeFilms.get(i));
                }
            }
        }
        if (demandeUtilisateur == 3) {
            int annéeCherché = sc.nextInt();
            while (annéeCherché < 1800 || annéeCherché > 2022) {
                System.out.println("Veuillez saisir une nouvelle fois l'année: ");
                annéeCherché = sc.nextInt();
            }

            for (int i = 0; i < listeFilms.size(); i++) {
                if (listeFilms.get(i).contientdateSortieAnnée(annéeCherché)) {
                    listeFilmsTrouvés.add(listeFilms.get(i));
                }
            }

        }
        return listeFilmsTrouvés;
    }

    public ArrayList<Films> rechercherFilmsRésume(List<Films> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeFilms = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        String motsClefCherché;
        ArrayList<Films> listeFilmsTrouvés = new ArrayList<Films>();
        System.out.println("Entrer les mots clefs (séparés par des espaces): ");
        motsClefCherché = sc.nextLine();

        for (int i = 0; i < listeFilms.size(); i++) {
            if (listeFilms.get(i).contientRésumé(motsClefCherché)) {
                listeFilmsTrouvés.add(listeFilms.get(i));
            }
        }
        return listeFilmsTrouvés;
    }

    public ArrayList<Films> rechercherFilmsNote(List<Films> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeFilms = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        float noteCherché;
        ArrayList<Films> listeFilmsTrouvés = new ArrayList<Films>();
        System.out.println("Entrer la note que souhaitez (vous pourrez precisez si vous souhaiter un film avec une note plus basse, plus élévée ou avec une note égale à la note que vous avez renseigné): ");
        noteCherché = sc.nextInt();
        System.out.println("Pour un film avec une note égale, tapez 1: ");
        System.out.println("Pour un film avec une note inferieur, tapez 2: ");
        System.out.println("Pour un film avec une note supérieur, tapez 3: ");
        int demandeUtilisateur = sc.nextInt();

        if (demandeUtilisateur == 1) {
            for (int i = 0; i < listeFilms.size(); i++) {
                if (listeFilms.get(i).contientNotePresseEgale(noteCherché)) {
                    listeFilmsTrouvés.add(listeFilms.get(i));
                }
            }
        }
        if (demandeUtilisateur == 2) {
            for (int i = 0; i < listeFilms.size(); i++) {
                if (listeFilms.get(i).contientNotePresseInf(noteCherché)) {
                    listeFilmsTrouvés.add(listeFilms.get(i));
                }
            }
        }
        if (demandeUtilisateur == 3) {
            for (int i = 0; i < listeFilms.size(); i++) {
                if (listeFilms.get(i).contientNotePresseSup(noteCherché)) {
                    listeFilmsTrouvés.add(listeFilms.get(i));
                }
            }

        }
        return listeFilmsTrouvés;
    }

    public ArrayList<Films> rechercherFilmsDurée(List<Films> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeFilms = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        float duréeCherché;
        ArrayList<Films> listeFilmsTrouvés = new ArrayList<Films>();
        System.out.println("Entrer la durée que souhaitez en minutes (vous pourrez precisez si vous souhaiter un film plus long, plus court ou avec une durée égale au nombre de minutes que vous avez renseigné): ");
        duréeCherché = sc.nextInt();
        System.out.println("Pour une durée égale, tapez 1: ");
        System.out.println("Pour un durée plus courte, tapez 2: ");
        System.out.println("Pour une durée plus longue, tapez 3: ");
        int demandeUtilisateur = sc.nextInt();

        if (demandeUtilisateur == 1) {
            for (int i = 0; i < listeFilms.size(); i++) {
                if (listeFilms.get(i).contientDuréeEgale(duréeCherché)) {
                    listeFilmsTrouvés.add(listeFilms.get(i));
                }
            }
        }
        if (demandeUtilisateur == 2) {
            for (int i = 0; i < listeFilms.size(); i++) {
                if (listeFilms.get(i).contientDuréeInf(duréeCherché)) {
                    listeFilmsTrouvés.add(listeFilms.get(i));
                }
            }
        }
        if (demandeUtilisateur == 3) {
            for (int i = 0; i < listeFilms.size(); i++) {
                if (listeFilms.get(i).contientDuréeSup(duréeCherché)) {
                    listeFilmsTrouvés.add(listeFilms.get(i));
                }
            }
        }
        return listeFilmsTrouvés;
    }

    public ArrayList<Films> rechercherFilmsAct(List<Films> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeFilms = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        List<String> actsCherché = new ArrayList<String>();
        List<String> actsCherché1 = new ArrayList<String>();
        ArrayList<Films> listeFilmsTrouvés = new ArrayList<Films>();
        System.out.println("combien d'acteurs allez vous rentrer ? : ");
        int nombreActs = sc.nextInt();
        System.out.println("Entrer les acteurs succesivement: ");
        for (int i = 0; i <= nombreActs; i++) {
            actsCherché1.add(sc.nextLine());
        }
        actsCherché = actsCherché1;
        System.out.println("");
        boolean contient = false;
        boolean contientTous = true;
        for (int i = 0; i < listeFilms.size(); i++) {
            for (int j = 0; j < actsCherché.size(); j++) {
                if (listeFilms.get(i).contientgetListeAct(actsCherché, j)) {
                    contient = true;
                }
                if (listeFilms.get(i).contientgetListeAct(actsCherché, j) == false) {
                    contientTous = false;
                }
            }
            if (contientTous) {
                listeFilmsTrouvés.add(listeFilms.get(i));
                System.out.println("le film: " + listeFilms.get(i).getTitre() + ", contient tous les acteurs demandés");
            }
            if (contient) {
                listeFilmsTrouvés.add(listeFilms.get(i));
                System.out.println("le film: " + listeFilms.get(i).getTitre() + ", contient au moins un des acteurs demandés");
            }
        }
        return listeFilmsTrouvés;
    }

    public ArrayList<Films> rechercherFilmsLieuxProj(List<Films> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeFilms = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        List<String> lieuxProjCherché = new ArrayList<String>();
        List<String> lieuxProjCherché1 = new ArrayList<String>();
        ArrayList<Films> listeFilmsTrouvés = new ArrayList<Films>();
        System.out.println("combien de lieux de projections (villes) allez vous rentrer ? : ");
        int nombreLieux = sc.nextInt();
        System.out.println("Entrer les lieux de projections (villes) succesivement: ");
        for (int i = 0; i <= nombreLieux; i++) {
            lieuxProjCherché1.add(sc.nextLine());
        }
        lieuxProjCherché = lieuxProjCherché1;
        boolean contient = false;
        boolean contientTous = true;
        for (int i = 0; i < listeFilms.size(); i++) {
            for (int j = 0; j < lieuxProjCherché.size(); j++) {

                if (listeFilms.get(i).contientgetlieuxProj(lieuxProjCherché, j)) {
                    contient = true;
                }
                if (listeFilms.get(i).contientgetlieuxProj(lieuxProjCherché, j) == false) {
                    contientTous = false;
                }
            }
            if (contientTous) {
                listeFilmsTrouvés.add(listeFilms.get(i));
                System.out.println("le film: " + listeFilms.get(i).getTitre() + ", est disponible dans toutes les villes demandées");
            }
            if (contient) {
                listeFilmsTrouvés.add(listeFilms.get(i));
                System.out.println("le film:" + listeFilms.get(i).getTitre() + ", est disponible dans au moins une villes demandées");
            }
        }
        return listeFilmsTrouvés;
    }

    public void listeFilmTrouvésAfficher(List<Films> listeFilmsTrouvés) {
        //affichage de la liste 
        for (int cpt = 0; cpt < listeFilmsTrouvés.size(); cpt++) {
            System.out.println(listeFilmsTrouvés.get(cpt).ToString());

        }
        System.out.println("nombre de films trouvé: " + listeFilmsTrouvés.size());
        System.out.println("");
        System.out.println("");
    }

    public ArrayList<Séance> rechercherSéanceJour(List<Séance> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeSéance = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        LocalDate DatejourCherché;
        ArrayList<Séance> listeSéancesTrouvés = new ArrayList<Séance>();
        System.out.println("Souhaitez vous renseigner une date complète?, un jour?, un mois?, ou une année?");
        System.out.println("Pour une date complète, tapez 0:");
        System.out.println("Pour un jour seul, tapez 1:");
        System.out.println("Pour un mois seul, tapez 2:");
        System.out.println("Pour une année seule, tapez 3:");
        int demandeUtilisateur = sc.nextInt();

        if (demandeUtilisateur == 0) {
            System.out.println("Entrer le numéro du jour: ");
            int jourSCherché = sc.nextInt();
            while (jourSCherché < 1 || jourSCherché > 31) {
                System.out.println("Veuillez saisir une nouvelle fois le numéro du jour: ");
                System.out.println("Il doit etre compris entre 1 et 31");
                jourSCherché = sc.nextInt();
            }
            System.out.println("Entrer le numéro du mois: ");
            int moisSCherché = sc.nextInt();
            while (moisSCherché < 1 || moisSCherché > 12) {
                System.out.println("Veuillez saisir une nouvelle fois le numéro du mois: ");
                System.out.println("Il doit etre compris entre 1 et 12");
                moisSCherché = sc.nextInt();
            }

            System.out.println("Entrer l'année: ");
            int annéeSCherché = sc.nextInt();
            while (annéeSCherché < 2022 || annéeSCherché > 2025) {
                System.out.println("Veuillez saisir une nouvelle fois l'année: ");
                annéeSCherché = sc.nextInt();
            }
            DatejourCherché = LocalDate.of(annéeSCherché, moisSCherché, jourSCherché);
            for (int i = 0; i < listeSéance.size(); i++) {
                if (listeSéance.get(i).contientdateSéance(DatejourCherché)) {
                    listeSéancesTrouvés.add(listeSéance.get(i));
                }
            }
        }
        if (demandeUtilisateur == 1) {
            System.out.println("Entrer le numéro du jour: ");
            int jourSCherché = sc.nextInt();
            while (jourSCherché < 1 || jourSCherché > 31) {
                System.out.println("Veuillez saisir une nouvelle fois le numéro du jour: ");
                System.out.println("Il doit etre compris entre 1 et 31");
                jourSCherché = sc.nextInt();
            }
            for (int i = 0; i < listeSéance.size(); i++) {
                if (listeSéance.get(i).contientdateSéanceNuméroJour(jourSCherché)) {
                    listeSéancesTrouvés.add(listeSéance.get(i));
                }
            }
        }
        if (demandeUtilisateur == 2) {
            System.out.println("Entrer le numéro du mois: ");
            int moisSCherché = sc.nextInt();
            while (moisSCherché < 1 || moisSCherché > 12) {
                System.out.println("Veuillez saisir une nouvelle fois le numéro du mois: ");
                System.out.println("Il doit etre compris entre 1 et 12");
                moisSCherché = sc.nextInt();
            }
            for (int i = 0; i < listeSéance.size(); i++) {
                if (listeSéance.get(i).contientdateSéanceNuméroMois(moisSCherché)) {
                    listeSéancesTrouvés.add(listeSéance.get(i));
                }
            }
        }
        if (demandeUtilisateur == 3) {
            System.out.println("Entrer l'année: ");
            int annéeSCherché = sc.nextInt();
            while (annéeSCherché < 2022 || annéeSCherché > 2025) {
                System.out.println("Veuillez saisir une nouvelle fois l'année: ");
                annéeSCherché = sc.nextInt();
            }
            for (int i = 0; i < listeSéance.size(); i++) {
                if (listeSéance.get(i).contientdateSéanceAnnée(annéeSCherché)) {
                    listeSéancesTrouvés.add(listeSéance.get(i));
                }
            }
        }
        return listeSéancesTrouvés;
    }

    public ArrayList<Séance> rechercherSéanceDurée(List<Séance> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeSéance = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        float duréeCherché;
        ArrayList<Séance> listeSéancesTrouvés = new ArrayList<Séance>();
        System.out.println("Entrer la durée que souhaitez en minutes (vous pourrez precisez si vous souhaiter une séance plus longue, plus courte ou égale au nombre de minutes que vous avez renseigné): ");
        duréeCherché = sc.nextInt();
        System.out.println("Pour une durée égale, tapez 1:");
        System.out.println("Pour un durée plus courte, tapez 2:");
        System.out.println("Pour une durée plus longue, tapez 3:");
        int demandeUtilisateur = sc.nextInt();

        if (demandeUtilisateur == 1) {
            for (int i = 0; i < listeSéance.size(); i++) {
                if (listeSéance.get(i).contientDuréeSEgale(duréeCherché)) {
                    listeSéancesTrouvés.add(listeSéance.get(i));
                }
            }
        }
        if (demandeUtilisateur == 2) {
            for (int i = 0; i < listeSéance.size(); i++) {
                if (listeSéance.get(i).contientDuréeSInf(duréeCherché)) {
                    listeSéancesTrouvés.add(listeSéance.get(i));
                }
            }
        }
        if (demandeUtilisateur == 3) {
            for (int i = 0; i < listeSéance.size(); i++) {
                if (listeSéance.get(i).contientDuréeSSup(duréeCherché)) {
                    listeSéancesTrouvés.add(listeSéance.get(i));
                }
            }
        }
        return listeSéancesTrouvés;
    }

    public ArrayList<Séance> rechercherSéanceFilm(List<Séance> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeSéance = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        String titreFilmCherché;
        ArrayList<Séance> listeSéancesFilmsTrouvés = new ArrayList<Séance>();
        System.out.println("Entrer le titre du film ou une partie du titre: ");
        titreFilmCherché = sc.nextLine();

        for (int i = 0; i < listeSéance.size(); i++) {
            if (listeSéance.get(i).contientfilm(titreFilmCherché)) {
                listeSéancesFilmsTrouvés.add(listeSéance.get(i));
            }
        }
        return listeSéancesFilmsTrouvés;
    }

    public void listeSéanceTrouvésAfficher(List<Séance> listeSéanceTrouvés) {
        //affichage de la liste 
        for (int cpt = 0; cpt < listeSéanceTrouvés.size(); cpt++) {
            System.out.println(listeSéanceTrouvés.get(cpt).ToString());

        }
        System.out.println("nombre de séances trouvé: " + listeSéanceTrouvés.size());
        System.out.println("");
        System.out.println("");
    }

    public ArrayList<Cinéma> rechercherCinémaVille(List<Cinéma> listeTrouvée, boolean filtre) {
        if (filtre) {
            listeEtablissement = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        String villeCherché;
        ArrayList<Cinéma> listeCinémaTrouvés = new ArrayList<Cinéma>();
        System.out.println("Entrer le nom de la ville ou une partie du nom: ");
        villeCherché = sc.nextLine();

        villeCherché = villeCherché.toUpperCase();
        for (int i = 0; i < listeEtablissement.size(); i++) {
            if (listeEtablissement.get(i).contientCoordonéesGeo(villeCherché)) {
                listeCinémaTrouvés.add(listeEtablissement.get(i));
            }
        }
        return listeCinémaTrouvés;
    }

    public ArrayList<Cinéma> rechercherCinémaNote(List<Cinéma> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeEtablissement = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        float noteCherché;
        ArrayList<Cinéma> listeCinémaTrouvés = new ArrayList<Cinéma>();
        System.out.println("Entrer la note que souhaitez (vous pourrez precisez si vous souhaiter un cinéma avec une note plus basse, plus élévée ou avec une note égale à la note que vous avez renseigné): ");
        noteCherché = sc.nextInt();
        System.out.println("Pour un cinéma avec une note égale, tapez 1: ");
        System.out.println("Pour un cinéma avec une note inferieur, tapez 2: ");
        System.out.println("Pour un cinéma avec une note supérieur, tapez 3: ");
        int demandeUtilisateur = sc.nextInt();

        if (demandeUtilisateur == 1) {
            for (int i = 0; i < listeEtablissement.size(); i++) {
                if (listeEtablissement.get(i).contientNoteEtablissementEgale(noteCherché)) {
                    listeCinémaTrouvés.add(listeEtablissement.get(i));
                }
            }
        }
        if (demandeUtilisateur == 2) {
            for (int i = 0; i < listeEtablissement.size(); i++) {
                if (listeEtablissement.get(i).contientNoteEtablissementInf(noteCherché)) {
                    listeCinémaTrouvés.add(listeEtablissement.get(i));
                }
            }
        }
        if (demandeUtilisateur == 3) {
            for (int i = 0; i < listeEtablissement.size(); i++) {
                if (listeEtablissement.get(i).contientNoteEtablissementSup(noteCherché)) {
                    listeCinémaTrouvés.add(listeEtablissement.get(i));
                }
            }

        }
        return listeCinémaTrouvés;
    }

    public ArrayList<Cinéma> rechercherCinémaListeFilmsProj(List<Cinéma> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeEtablissement = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        List<String> listFilmsCherché = new ArrayList<String>();
        List<String> listFilmsCherché1 = new ArrayList<String>();
        ArrayList<Cinéma> listeCinémaTrouvés = new ArrayList<Cinéma>();
        System.out.println("combien de films allez vous rentrer ? : ");
        int nombreFilms = sc.nextInt();
        System.out.println("Entrer les titres de films succesivement: ");
        for (int i = 0; i <= nombreFilms; i++) {
            listFilmsCherché1.add(sc.nextLine());
        }
        listFilmsCherché = listFilmsCherché1;
        boolean contient = false;
        boolean contientTous = true;
        for (int i = 0; i < listeEtablissement.size(); i++) {
            for (int j = 0; j < listeEtablissement.get(i).getListeFilmsProj().size(); j++) {
                for (int k = 0; k < listFilmsCherché.size(); k++) {

                    if (listeEtablissement.get(i).contientListeFilmsProj(listFilmsCherché, j, k)) {
                        contient = true;
                    }
                    if (listeEtablissement.get(i).contientListeFilmsProj(listFilmsCherché, j, k) == false) {
                        contientTous = false;
                    }
                }
            }

            if (contientTous) {
                listeCinémaTrouvés.add(listeEtablissement.get(i));
                System.out.println("Le cinéma: " + listeEtablissement.get(i).getIdentifiant() + "a tous les films demandés");
            }
            if (contient) {
                listeCinémaTrouvés.add(listeEtablissement.get(i));
                System.out.println("Le cinéma: " + listeEtablissement.get(i).getIdentifiant() + ", a au moins un film demandé");
            }
        }
        return listeCinémaTrouvés;
    }

    public ArrayList<Cinéma> rechercherCinémaListeSéanceJour(List<Cinéma> listeTrouvée, Boolean filtre) {
        if (filtre) {
            listeEtablissement = listeTrouvée;
        }
        Scanner sc = new Scanner(System.in);
        List<LocalDate> listJourSéanceCherchéDate = new ArrayList<LocalDate>();
        ArrayList<Cinéma> listeCinémaTrouvés = new ArrayList<Cinéma>();
        List<Integer> listJourSéanceCherchéPariculiere = new ArrayList<Integer>();
        boolean contient = false;
        boolean contientTous = true;

        System.out.println("combien de jour allez vous rentrer ? : ");
        int nombreJour = sc.nextInt();

        System.out.println("Souhaitez vous renseigner des dates complètes?, des jours?, des mois?, ou des années?");
        System.out.println("Pour une ou plusieurs dates complètes, tapez 0:");
        System.out.println("Pour un ou plusieurs jours seuls, tapez 1:");
        System.out.println("Pour un ou plusieurs mois seuls, tapez 2:");
        System.out.println("Pour une ou plusieurs années seules, tapez 3:");
        int demandeUtilisateur = sc.nextInt();

        if (demandeUtilisateur == 0) {
            for (int i = 0; i < nombreJour; i++) {
                System.out.println("Entrer le numéro du jour: ");
                int jourCSCherché = sc.nextInt();
                while (jourCSCherché < 1 || jourCSCherché > 31) {
                    System.out.println("Veuillez saisir une nouvelle fois le numéro du jour: ");
                    System.out.println("Il doit etre compris entre 1 et 31");
                    jourCSCherché = sc.nextInt();
                }
                System.out.println("Entrer le numéro du mois: ");
                int moisCSCherché = sc.nextInt();
                while (moisCSCherché < 1 || moisCSCherché > 12) {
                    System.out.println("Veuillez saisir une nouvelle fois le numéro du mois: ");
                    System.out.println("Il doit etre compris entre 1 et 12");
                    moisCSCherché = sc.nextInt();
                }

                System.out.println("Entrer l'année: ");
                int annéeCSCherché = sc.nextInt();
                while (annéeCSCherché < 2022 || annéeCSCherché > 2025) {
                    System.out.println("Veuillez saisir une nouvelle fois l'année: ");
                    annéeCSCherché = sc.nextInt();
                }
                LocalDate DatejourCherché = LocalDate.of(annéeCSCherché, moisCSCherché, jourCSCherché);
                listJourSéanceCherchéDate.add(DatejourCherché);
            }

            for (int i = 0; i < listeEtablissement.size(); i++) {
                for (int j = 0; j < listeEtablissement.get(i).getListeSeances().size(); j++) {
                    for (int k = 0; k < listJourSéanceCherchéDate.size(); k++) {

                        if (listeEtablissement.get(i).contientListeSéancesDate(listJourSéanceCherchéDate, j, k)) {
                            contient = true;
                        }
                        if (listeEtablissement.get(i).contientListeSéancesDate(listJourSéanceCherchéDate, j, k) == false) {
                            contientTous = false;
                        }
                    }
                }
                if (contientTous) {
                    listeCinémaTrouvés.add(listeEtablissement.get(i));
                    System.out.println("Le cinéma: " + listeEtablissement.get(i).getIdentifiant() + "a des Séances coresspondantes a toutes les dates demandées");
                }
                if (contient) {
                    listeCinémaTrouvés.add(listeEtablissement.get(i));
                    System.out.println("Le cinéma: " + listeEtablissement.get(i).getIdentifiant() + ", a au moins une Séance aux dates demandées");
                }

            }
        }
        if (demandeUtilisateur == 1) {
            for (int i = 0; i < nombreJour; i++) {
                System.out.println("Entrer le numéro du jour: ");
                int jourCCherché = sc.nextInt();
                while (jourCCherché < 1 || jourCCherché > 31) {
                    System.out.println("Veuillez saisir une nouvelle fois le numéro du jour: ");
                    System.out.println("Il doit etre compris entre 1 et 31");
                    jourCCherché = sc.nextInt();
                }
                listJourSéanceCherchéPariculiere.add(jourCCherché);
            }
            for (int i = 0; i < listeEtablissement.size(); i++) {
                for (int j = 0; j < listeEtablissement.get(i).getListeSeances().size(); j++) {
                    for (int k = 0; k < listJourSéanceCherchéPariculiere.size(); k++) {

                        if (listeEtablissement.get(i).contientListeSéancesJour(listJourSéanceCherchéPariculiere, j, k)) {
                            contient = true;
                        }
                        if (listeEtablissement.get(i).contientListeSéancesJour(listJourSéanceCherchéPariculiere, j, k) == false) {
                            contientTous = false;
                        }
                    }

                    if (contientTous) {
                        listeCinémaTrouvés.add(listeEtablissement.get(i));
                        System.out.println("Le cinéma: " + listeEtablissement.get(i).getIdentifiant() + "a des Séances coresspondantes a toutes les dates demandées");
                    }
                    if (contient) {
                        listeCinémaTrouvés.add(listeEtablissement.get(i));
                        System.out.println("Le cinéma: " + listeEtablissement.get(i).getIdentifiant() + ", a au moins une Séance aux dates demandées");
                    }
                }
            }
        }
        if (demandeUtilisateur == 2) {
            for (int i = 0; i < nombreJour; i++) {
                System.out.println("Entrer le numéro du mois: ");
                int moisCCherché = sc.nextInt();
                while (moisCCherché < 1 || moisCCherché > 12) {
                    System.out.println("Veuillez saisir une nouvelle fois le numéro du mois: ");
                    System.out.println("Il doit etre compris entre 1 et 12");
                    moisCCherché = sc.nextInt();
                }
                listJourSéanceCherchéPariculiere.add(moisCCherché);
            }
            for (int i = 0; i < listeEtablissement.size(); i++) {
                for (int j = 0; j < listeEtablissement.get(i).getListeSeances().size(); j++) {
                    for (int k = 0; k < listJourSéanceCherchéPariculiere.size(); k++) {

                        if (listeEtablissement.get(i).contientListeSéancesMois(listJourSéanceCherchéPariculiere, j, k)) {
                            contient = true;
                        }
                        if (listeEtablissement.get(i).contientListeSéancesMois(listJourSéanceCherchéPariculiere, j, k) == false) {
                            contientTous = false;
                        }
                    }

                    if (contientTous) {
                        listeCinémaTrouvés.add(listeEtablissement.get(i));
                        System.out.println("Le cinéma: " + listeEtablissement.get(i).getIdentifiant() + "a des Séances coresspondantes a toutes les dates demandées");
                    }
                    if (contient) {
                        listeCinémaTrouvés.add(listeEtablissement.get(i));
                        System.out.println("Le cinéma: " + listeEtablissement.get(i).getIdentifiant() + ", a au moins une Séance aux dates demandées");
                    }
                }
            }
        }
        if (demandeUtilisateur == 3) {
            for (int i = 0; i < nombreJour; i++) {
                System.out.println("Entrer l'année: ");
                int annéeCCherché = sc.nextInt();
                while (annéeCCherché < 2022 || annéeCCherché > 2025) {
                    System.out.println("Veuillez saisir une nouvelle fois l'année: ");
                    annéeCCherché = sc.nextInt();
                }
                listJourSéanceCherchéPariculiere.add(annéeCCherché);
            }
            for (int i = 0; i < listeEtablissement.size(); i++) {
                for (int j = 0; j < listeEtablissement.get(i).getListeSeances().size(); j++) {
                    for (int k = 0; k < listJourSéanceCherchéPariculiere.size(); k++) {

                        if (listeEtablissement.get(i).contientListeSéancesAnnée(listJourSéanceCherchéPariculiere, j, k)) {
                            contient = true;
                        }
                        if (listeEtablissement.get(i).contientListeSéancesAnnée(listJourSéanceCherchéPariculiere, j, k) == false) {
                            contientTous = false;
                        }
                    }

                    if (contientTous) {
                        listeCinémaTrouvés.add(listeEtablissement.get(i));
                        System.out.println("Le cinéma: " + listeEtablissement.get(i).getIdentifiant() + "a des Séances coresspondantes a toutes les dates demandées");
                    }
                    if (contient) {
                        listeCinémaTrouvés.add(listeEtablissement.get(i));
                        System.out.println("Le cinéma: " + listeEtablissement.get(i).getIdentifiant() + ", a au moins une Séance aux dates demandées");
                    }
                }
            }
        }
        return listeCinémaTrouvés;
    }

    public void listeCinémaTrouvésAfficher(List<Cinéma> listeCinémaTrouvés) {
        //affichage de la liste 
        for (int cpt = 0; cpt < listeCinémaTrouvés.size(); cpt++) {
            System.out.println(listeCinémaTrouvés.get(cpt).ToString());

        }
        System.out.println("nombre de Cinéma trouvés: " + listeCinémaTrouvés.size());
        System.out.println("");
        System.out.println("");
    }
    public void ajouterFilm(){
        Scanner sc= new Scanner(System.in);
        String titre; 
        System.out.println("Entrer le titre: ");
        titre=sc.nextLine();
        String genre;
        System.out.println("Entrer le genre: ");
        genre=sc.nextLine();
        
        List<String> ListeAct= new ArrayList<>();;
        String acteur;
         boolean okk=true;
        System.out.println("Entrez un par un les acteur du film  ");
        while(okk){
        acteur=sc.nextLine();
        ListeAct.add(acteur);
        System.out.println("voulez vous rajouter des film: 1 pour oui 2 pour non");
        int rep = sc.nextInt();
        if(rep==2){
            okk=false;
        }
        }
        String acte = String.join(",", ListeAct);
        System.out.println(acte);
        String real;
        System.out.println("Entrer le réalisateur: ");
        real=sc.nextLine();
        String résumé; 
        System.out.println("Entrer le résumé: ");
        résumé=sc.nextLine();
        float notePresse;
        System.out.println("Entrer le notePresse: ");
        notePresse=sc.nextFloat();
      
boolean ok = true;
System.out.println("Entrez un par un les lieux dans lesquels le film va être diffusé ");
List<String> CineDispo = new ArrayList<>();
List<String> LieuxProjections = new ArrayList<>();
String ville;
while (ok) {
    String cinema = "cinema.txt"; // Nom du fichier à lire

    try (BufferedReader br = new BufferedReader(new FileReader(cinema))) {
        String ligne;
        while ((ligne = br.readLine()) != null) {
            // Lire chaque ligne du fichier
            String[] tokens = ligne.split("_"); // Diviser chaque ligne en utilisant le caractère _ comme délimiteur
            ville = tokens[0]; // Extraire le premier élément de chaque ligne qui correspond à la ville
            System.out.println(ville); // Afficher la ville
            CineDispo.add(ville);
        }
    } catch (IOException e) {
        System.err.println("Une erreur s'est produite lors de la lecture du fichier.");
        e.printStackTrace();
    }
    String recherche = sc.nextLine();
    boolean estPresent = false;
    for (String element : CineDispo) {
        if (element.equalsIgnoreCase(recherche)) {
            estPresent = true;
            LieuxProjections.add(recherche);
            break;
        }
    }
    if (!estPresent) {
        System.out.println("Ce lieu n'existe pas.");
    }
    System.out.println("Voulez-vous rajouter des lieux ? Tapez 1 pour oui, 2 pour non");
    int rep = sc.nextInt();
    sc.nextLine(); // consommer le caractère de fin de ligne en attente
    if (rep == 2) {
        ok = false;
    }
}
String lieu = String.join(",", LieuxProjections);
System.out.println(lieu);


        float durée; 
        System.out.println("Entrer le durée: ");
        durée=sc.nextFloat();
        
        System.out.println("Entrer votre dateSortie ");
        
        System.out.println("-Jour  ");
        int jourNaissance = sc.nextInt();
        while(jourNaissance<1||jourNaissance>31){
            System.out.println("Veuillez saisir une nouvelle fois votre jour  ");   
            System.out.println("Il doit etre compris entre 1 et 31");
            jourNaissance = sc.nextInt();
        }
        
        System.out.println("-Mois  ");   
        int moisNaissance = sc.nextInt();
        while(moisNaissance<1||moisNaissance>12){
            System.out.println("Veuillez saisir une nouvelle fois votre mois  ");
            System.out.println("Il doit etre compris entre 1 et 12");
            moisNaissance = sc.nextInt();
        }
            
        System.out.println("-Année  ");
        int annéeNaissance = sc.nextInt();
        while(annéeNaissance<1900||annéeNaissance>2023){
            System.out.println("Veuillez saisir une nouvelle fois votre année  ");   
            annéeNaissance = sc.nextInt();
        }
        LocalDate dateSortie = LocalDate.of(annéeNaissance,moisNaissance,jourNaissance);
        String n = String.valueOf(jourNaissance);
        String m = String.valueOf(moisNaissance);
        String a = String.valueOf(annéeNaissance);
        String datee ;
        datee = n + "/" + m + "/" + a;
        System.out.println("Entrer le ID: ");
        int ID=sc.nextInt();
        
         
        String texteAEcrire =titre+"_"+genre+"_"+datee+"_"+acte+"_"+real+"_"+résumé+"_"+notePresse+"_"+durée+"_"+lieu+"_"+ID ;

        try {
            String film = "films.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(film, true));
            writer.newLine(); // Sauter une ligne
            writer.write(texteAEcrire);
            writer.close();
           // System.out.println("Le texte a été ajouté au fichier.");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de l'écriture du fichier.");
            e.printStackTrace();
        }
        
       
    }
    
    public void ajouterSeance(){
        Scanner sc= new Scanner(System.in);
        System.out.println("ajoutez une sceance sous la forme :08/03/2023_180_idfilm,idfilm2_séance1_7,15,20_13h01min,18h00min ");
        String texteAEcrire=sc.nextLine();
       
            try {
            String film = "seance.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(film, true));
            writer.newLine(); // Sauter une ligne
            writer.write(texteAEcrire);
            writer.close();
           // System.out.println("Le texte a été ajouté au fichier.");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de l'écriture du fichier.");
            e.printStackTrace();
        }
        
        
    }
    
    
    public void ajouerCinema(){
        Scanner sc= new Scanner(System.in);
        System.out.println("ecrivez la ville du cinema");
        String ville=sc.nextLine();
        System.out.println("ecrivez l'ID du cinema");
        String ID=sc.nextLine();
        System.out.println("ecrivez la note de la presse");
        Float Note=sc.nextFloat();
         List<String> ListeIDfilm= new ArrayList<>();
        String acteur;
         boolean okk=true;
        System.out.println("Entrez un par un les id des film  ");
        while(okk){
        acteur=sc.nextLine();
        ListeIDfilm.add(acteur);
        System.out.println("voulez vous rajouter des id de film: 1 pour oui 2 pour non");
        int rep = sc.nextInt();
        if(rep==2){
            okk=false;
        }
        }
        String acte = String.join(",", ListeIDfilm);
        System.out.println(acte);
        List<String> ListeIDseance= new ArrayList<>();
        String scc;
         boolean okkk=true;
        System.out.println("Entrez un par un les id des film  ");
        while(okk){
        scc=sc.nextLine();
        ListeIDseance.add(scc);
        System.out.println("voulez vous rajouter des id de film: 1 pour oui 2 pour non");
        int rep = sc.nextInt();
        if(rep==2){
            okkk=false;
        }
        }
        String idseance = String.join(",", ListeIDseance);
       
        
         String texteAEcrire =ville+"_"+ID+"_"+Note+"_"+acte+"_"+idseance ;
          try {
            String film = "cinema.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(film, true));
            writer.newLine(); // Sauter une ligne
            writer.write(texteAEcrire);
            writer.close();
           // System.out.println("Le texte a été ajouté au fichier.");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de l'écriture du fichier.");
            e.printStackTrace();
        }
        
    }
    }

        
    

