/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portaildecinema2as1epf;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class Séance {

    private LocalDate jour;
    private float Durée;
    private Films films;
    private String identifiant;
    private List<Float> tarifs;
    private List<String> horaires;

    public Séance(LocalDate valJour, float valDurée, Films valFilms, String valIdSéance, List<Float> valTarifs, List<String> valHoraires) {
        jour = valJour;
        Durée = valDurée;
        films = valFilms;
        identifiant = valIdSéance;
        tarifs = valTarifs;
        horaires = valHoraires;
    }

    public String ToString() {
        return ("jour: " + this.jour
                + "| heure: " + this.Durée
                + "| films: " + this.films
                + "| identifiant: " + this.identifiant
                + "| tarifs: " + this.tarifs
                + "| horaires: " + this.horaires);
    }

    public String getIdentifiant() {
        return identifiant;
    }
    public boolean contientIdS(String idCherché) {
        return identifiant.toUpperCase().contains(idCherché);
    }

    
    
    public float getDuréeS() {
        return Durée;
    }
    public boolean contientDuréeSEgale(float DuréeCherché) {
        return Durée == DuréeCherché;
    }
    public boolean contientDuréeSInf(float DuréeCherché) {
        return Durée <= DuréeCherché;
    }
    public boolean contientDuréeSSup(float DuréeCherché) {
        return Durée >= DuréeCherché;
    }

    
    
    public LocalDate getDateJour() {
        return jour;
    }
    public boolean contientdateSéance(LocalDate dateJourCherché) {
        return jour.equals(dateJourCherché);
    }    
    public boolean contientdateSéanceNuméroJour(int dateSortieCherché) {
        return jour.getDayOfMonth()==(dateSortieCherché);
    }
    public boolean contientdateSéanceNuméroMois(int dateSortieCherché) {
        return jour.getMonth().getValue()==(dateSortieCherché);
    }
    public boolean contientdateSéanceAnnée(int dateSortieCherché) {
        return jour.getYear()==(dateSortieCherché);
    }
    
    
    
    public Films getfilms() {
        return films;
    }
    public boolean contientfilm(String FilmCherché) {
        return films.getTitre().contains(FilmCherché);
    }
    
    
    
    public List<Float> getTarifs() {
        return tarifs;
    }

    
    
    public List<String> getHoraires() {
        return horaires;
    }
}