package Clase_Obiecte;
/**
 * @author      Ioana Morariu 
 * @version     1.0                 (current version number of program)	
 */
public class TaskP {
	int idTask;
	int idUtl;
	String numeTask;
	String descriereTask;
	Data dataprimire;
    Data datatermen;
	boolean stareTask=false;
	

	/**
	 * Constructor explicit - task-urile care inca nu sunt completate
	  * @param idTask - id-ul taskului
	  * @param idUtl - id-ul utilizatorui
	  * @param numeTask - nume task
	  * @param descriereTask - descriere task
	  * @param dataprimire - data primirii taskului 
      * @param datatermen - data termenului limita de rezolvare
	 */
	public TaskP(int idTask,int idUtl, String numeTask, String descriereTask, Data dataprimire, Data datatermen) {
		//super();
		this.idTask = idTask;
		this.idUtl= idUtl;
		this.numeTask = numeTask;
		this.descriereTask = descriereTask;
		this.dataprimire = dataprimire;
		this.datatermen = datatermen;
		this.stareTask = false;
	}

	/**
	 * Metode de get() pentru id    
	 * @return idTask  - id-ul taskului               
	 */
	public int getIdTask() {
		return idTask;
	}

	/**
	 * Metode de set() pentru id  
	 * @param  idTask - id-ul dorit                     
	 */
	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}

	/**
	 * Metode de get() pentru numele taskului 
	 * @return  numeTask - numele                     
	 */
	public String getNumeTask() {
		return numeTask;
	}

	/**
	 * Metode de set() pentru numele taskului     
	 * @param  numeTask  - numele task-ului         
	 */
	public void setNumeTask(String numeTask) {
		this.numeTask = numeTask;
	}

	/**
	 * Metode de get() pentru descrierea taskului 
	 * @return descriereTask - descrierea                      
	 */
	public String getDescriereTask() {
		return descriereTask;
	}

	/**
	 * Metode de set() pentru descrierea taskului  
	 * @param descriereTask - descrierea            
	 */
	public void setDescriereTask(String descriereTask) {
		this.descriereTask = descriereTask;
	}

	/**
	 * Metode de get() pentru data primirii task-ului   
	 * @return dataprimire - data primirii                   
	 */
	public Data getDataprimire() {
		return dataprimire;
	}
	
	/**
	 * Metode de set() pentru data primirii task-ului   
	 * @param dataprimire - data aleasa ca data primirii            
	 */
	public void setDataprimire(Data dataprimire) {
		this.dataprimire = dataprimire;
	}

	/**
	 * Metode de get() pentru data termenului limita a task-ului    
	 * @return datatermen -  data termenului limita         
	 */
	public Data getDatatermen() {
		return datatermen;
	}

	/**
	 * Metode de set() pentru data termenului limita a task-ului
	 * @param datatermen - data aleasa ca termen limita                     
	 */
	public void setDatatermen(Data datatermen) {
		this.datatermen = datatermen;
	}

	/**
	 * Metode de get() pentru stare  
	 * @return  stareTask - starea true/false               
	 */
	public boolean getStareTask() {
		return stareTask;
	}

	/**
	 * Metode de set() pentru stare  
	 * @param  stareTask - starea dorita               
	 */
	public void setStareTask(boolean stareTask) {
		this.stareTask = stareTask;
	}
	
	
	
	/**
	 * Metoda de afisare toString()   
	 * @return task -  afisarea task-ului                      
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
