
package projet2019;


import java.util.ArrayList;
import java.util.Calendar;


public class AnneeUniversitaire {
public static ArrayList<String>anneeUniv;
 
public  static int anneeCourante = Calendar.getInstance().get(Calendar.YEAR);

public static ArrayList anneeUniv(){
   
 anneeUniv = new ArrayList<>();

 anneeUniv.add("2018-2019");
 
 return anneeUniv;
}
  

}
