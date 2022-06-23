package Clase_Obiecte;

/**
 * @author      Ioana Morariu 
 * @version     1.0                 (current version number of program)	
 */
public class Data {
	int zi, luna;
	int an;


	/**
	 * Constructor explicit - task-urile gata
	 * @param zi - ziua 
	 * @param luna - luna
	 * @param an - anul
	 */
	public Data(int zi, int luna, int an) {
		super();
		this.zi = zi;
		this.luna = luna;
		this.an = an;
	}

	/**
	 * Metode de get() pentru zi  
	 * @return zi - ziua                     
	 */
	public int getZi() {
		return zi;
	}
	
	/**
	 * Metode de set() pentru zi   
	 * @param zi -ziua aleasa                    
	 */
	public void setZi(int zi) {
		this.zi = zi;
	}

	/**
	 * Metode de get() pentru luna  
	 * @return luna - luna                     
	 */
	public int getLuna() {
		return luna;
	}

	/**
	 * Metode de set() pentru luna 
	 * @param luna -lunea aleasa                      
	 */
	public void setLuna(int luna) {
		this.luna = luna;
	}

	/**
	 * Metode de get() pentru an   
	 * @return an - anul                   
	 */
	public int getAn() {
		return an;
	}

	/**
	 * Metode de set() pentru an  
	 * @param an - anul ales                    
	 */
	public void setAn(int an) {
		this.an = an;
	}

	/**
	 * Metoda de afisare toString()   
	 * @return afisare - data                 
	 */
	@Override
	public String toString() {
		String afisare = zi+"/"+luna+"/"+an;
		return afisare;
	}
	
}
