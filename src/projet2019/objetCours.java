/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet2019;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;

/**
 *
 * @author joe-e
 */
class objetCours implements Serializable {

    public static String specialite, anneeUniversitaire, codeC, nomC, anneeAcad, Semestre, Credits, Heures,Frais;
    static int anneeO, anneeA;
    static Collection<Langues> langue;
    

    public objetCours(String anneeUniversitaire, String Specialite, String codeC, String nomC, String anneeAcad, String Semestre, String Credits, String Heures, String Frais) {
        this.anneeUniversitaire = anneeUniversitaire;
        this.specialite = Specialite;
        this.codeC = codeC;
        this.nomC = nomC;
        this.anneeAcad = anneeAcad;
        this.Semestre = Semestre;
        this.Credits = Credits;
        this.Heures = Heures;
        this.Frais = Frais;

    }

}
