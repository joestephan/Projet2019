/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet2019;

import java.util.ArrayList;

public class Specialite {

    public static ArrayList<String> titreSpec;

    public static ArrayList titreSpecialite() {

        titreSpec = new ArrayList<>();
        titreSpec.add("Economie et Gestion");
        titreSpec.add("Electro-Mécanique");
        titreSpec.add("Electronique");
        titreSpec.add("Energétique");
        titreSpec.add("Génie Civil");
        titreSpec.add("Génie des Procedes");
        titreSpec.add("Génie Urbain");
        titreSpec.add("Informatique");
        titreSpec.add("Mécanique");
        titreSpec.add("Statistique");
        titreSpec.add("Telecommunications");

        return titreSpec;
    }

}
