import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Clase_Obiecte.Data;
import Clase_Obiecte.TaskG;
import Clase_Obiecte.TaskP;
import Clase_Obiecte.Utilizator;

import java.sql.*;

import Clase_Obiecte.Utilizator;
import Clase_Obiecte.Data;
import Clase_Obiecte.TaskG;
import Clase_Obiecte.TaskP;
import Interfete_app.*;


//import Clase_Obiecte.Utilizator;
/**
 * @author      Ioana Morariu 
 * @version     1.0                 (current version number of program)	
 */
public class Main {
	public static void main(String[] args) {
	
		
		List <Utilizator> lista_utl=new ArrayList<>();
		Baza_de_date_citire a=new Baza_de_date_citire(null) ;
		lista_utl=a.CitireBD_lista_clienti(lista_utl);
		Utilizator UTILIZATOR=lista_utl.get(0);
	
		
		HashMap<String,String> logare= new HashMap<String,String>();
		for(Utilizator utl: lista_utl) {
			logare.put(utl.getNumeUTL(), utl.getParolaUTL());
		}
		
		PaginaLogare paginalogare=new PaginaLogare(logare,lista_utl);
	}
}



