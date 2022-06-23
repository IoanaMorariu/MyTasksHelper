package Interfete_app;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
//import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Clase_Obiecte.Data;
import Clase_Obiecte.TaskG;
import Clase_Obiecte.TaskP;
import Clase_Obiecte.Utilizator;

/**
 * @author      Ioana Morariu 
 * @version     1.0                 (current version number of program)	
 */
public class PaginaLogare implements ActionListener {
	
	
	JFrame frame= new JFrame();
	JButton loginButton=new JButton("Conectare");
	JButton resetButton=new JButton("Stergere");
	JTextField numeID = new JTextField();
	JPasswordField parolaID=new JPasswordField();
	JLabel userLb= new JLabel("Nume/ID: ");
	JLabel parolaLb= new JLabel("Parola: ");
	JLabel mesaj = new JLabel();
	JLabel titlu= new JLabel("Intra in contul tau:");
	JLabel poza=new JLabel();
	HashMap<String,String> logare = new HashMap<String,String>();
	List <Utilizator> lista_utl=new ArrayList<>();
	
	JButton nou=new JButton("Creeza cont");
	
	/**
	 * Constructor pentru pagina de logare
	 * @param cont - HashMap cu perechile de nume si parole
	 * @param lista_utilizatori - listele cu utilizatori
	 */
	public PaginaLogare(HashMap<String,String> cont,List <Utilizator> lista_utilizatori ){
		
		logare=cont;
		lista_utl=lista_utilizatori;
		
		
		userLb.setBounds(63,120,75,25);
		parolaLb.setBounds(75,170,75,25);
		poza.setBounds(50,300,75,25);
		
		
		mesaj.setBounds(125,230,300,35);
		mesaj.setFont(new Font(null,Font.BOLD,17));
		titlu.setBounds(50,70,300,35);
		titlu.setFont(new Font(null,Font.ITALIC,22));
		
		numeID.setBounds(125,120,200,25);
		parolaID.setBounds(125,170,200,25);
		Image robot1=(new ImageIcon("D://01 - Facultate//Anul 2//P3//Proiect_Ioana_Morariu//MyTasksHelper//IMAGINI//1.png")).getImage();
		poza.setIcon(new ImageIcon(robot1));
		poza.setBounds(50,260,311,201);
		frame.getContentPane().add(poza);
		
		loginButton.setBounds(125,210,100,25);
		loginButton.setFocusable(false);  // sa nu mai apara patratica aia acolo
		loginButton.addActionListener(this);
		Color c1= new Color(230, 247, 255);
		loginButton.setBackground(c1);
		resetButton.setBounds(225,210,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		resetButton.setBackground(c1);
		
		frame.add(titlu);
		frame.add(userLb);frame.add(parolaLb);frame.add(mesaj);
		frame.add(numeID);frame.add(parolaID);
		frame.add(loginButton);frame.add(resetButton);
	
		nou.setBounds(280,15,110,25);
		nou.setFocusable(false);  // sa nu mai apara patratica aia acolo
		nou.addActionListener(this);
		Color c3= new Color(255, 153, 194);
		nou.setBackground(c3);
		frame.add(nou);
		
		Color c2= new Color(153, 221, 255);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,495);
		frame.getContentPane().setBackground(c2);
		frame.setLayout(null);
		frame.setVisible(true);	
		frame.setLocation(400, 120);
		
	}


	/**
	 * Metoda care realizeaza actiuni in urma apasarii pe anumite elemente din "pagina"                      
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==resetButton) {
			numeID.setText("");
			parolaID.setText("");
		}
		
		Color c1= new Color(179, 0, 0);
		if(e.getSource()==loginButton) {
			String nume=numeID.getText();
			String pass= String.valueOf(parolaID.getPassword());
			if(logare.containsKey(nume)) {
				if(logare.get(nume).equals(pass)) {
					Utilizator x=null;
					for(Utilizator i: lista_utl)
						if(i.getNumeUTL().equals(nume)&&i.getParolaUTL().equals(pass))
							x=i;
					x=CitireBD_liste(x);
					
					MeniuPrincipal meniu=new MeniuPrincipal(x,lista_utl);
					frame.setVisible(false);
				}
				else {
					mesaj.setForeground(c1);
					mesaj.setText("* parola gresita/lipseste!");
				}
			}
			
			else {
				mesaj.setForeground(c1);
				mesaj.setText("* utilizatorul neidentificat!");
			}
		}
		
		if(e.getSource()==nou) {
			Cont_Nou meniu=new Cont_Nou(logare,lista_utl);
			frame.setVisible(false);
		}
		
	}
	
	
	/**
	 * Functie pentru citirea din baza de date a taskurilor si returneaza un utilizatorul impreuna cu taskurile sale
	 *  @param  UTILIZATOR - utilizatorul care are taskurile              
	 *  @return  UTILIZATOR - utilizatorul care are taskurile 
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
