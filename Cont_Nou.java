package Interfete_app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Cont_Nou implements ActionListener{
	JFrame frame= new JFrame();
	HashMap<String,String> logare = new HashMap<String,String>();
	List <Utilizator> lista_utl=new ArrayList<>();
	
	JLabel titlu= new JLabel("Creare cont");
	JTextField nume = new JTextField();
	JPasswordField parola=new JPasswordField();
	JPasswordField confirmareparola = new JPasswordField();
	JTextField mail=new JTextField();
	JLabel userLb= new JLabel("Nume/ID: ");
	JLabel parolaLb= new JLabel("Parola: ");
	JLabel confparolaLb= new JLabel("Confirmare: ");
	JLabel mailLb= new JLabel("E-mail: ");
	JLabel errmesaj = new JLabel("");
	JLabel robot1= new JLabel();
	JButton inapoi=new JButton("<- Inapoi");

	JButton loginButton=new JButton("Conectare");
	
	/**
	 * Constructor pentru pagina de creare a unui utilizator
	 * @param cont - HashMap cu perechile de nume si parole
	 * @param lista_utilizatori - listele cu utilizatori
	 */
	public Cont_Nou(HashMap<String,String> cont,List <Utilizator> lista_utilizatori) {
		
		logare=cont;lista_utl=lista_utilizatori;
		Color c3= new Color(255, 255, 153);
		inapoi.setBounds(15,10,90,20);
		inapoi.setFont(new Font(null,Font.BOLD,12));
		inapoi.setFocusable(false);
		inapoi.addActionListener(this);
		inapoi.setBackground(c3);
		frame.add(inapoi);
		
		titlu.setBounds(120,75,170,35);
		titlu.setFont(new Font(null,Font.ITALIC,22));
		frame.add(titlu);
		userLb.setBounds(63,150,75,25);
		frame.add(userLb);
		parolaLb.setBounds(63,200,75,25);
		frame.add(parolaLb);
		confparolaLb.setBounds(63,250,75,25);
		frame.add(confparolaLb);
		mailLb.setBounds(63,300,75,25);
		frame.add(mailLb);
		
		nume.setBounds(125,150,155,25);
		parola.setBounds(110,200,170,25);
		confirmareparola.setBounds(135,250,185,25);
		mail.setBounds(110,300,155,25);
		frame.add(nume);frame.add(parola);frame.add(confirmareparola);frame.add(mail);
		
		loginButton.setBounds(205,350,100,40);
		loginButton.setFocusable(false);  // sa nu mai apara patratica aia acolo
		loginButton.addActionListener(this);
		Color c1= new Color(230, 247, 255);
		loginButton.setBackground(c1);
		frame.add(loginButton);
		
		Color c7= new Color(179, 0, 0);
		errmesaj.setBounds(85,400,300,35);
		errmesaj.setFont(new Font(null,Font.BOLD,17));
		errmesaj.setForeground(c7);
		frame.add(errmesaj);
		
		Image img=(new ImageIcon("D://01 - Facultate//Anul 2//P3//Proiect_Ioana_Morariu//MyTasksHelper//IMAGINI//222.png")).getImage();
		robot1.setIcon(new ImageIcon(img));
		robot1.setBounds(280,20,120,110);
		frame.getContentPane().add(robot1);
		
		
		Color c2= new Color(160, 230, 255);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,520);
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
		if(e.getSource()==loginButton) {
			errmesaj.setText("");
			String numeutliz=nume.getText();
			String pass=parola.getText();
			String pass2=confirmareparola.getText();
			String mailutl=mail.getText();
			if(!numeutliz.equals("")) {
				if(!logare.containsKey(numeutliz)) {
					if(!pass.equals("")) {
						if(!pass2.equals("")){
							if(pass.equals(pass2)) {
								if(!mailutl.equals("")) {
									AdaugareUtilizator(numeutliz,pass,mailutl);
									Utilizator x=GasireUtilizator(numeutliz);
									lista_utl.add(x);
									MeniuPrincipal meniu=new MeniuPrincipal(x,lista_utl);
									frame.setVisible(false);
								}else errmesaj.setText("* nu ai completat e-mailul");
							}else errmesaj.setText("* Confirmarea parolei este incorecta");
						}else errmesaj.setText("* nu confirmat parola");
					}else errmesaj.setText("* nu ai completat parola");
				}else errmesaj.setText("* exista utililizator cu acest nume");
			}else errmesaj.setText("* nu ai completat numele");
		}
		
		if(e.getSource()==inapoi) {
			PaginaLogare meniu=new PaginaLogare(logare,lista_utl);
			frame.setVisible(false);
			
		}
	}
	
	/**
	 * Functie pentru cautarea utilizatorului din baza de date
	 *  @param numele - numele utilizatorului
	 *  @return gasit - utilizatorul introdus nou                  
	 */
	public static Utilizator GasireUtilizator(String numele) {
		Utilizator gasit=null;
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
				
				if(numele.equals(nume))
					{ 
						Utilizator g=new Utilizator(id,nume,parola,mail,lista_completate,list_necompletate);
						gasit=g;
					}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return gasit;
	}
	
	
	/**
	 * Functie pentru cadaugarea utilizatorului in baza de date 
	 *  @param nume - numele utilizatorului  
	 *  @param parola - parola utilizatorului 
	 *  @param mail -  adresa de e-mail a utilizatorului 
	 */
	public static void AdaugareUtilizator(String nume, String parola, String mail) {

		String jdbcURL1="jdbc:derby:Baza_de_date_PROIECT";
		try {
			Connection con= DriverManager.getConnection(jdbcURL1);
			Statement st = con.createStatement();
			System.out.println("Succes ------> conectare");
			String sql="Insert into Utilizator (NUME,PAROLA,MAIL) values ('"+nume+"' ,'"+parola+"' ,'"+mail+"' )";
			System.out.println(sql);
			int rand= st.executeUpdate(sql);
			if(rand>0) {
				System.out.println("Randul a fost pus in tabel");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
