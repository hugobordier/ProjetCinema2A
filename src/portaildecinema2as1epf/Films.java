/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portaildecinema2as1epf;

import java.time.LocalDate;
import java.util.List;

public class Films {

    private String titre;
    private String genres;
    private LocalDate dateSortie;
    private List<String> listeAct;
    private String real;
    private String résumé;
    private float notePresse;
    private List<String> lieuxProjections;
    private float durée;
    private String identifiant;

    public Films(String valtitre, String valgenres, LocalDate valdateSortie, List<String> valListeAct, String valreal, String valrésumé, float valnotePresse, List<String> valLieuxProjections, float valdurée, String valid) {
        titre = valtitre;
        genres = valgenres;
        dateSortie = valdateSortie;
        real = valreal;
        résumé = valrésumé;
        notePresse = valnotePresse;
        durée = valdurée;
        identifiant = valid;
        listeAct = valListeAct;
        lieuxProjections = valLieuxProjections;
    }

    public String ToString() {
        return ("titre: " + this.titre
                + "| genres: " + this.genres
                + "| date de Sortie: " + this.dateSortie
                + "| realisateur: " + this.real
                + "| résumé: " + this.résumé
                + "| note de la Presse: " + this.notePresse
                + "| durée: " + this.durée
                + "| identifiant: " + this.identifiant
                + "| liste des Acteurs: " + this.listeAct
                + "| lieux de Projections: " + this.lieuxProjections);
    }

    public String getTitre() {
        return titre;
    }
    public boolean contientTitre(String titreCherché) {
        return titre.toUpperCase().contains(titreCherché);
    }
    
    public String getGenre() {
        return genres;
    }
    public boolean contientGenre(String genreCherché) {
        return genres.toUpperCase().contains(genreCherché);
    }

    public String getReal() {
        return real;
    }
    public boolean contientReal(String realCherché) {
        return real.toUpperCase().contains(realCherché);
    }

    public String getIdentifiantF() {
        return identifiant;
    }
    public boolean contientIdF(String idCherché) {
        return identifiant.toUpperCase().contains(idCherché);
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }
    public boolean contientdateSortieParticuliere(LocalDate dateSortieCherché) {
        return dateSortie.equals(dateSortieCherché);
    }
    public boolean contientdateSortieNuméroJour(int dateSortieCherché) {
        return dateSortie.getDayOfMonth()== dateSortieCherché;
    }
    public boolean contientdateSortieAnnée(int dateSortieCherché) {
        return dateSortie.getYear() == dateSortieCherché;
    }
    public boolean contientdateSortieMois(int dateSortieCherché) {
        return dateSortie.getMonth().getValue()==(dateSortieCherché);
    }

    public String getRésumé() {
        return résumé;
    }
    public boolean contientRésumé(String résuméCherché) {
        return résumé.toUpperCase().contains(résuméCherché);
    }

    public float getNotePresse() {
        return notePresse;
    }
    public boolean contientNotePresseEgale(float notePresseCherché) {
        return notePresse == notePresseCherché;
    }
    public boolean contientNotePresseInf(float notePresseCherché) {
        return notePresse <= notePresseCherché;
    }
    public boolean contientNotePresseSup(float notePresseCherché) {
        return notePresse >= notePresseCherché;
    }

    public float getDurée() {
        return durée;
    }
    public boolean contientDuréeEgale(float DuréeCherché) {
        return durée == DuréeCherché;
    }
    public boolean contientDuréeInf(float DuréeCherché) {
        return durée <= DuréeCherché;
    }
    public boolean contientDuréeSup(float DuréeCherché) {
        return durée >= DuréeCherché;
    }

    public List<String> getLieuxProjections() {
        return lieuxProjections;
    }
    public boolean contientgetlieuxProj(List<String> listelieuxProjCherché, int i) {
        return lieuxProjections.contains(listelieuxProjCherché.get(i));
    }

    public List<String> getListeAct() {
        return listeAct;
    }
    public boolean contientgetListeAct(List<String> listeActCherché, int j) {
        return listeAct.contains(listeActCherché.get(j));
    }

}