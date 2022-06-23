package Clase_Obiecte;

/**
 * @author      Ioana Morariu 
 * @version     1.0                 (current version number of program)	
 */
public class TaskG extends TaskP {
	 float timprezolvare;
	 Data datarezolvare;
	
		/**
		 * Constructor explicit - task-urile gata
		 * @param idTask - id-ul taskului
		 * @param idUtl - id-ul utilizatorui
		 * @param numeTask - nume task
		 * @param descriereTask - descriere task
		 * @param dataprimire - data primirii taskului 
		 * @param datatermen - data termenului limita de rezolvare
		 * @param timprezolvare - tipul acordat rezolvarii
		 * @param datarezolvare - data de rezolvare a taskului
		 * 
		 */
	public TaskG(int idTask,int idUtl, String numeTask, String descriereTask, Data dataprimire, Data datatermen,
		float timprezolvare, Data datarezolvare) {
		super(idTask, idUtl, numeTask, descriereTask, dataprimire, datatermen);
		this.timprezolvare = timprezolvare;
		this.datarezolvare = datarezolvare;
		this.stareTask=true;
	}


	/**
	 * Metode de get() pentru timpul de rezolvare    
	 * @return timprezolvare - tipul acordat rezolvarii              
	 */
	public float getTimprezolvare() {
		return timprezolvare;
	}

	/**
	 * Metode de set() pentru timpul de rezolvare   
	 * @param timprezolvare - timpul ales pt rezolvarea taskului                  
	 */
	public void setTimprezolvare(int timprezolvare) {
		this.timprezolvare = timprezolvare;
	}

	/**
	 * Metode de get() pentru data rezolvarii    
	 * @return datarezolvare - data de rezolvare a taskului           
	 */
	public Data getDatarezolvare() {
		return datarezolvare;
	}

	/**
	 * Metode de get() pentru data rezolvarii  
	 * @param datarezolvare - data aleasa pt rezolvarea taskului      
	 */
	public void setDatarezolvare(Data datarezolvare) {
		this.datarezolvare = datarezolvare;
	}

	/**
	 * Metoda de afisare toString()  
	 * @return task - afisarea taskului                       
	 */
	public String toString() {
		String task="";
		if(idTask<10)
			task="Id: "+idTask+"          Nume:"+numeTask;
		else if(idTask>9&&idTask<100)
			task= "Id: "+idTask+"        Nume:"+numeTask;
		else
			task="Id: "+idTask+"      Nume:"+numeTask;
		return task;
	}
	
}
