package Clase_Obiecte;

import java.util.List;


/**
 * @author      Ioana Morariu 
 * @version     1.0                 (current version number of program)	
 */
public class Utilizator {
	int idUTL;
	String numeUTL;
	String parolaUTL;
	String mail;
	public List<TaskG> lista_task_gata;
	public List<TaskP> lista_task_in_proces;
	
	
	/**
	 * Constructor explicit 
	 * @param idUTL -  id-ul utilizatorului
	 * @param numeUTL - numele utilizatorului
	 * @param parolaUTL - parola utilizatorului
	 * @param mail - adresa de e-mail 
	 * @param evenimete_gata - lista cu taskurile sale terminate
	 * @param evenimete_inproces - lista cu taskurile sale in curs de rezolvare
	 */
	public Utilizator(int idUTL, String numeUTL, String parolaUTL,String mail, List<TaskG> evenimete_gata,
			List<TaskP> evenimete_inproces) {
		super();
		this.idUTL = idUTL;
		this.numeUTL = numeUTL;
		this.parolaUTL = parolaUTL;
		this.mail=mail;
		this.lista_task_gata = evenimete_gata;
		this.lista_task_in_proces = evenimete_inproces;
		
	}

	
	/**
	 * Metode de get() pentru id  
	 * @return idUTL - id                      
	 */
	public int getIdUTL() {
		return idUTL;
	}

	/**
	 * Metode de set() pentru id 
	 * @param idUTL - id-ul dorit                        
	 */
	public void setIdUTL(int idUTL) {
		this.idUTL = idUTL;
	}

	/**
	 * Metode de get() pentru nume 
	 * @return numeUTL - numele                    
	 */
	public String getNumeUTL() {
		return numeUTL;
	}

	/**
	 * Metode de set() pentru nume 
	 * @param numeUTL - numele dorit                       
	 */
	public void setNumeUTL(String numeUTL) {
		this.numeUTL = numeUTL;
	}

	/**
	 * Metode de get() pentru parola   
	 * @return parolaUTL - parola                   
	 */
	public String getParolaUTL() {
		return parolaUTL;
	}

	/**
	 * Metode de set() pentru parola  
	 * @param parolaUTL - parola dorita            
	 */
	public void setParolaUTL(String parolaUTL) {
		this.parolaUTL = parolaUTL;
	}

	
	/**
	 * Metoda de afisare toString()   
	 * @return utl - afisarea utilizatorului                      
	 */
	@Override
	public String toString() {
		String utl="";
		utl= "Utilizator [\n\tidUTL=" + idUTL + ", numeUTL=" + numeUTL + ", parolaUTL=" + parolaUTL + ", \n\tevenimete_gata="
				+ lista_task_gata + ", \n\tevenimete_inproces=" + lista_task_in_proces +  "\n]";
		return utl;
	}
	
}
