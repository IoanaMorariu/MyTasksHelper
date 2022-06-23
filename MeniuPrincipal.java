package Interfete_app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//import Clase_Obiecte.TaskG;
import Clase_Obiecte.Utilizator;
/**
 * @author      Ioana Morariu 
 * @version     1.0                 (current version number of program)	
 */
public class MeniuPrincipal implements ActionListener{
	JFrame frame= new JFrame();
	JButton taskinproces=new JButton("Task-uri in proces");
	JButton taskgata=new JButton("Task-uri finalizate");
	JButton analiza=new JButton("Graficul datelor");
	JLabel titlu= new JLabel("Meniu");
	JLabel robot1= new JLabel();
	Utilizator utilizator;
	List <Utilizator> lista_utl=new ArrayList<>();
	HashMap<String,String> logare= new HashMap<String,String>();
	
	JButton dec=new JButton("Deconecatre");
	
	/**
	 * Constructor pentru pagina cu meniul
	 * @param x - utilizatorul aplicatiei
	 * @param lista_utilizatori - lista de utilizatori
	 */
	public MeniuPrincipal(Utilizator x,List <Utilizator> lista_utilizatori) {
		
		utilizator=x;lista_utl=lista_utilizatori;
		titlu.setBounds(480,70,120,70);
		titlu.setFont(new Font(null,Font.BOLD,35));
		
		Color c10= new Color(230, 247, 255);
		dec.setBounds(10,20,110,20);
		dec.setFocusable(false);
		dec.addActionListener(this);
		dec.setBackground(c10);
		
		Color c1= new Color(230, 247, 255);
		taskinproces.setBounds(380,150,300,70);
		taskinproces.setFocusable(false);
		taskinproces.addActionListener(this);
		taskinproces.setBackground(c1);
		
		taskgata.setBounds(380,250,300,70);
		taskgata.setFocusable(false);
		taskgata.addActionListener(this);
		taskgata.setBackground(c1);
		
		analiza.setBounds(380,350,300,70);
		analiza.setFocusable(false);
		analiza.addActionListener(this);
		analiza.setBackground(c1);
		
		Image img=(new ImageIcon("D://01 - Facultate//Anul 2//P3//Proiect_Ioana_Morariu//MyTasksHelper//IMAGINI//3.png")).getImage();
		robot1.setIcon(new ImageIcon(img));
		robot1.setBounds(110,100,188,361);
		frame.getContentPane().add(robot1);
		
		
		frame.add(titlu);frame.add(dec);
		frame.add(taskinproces);frame.add(taskgata);frame.add(analiza);
		Color c2= new Color(153, 221, 255);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(850,560);
		frame.getContentPane().setBackground(c2);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocation(370, 110);
	}
	
	/**
	 * Metoda care realizeaza actiuni in urma apasarii pe anumite elemente din "pagina"                      
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==dec) {
			
		
			for(Utilizator utl: lista_utl) {
				logare.put(utl.getNumeUTL(), utl.getParolaUTL());
			}
			
			PaginaLogare fereastra2=new PaginaLogare(logare,lista_utl);
			frame.setVisible(false);
		}
		if(e.getSource()==taskgata) {
			Task_Gata_buton2 fereastra2=new Task_Gata_buton2(utilizator,lista_utl);
			frame.setVisible(false);
		}
		
		if(e.getSource()==taskinproces) {
			Task_in_Proces_butonul1 fereastra1=new Task_in_Proces_butonul1(utilizator,lista_utl);
			frame.setVisible(false);
		}
		
		if(e.getSource()==analiza) {
			Analiza_buton3 fereastra3=new Analiza_buton3(utilizator,lista_utl);
			frame.setVisible(false);
		}
	}

}
