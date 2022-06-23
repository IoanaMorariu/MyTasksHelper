package Interfete_app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Clase_Obiecte.TaskG;
import Clase_Obiecte.Utilizator;
/**
 * @author      Ioana Morariu 
 * @version     1.0                 (current version number of program)	
 */
public class Analiza_buton3 implements ActionListener{
	JFrame frame= new JFrame();
	Utilizator utilizator;
	JButton inapoi=new JButton("<- Inapoi");
	List <Utilizator> lista_utl=new ArrayList<>();
	JLabel titlu= new JLabel("Analiza taskurilor introduse");
	JLabel inproces= new JLabel("Numarul de taskuri in proces de rezolvare:");
	JLabel gata= new JLabel("Numarul de taskuri finalizate:");
	JLabel timp= new JLabel("Timpul de realizare a unui task:");
	JLabel timpmax= new JLabel("MAXIM:");
	JLabel timpmed= new JLabel("MEDIU:");
	JLabel timpmin= new JLabel("MINIM:");
	JLabel dupatermen= new JLabel("Numarul de taskuri finalizate dupa termen:");
	JLabel robot1= new JLabel();

	
	JTextField c1= new JTextField(25);
	JTextField c2= new JTextField(25);
	JTextField c3= new JTextField(25);
	JTextField c4= new JTextField(25);
	JTextField c5= new JTextField(25);
	JTextField c6= new JTextField(25);

	/**
	 * Constructor pentru pagina de analiza a task-urilor
	 * @param x - utilizatorul aplicatiei
	 * @param lista_utilizatori - lista de utilizatori
	 */
	public Analiza_buton3(Utilizator x,List <Utilizator> lista_utilizatori) {
		
		utilizator=x;lista_utl=lista_utilizatori;
		
		Color culoare2= new Color(160, 230, 255);
		Color culoare3= new Color(255, 255, 153);
		
		
		inapoi.setBounds(15,10,90,20);
		inapoi.setFont(new Font(null,Font.BOLD,12));
		inapoi.setFocusable(false);
		inapoi.addActionListener(this);
		inapoi.setBackground(culoare3);
		frame.add(inapoi);
		titlu.setBounds(200,65,370,30);
		titlu.setFont(new Font(null,Font.PLAIN,25));
		frame.add(titlu);
		
		inproces.setBounds(60,140,370,20);
		inproces.setFont(new Font(null,Font.PLAIN,17));
		frame.add(inproces);
		c1.setBounds(400,138,35,30);
		c1.setFocusable(false);
		int nr1=AnalizaTaskuri_GATA(utilizator);
		c1.setFont(new Font(null,Font.PLAIN,17));
		c1.setText(String.valueOf(nr1));
		frame.add(c1);
		
		gata.setBounds(60,170,370,20);
		gata.setFont(new Font(null,Font.PLAIN,17));
		frame.add(gata);
		c2.setBounds(295,168,35,30);
		c2.setFocusable(false);
		int nr2=AnalizaTaskuri_PROCES(utilizator);
		c2.setFont(new Font(null,Font.PLAIN,17));
		c2.setText(String.valueOf(nr2));
		frame.add(c2);
		
		
		timp.setBounds(60,220,370,20);
		timp.setFont(new Font(null,Font.PLAIN,17));
		frame.add(timp);
		
		timpmin.setBounds(60,260,370,20);
		timpmin.setFont(new Font(null,Font.PLAIN,17));
		frame.add(timpmin);
		c3.setBounds(125,255,45,30);
		c3.setFocusable(false);
		float nr3=AnalizaTaskuri_timpMINIM(utilizator);
		c3.setFont(new Font(null,Font.PLAIN,17));
		c3.setText(String.valueOf(nr3));
		frame.add(c3);
		
		timpmed.setBounds(230,260,370,20);
		timpmed.setFont(new Font(null,Font.PLAIN,17));
		frame.add(timpmed);
		c4.setBounds(295,255,45,30);
		c4.setFocusable(false);
		double nr4=AnalizaTaskuri_timpMEDIU(utilizator);
		c4.setFont(new Font(null,Font.PLAIN,17));
		c4.setText(String.valueOf(nr4));
		frame.add(c4);
		
		timpmax.setBounds(400,260,370,20);
		timpmax.setFont(new Font(null,Font.PLAIN,17));
		frame.add(timpmax);
		c5.setBounds(465,255,45,30);
		c5.setFocusable(false);
		float nr5=AnalizaTaskuri_timpMAXIM(utilizator);
		c5.setFont(new Font(null,Font.PLAIN,17));
		c5.setText(String.valueOf(nr5));
		frame.add(c5);
		
		dupatermen.setBounds(60,330,370,20);
		dupatermen.setFont(new Font(null,Font.PLAIN,17));
		frame.add(dupatermen);
		c6.setBounds(395,325,35,30);
		c6.setFocusable(false);
		int nr6=AnalizaTaskuri_NrDupaTermen(utilizator);
		c6.setFont(new Font(null,Font.PLAIN,17));
		c6.setText(String.valueOf(nr6));
		frame.add(c6);
		
		Image img=(new ImageIcon("D://01 - Facultate//Anul 2//P3//Proiect_Ioana_Morariu//MyTasksHelper//IMAGINI//212.png")).getImage();
		robot1.setIcon(new ImageIcon(img));
		robot1.setBounds(565,135,188,361);
		frame.getContentPane().add(robot1);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(880,560);
		frame.getContentPane().setBackground(culoare2);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocation(370, 110);
		
	}

	/**
	 * Metoda care realizeaza actiuni in urma apasarii pe anumite elemente din "pagina"                      
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==inapoi) {
			MeniuPrincipal meniu=new MeniuPrincipal(utilizator,lista_utl);
			frame.setVisible(false);
		}
		
	}
	
	/**
	 * Functie care returneaza timpul maxim petrecut la un task
	 *  @param x  - proprietarul task-urilor  
	 *  @return timpMax - timpul maxim de completare a unui task
	 */
	public static float AnalizaTaskuri_timpMAXIM(Utilizator x) {
		float timpMax=0;
		if(x.lista_task_gata.size()>0) {
			timpMax=x.lista_task_gata.get(0).getTimprezolvare();
			for(TaskG a: x.lista_task_gata) 
				if(a.getTimprezolvare()>timpMax) timpMax=a.getTimprezolvare();
				
			System.out.println("MAX: "+timpMax);	
			return timpMax;
			}
		return timpMax;
		}
	
		/**
	 	* Functie care returneaza timpul minim petrecut la un task
	 	*  @param  x  - proprietarul task-urilor  
	 	*  @return timpMin -  timpul minim de completare a unui task 
	 	*/
		public static float AnalizaTaskuri_timpMINIM(Utilizator x) {
			float timpMin=0;
			if(x.lista_task_gata.size()>0) {
				timpMin=x.lista_task_gata.get(0).getTimprezolvare();
				for(TaskG a: x.lista_task_gata) 
					if(a.getTimprezolvare()<timpMin) timpMin=a.getTimprezolvare();
					
				System.out.println("MIN: "+timpMin);
				}
			return timpMin;
			}
		
		/**
		 * Functie care returneaza timpul minim petrecut la un task
		 *  @param  x  - proprietarul task-urilor  
		 *  @return roundOff -  timpul minim de completare a unui task 
		 */
		public static double AnalizaTaskuri_timpMEDIU(Utilizator x) {
			float timpMediu=0;
			if(x.lista_task_gata.size()>0) {
				for(TaskG a: x.lista_task_gata) 
					 timpMediu+=a.getTimprezolvare();
				timpMediu=timpMediu/x.lista_task_gata.size();
				System.out.println("MED: "+timpMediu);
				}
			double roundOff = Math.round(timpMediu * 100.0) / 100.0;
			return roundOff;
			}
		
		/**
		 * Functie care returneaza numarul de taskuri rezolvate dupa termenul limita
		 *  @param  x  - proprietarul task-urilor  
		 *  @return nrPesteTermen -  nr de taskuri rezolvate dupa termenul limita
		 */
		public static int AnalizaTaskuri_NrDupaTermen(Utilizator x) {
			int nrPesteTermen=0;
			if(x.lista_task_gata.size()>0) {
				//System.out.println(t.get(0));
				for(TaskG a: x.lista_task_gata) 
					if(a.getDatarezolvare().getAn()>a.getDatatermen().getAn()) 
						nrPesteTermen++;
					else if(a.getDatarezolvare().getAn()==a.getDatatermen().getAn()&&a.getDatarezolvare().getLuna()>a.getDatatermen().getLuna()) 
						nrPesteTermen++;
					else if(a.getDatarezolvare().getAn()==a.getDatatermen().getAn()&&a.getDatarezolvare().getLuna()==a.getDatatermen().getLuna()&&a.getDatarezolvare().getZi()>a.getDatatermen().getZi())
						nrPesteTermen++;
				}
			
			return nrPesteTermen;
			}
		
		/**
		 * Functie care returneaza numarul de taskuri gata
		 *  @param  x  - proprietarul task-urilor  
		 *  @return nrGata - nr de taskuri gata
		 */
		public static int AnalizaTaskuri_GATA(Utilizator x) {
			int nrGata=x.lista_task_gata.size();
			System.out.println("Nr task-uri gata: "+nrGata);
			return nrGata;
		}
		
		/**
		 * Functie care returneaza numarul de taskuri in proces de rezolvare
		 *  @param  x  - proprietarul task-urilor  
		 *  @return nrProses - nr de taskuri in proces de realizare
		 */
		public static int AnalizaTaskuri_PROCES(Utilizator x) {
			int nrProses=x.lista_task_in_proces.size();
			System.out.println("Nr task-uri in proces: "+ nrProses);
			return nrProses;
		}


}
