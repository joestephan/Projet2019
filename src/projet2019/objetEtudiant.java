/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet2019;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;

/**
 *
 * @author joe-e
 */
class objetEtudiant implements Serializable{

    public static String specialite, anneeUniversitaire, numD, nomE, dateN, villeN, sexe, diplome;
    static int anneeO, anneeA;
    static Collection<Langues> langue;
    

    public objetEtudiant(String anneeUniversitaire, String Specialite, String numD, String nomE, String dateN, String villeN, String sexe, String diplome, int anneeO, Collection langue, int anneeA) {
        this.anneeUniversitaire = anneeUniversitaire;
        this.specialite = Specialite;
        this.numD = numD;
        this.nomE = nomE;
        this.dateN = dateN;
        this.villeN = villeN;
        this.sexe = sexe;
        this.diplome = diplome;
        this.anneeO = anneeO;
        this.langue = langue;
        this.anneeA = anneeA;

    }

}
