import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Clase_Obiecte.Data;
import Clase_Obiecte.TaskG;
import Clase_Obiecte.TaskP;
import Clase_Obiecte.Utilizator;
/**
 * @author      Ioana Morariu 
 * @version     1.0                 (current version number of program)	
 */
public class Baza_de_date_citire {

	/**
	 * Constructor - task-urile zilnice care sunt completate
	 * @param x - utilizatorul din baza de date
	 */
	public Baza_de_date_citire(Utilizator x) {}
	
	
	/**
	 * Functie pentru citirea din baza de date a utilizatorilor   
	 *  @param lista_utilizatori - lista in care o sa fie pusi utilizatorii din baza de date  
	 *  @return   lista_utilizatori - lista de utilizatori dupa citirea din baza de date          
	 */
	public List<Utilizator> CitireBD_lista_clienti(List <Utilizator>lista_utilizatori) {
		List<TaskP> list_necompletate=new ArrayList<TaskP>();
		List<TaskG> lista_completate=new ArrayList<TaskG>();
		String jdbcURL="jdbc:derby:Baza_de_date_PROIECT";
		try {
			Connection connection= DriverManager.getConnection(jdbcURL);
			System.out.println("Succes ------> conectare");
			Statement st = connection.createStatement();
			
			String sql1="select * from Utilizator";  
			ResultSet linie= st.executeQuery(sql1);
			
			while(linie.next()) {
				int id =linie.getInt("id");
				String nume=linie.getString("nume");
				String parola= linie.getString("parola");
				String mail=linie.getString("mail");
				
				System.out.println(id+ " -> "+nume+" -> "+parola+" -> "+mail);
				lista_utilizatori.add(new Utilizator(id,nume,parola,mail,lista_completate,list_necompletate));
			}
			
			/*System.out.println();System.out.println();System.out.println();
			for(Utilizator i: lista_utilizatori) {
				System.out.println(i);
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_utilizatori;
	}
	
	
	/**
	 * Functie pentru citirea din baza de date a taskurilor 
	 *  @param UTILIZATOR - utilizatorul care are taskurile     
	 *  @return UTILIZATOR - utilizatorul cu taskurile completate        
	 */
	public Utilizator CitireBD_liste(Utilizator UTILIZATOR) {
		
		String jdbcURL="jdbc:derby:Baza_de_date_PROIECT";
		try {
			Connection connection= DriverManager.getConnection(jdbcURL);
			System.out.println("Succes ------> conectare");
			Statement st = connection.createStatement();
			
	//idT, idU,nume,descriere,ziprimire,lunaprimire,anprimire,zitermen,lunatermen,antermen,stare,ore,zirezolvare,lunarezolvare,anrezolvare  
			String sql2="select * from Task";  
			ResultSet linie= st.executeQuery(sql2);
			while(linie.next()) {
				int id1 =linie.getInt("idT");
				int id2 =linie.getInt("idU");
				String numeT=linie.getString("nume");
				String desc= linie.getString("descriere");
				int zi1 =linie.getInt("ziprimire");
				int luna1 =linie.getInt("lunaprimire");
				int an1 =linie.getInt("anprimire");
				int zi2 =linie.getInt("zitermen");
				int luna2 =linie.getInt("lunatermen");
				int an2 =linie.getInt("antermen");
				int stare =linie.getInt("stare");
				float ore = linie.getFloat("ore");
				int zi3 =linie.getInt("zirezolvare");
				int luna3 =linie.getInt("lunarezolvare");
				int an3 =linie.getInt("anrezolvare");
				//System.out.println(id1+ " -> "+id2+" -> "+numeT+" -> "+stare);
				if(id2==UTILIZATOR.getIdUTL()) {
						if(stare==0) 
							UTILIZATOR.lista_task_in_proces.add(new TaskP(id1,id2,numeT,desc,new Data(zi1,luna1,an1),new Data(zi2,luna2,an2)));
						else
							UTILIZATOR.lista_task_gata.add(new TaskG(id1,id2,numeT,desc,new Data(zi1,luna1,an1),new Data(zi2,luna2,an2),
									ore,new Data(zi3,luna3,an3)));
					}
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return UTILIZATOR;
	}
	
}
