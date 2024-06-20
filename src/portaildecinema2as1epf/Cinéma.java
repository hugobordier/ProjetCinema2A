/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portaildecinema2as1epf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class Cinéma {

    private String coordonéesGeo;
    private String identifiant;
    private float noteEtablissement;
    private List<Films> listeFilmsProj;
    private List<Séance> listeSeances;

    public Cinéma(String valcoord, String validCinéma, float valnote, List<Films> valListeFilmsProj, List<Séance> valListeSeances) {
        coordonéesGeo = valcoord;
        identifiant = validCinéma;
        noteEtablissement = valnote;
        listeFilmsProj = valListeFilmsProj;
        listeSeances = valListeSeances;
    }

    public String ToString() {
        return ("coordonées Geographiques: " + this.coordonéesGeo
                + "| identifiant: " + this.identifiant
                + "| note de l'Etablissement: " + this.noteEtablissement
                + "| liste des Films Projetés: " + this.listeFilmsProj
                + "| liste des Seances: " + this.listeSeances);
    }
    
    public String getCoordonéesGeo() {
        return coordonéesGeo;
    }
    public boolean contientCoordonéesGeo(String CoordonéesGeoCherché) {
        return coordonéesGeo.toUpperCase().contains(CoordonéesGeoCherché);
    } 
    
    public String getIdentifiant() {
        return identifiant;
    }
    public boolean contientIdC(String idCherché) {
        return identifiant.toUpperCase().contains(idCherché);
    }
    
   public float getNoteEtablissement() {
        return noteEtablissement;
    }
    public boolean contientNoteEtablissementEgale(float noteEtablissementCherché) {
        return noteEtablissement == noteEtablissementCherché;
    }
    public boolean contientNoteEtablissementInf(float noteEtablissementCherché) {
        return noteEtablissement <= noteEtablissementCherché;
    }
    public boolean contientNoteEtablissementSup(float noteEtablissementCherché) {
        return noteEtablissement >= noteEtablissementCherché;
    }    
    public List<Films> getListeFilmsProj() {
        return listeFilmsProj;
    }
    public boolean contientListeFilmsProj(List<String> listFilmsCherché, int j, int k) {
        return listeFilmsProj.get(j).getTitre().contains(listFilmsCherché.get(k));
    }

    public List<Séance> getListeSeances() {
        return listeSeances;
    }
    public boolean contientListeSéancesDate(List<LocalDate> listSéancesDateCherché, int j, int k) {
        return listeSeances.get(j).getDateJour().equals(listSéancesDateCherché.get(k));
    }
    public boolean contientListeSéancesJour(List<Integer> listSéancesJourCherché, int j, int k) {
        return listeSeances.get(j).getDateJour().getDayOfMonth()==listSéancesJourCherché.get(k);
    }   
    public boolean contientListeSéancesMois(List<Integer> listSéancesMoisCherché, int j, int k) {
        return listeSeances.get(j).getDateJour().getMonth().getValue()==(listSéancesMoisCherché.get(k));
    }
    public boolean contientListeSéancesAnnée(List<Integer> listSéancesAnnéeCherché, int j, int k) {
        return listeSeances.get(j).getDateJour().getYear()==listSéancesAnnéeCherché.get(k);
    }

}