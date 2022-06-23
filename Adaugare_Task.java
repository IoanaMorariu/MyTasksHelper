package Interfete_app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Clase_Obiecte.Data;
import Clase_Obiecte.TaskP;
import Clase_Obiecte.Utilizator;
/**
 * @author      Ioana Morariu 
 * @version     1.0                 (current version number of program)	
 */
public class Adaugare_Task implements ActionListener{
	JFrame frame= new JFrame();
	Utilizator utilizator;
	JButton inapoi=new JButton("<- Inapoi");
	List <Utilizator> lista_utl=new ArrayList<>();
	JButton adaugareT=new JButton("Adaugare");
	JLabel titlu= new JLabel("Adaugare Task");
	JLabel nume= new JLabel("Nume: ");
	JLabel descriere= new JLabel("Descriere: ");
	JLabel dataprimire= new JLabel("Data primire:");
	JLabel zi1= new JLabel("zi: ");
	JLabel luna1= new JLabel("luna: ");
	JLabel an1= new JLabel("an: ");
	JLabel datatermen= new JLabel("Data limita: ");
	JLabel zi2= new JLabel("zi: ");
	JLabel luna2= new JLabel("luna: ");
	JLabel an2 = new JLabel("an: ");
	
	JTextField numeT= new JTextField(25);
	JTextField descriereT= new JTextField(25);
	JTextField z1T= new JTextField(25);
	JTextField l1T= new JTextField(25);
	JTextField a1T= new JTextField(25);
	JTextField z2T= new JTextField(25);
	JTextField l2T= new JTextField(25);
	JTextField a2T= new JTextField(25);
	
	JLabel errNUME = new JLabel("");
	JLabel errA1 = new JLabel("");
	JLabel errA2 = new JLabel("");
	
	/**
	 * Constructor pentru pagina de adaugare a uinui task
	 * @param x - utilizatorul aplicatiei
	 * @param lista_utilizatori - lista de utilizatori
	 */
	public Adaugare_Task(Utilizator x,List <Utilizator> lista_utilizatori) {
		
		utilizator=x;lista_utl=lista_utilizatori;
		Color c1= new Color(230, 247, 255);
		Color c2= new Color(160, 230, 255);
		Color c3= new Color(255, 255, 153);
		Color c4= new Color(179, 0, 0);
		
		inapoi.setBounds(15,10,90,20);
		inapoi.setFont(new Font(null,Font.BOLD,12));
		inapoi.setFocusable(false);
		inapoi.addActionListener(this);
		inapoi.setBackground(c3);
		frame.add(inapoi);
		
		titlu.setBounds(200,65,370,30);
		titlu.setFont(new Font(null,Font.PLAIN,24));
		frame.add(titlu);
		
		
		nume.setBounds(60,150,150,15);
		nume.setFont(new Font(null,Font.PLAIN,17));
		frame.add(nume);
		numeT.setBounds(130,140,100,30);
		frame.add(numeT);
	
		
		descriere.setBounds(60,200,370,15);
		descriere.setFont(new Font(null,Font.PLAIN,17));
		frame.add(descriere);
		descriereT.setBounds(150,190,170,30);
		frame.add(descriereT);
		
		dataprimire.setBounds(60,240,370,35);
		dataprimire.setFont(new Font(null,Font.PLAIN,16));
		frame.add(dataprimire);
	
		
		zi1.setBounds(190,251,370,15);
		zi1.setFont(new Font(null,Font.PLAIN,17));
		frame.add(zi1);
		z1T.setBounds(240,250,50,22);
		frame.add(z1T);
		
		luna1.setBounds(190,281,370,15);
		luna1.setFont(new Font(null,Font.PLAIN,17));
		frame.add(luna1);
		l1T.setBounds(240,280,50,22);
		frame.add(l1T);
		
		an1.setBounds(190,311,370,15);
		an1.setFont(new Font(null,Font.PLAIN,17));
		frame.add(an1);
		a1T.setBounds(240,310,50,22);
		frame.add(a1T);
		
		datatermen.setBounds(60,360,370,35);
		datatermen.setFont(new Font(null,Font.PLAIN,16));
		frame.add(datatermen);
		
		zi2.setBounds(190,371,390,15);
		zi2.setFont(new Font(null,Font.PLAIN,17));
		frame.add(zi2);
		z2T.setBounds(240,370,50,22);
		frame.add(z2T);
		
		luna2.setBounds(190,401,370,15);
		luna2.setFont(new Font(null,Font.PLAIN,17));
		frame.add(luna2);
		l2T.setBounds(240,400,50,22);
		frame.add(l2T);
		
		an2.setBounds(190,431,370,15);
		an2.setFont(new Font(null,Font.PLAIN,17));
		frame.add(an2);
		a2T.setBounds(240,430,50,22);
		frame.add(a2T);
		
		adaugareT.setBounds(230,490,130,40);
		adaugareT.setFont(new Font(null,Font.BOLD,12));
		adaugareT.setFocusable(false);
		adaugareT.addActionListener(this);
		adaugareT.setBackground(c1);
		frame.add(adaugareT);
		
		
		errNUME.setBounds(250,140,250,30);
		errNUME.setFont(new Font(null,Font.BOLD,12));
		errNUME.setForeground(c4);
		frame.add(errNUME);
		
		errA1.setBounds(305,311,370,15);
		errA1.setFont(new Font(null,Font.BOLD,12));
		errA1.setForeground(c4);
		frame.add(errA1);
		
		errA2.setBounds(305,431,370,15);
		errA2.setFont(new Font(null,Font.BOLD,12));
		errA2.setForeground(c4);
		frame.add(errA2);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(580,660);
		frame.getContentPane().setBackground(c2);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocation(500, 80);
	}

	/**
	 * Metoda care realizeaza actiuni in urma apasarii pe anumite elemente din "pagina"                      
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==inapoi) {
			Task_in_Proces_butonul1 back=new Task_in_Proces_butonul1(utilizator,lista_utl);
			frame.setVisible(false);
		}
		
		if(e.getSource()==adaugareT) {
			errA1.setText("");errA2.setText("");errNUME.setText("");
			String NUM=numeT.getText();
			if(!NUM.equals("")) {
				errNUME.setText("");
				//System.out.println(NUM);
			String DESC=descriereT.getText();
			String ziua1=z1T.getText();
			String luna1=l1T.getText();
			String an1=a1T.getText();
			
			if(!ziua1.equals("")&&!luna1.equals("")&&!an1.equals("")) {
				errA1.setText("");
				int z=Integer.parseInt(ziua1);
				int l=Integer.parseInt(luna1);
				int a=Integer.parseInt(an1);
			
				if(validate_data(z,l,a)==1) {
						errA1.setText("");
						System.out.println(ziua1+" "+luna1+" "+an1);
						
						String ziua2=z2T.getText();
						String luna2=l2T.getText();
						String an2=a2T.getText();
						if(!ziua2.equals("")&&!luna2.equals("")&&!an2.equals("")) {
							errA2.setText("");
							int z1=Integer.parseInt(ziua2);
							int l1=Integer.parseInt(luna2);
							int a1=Integer.parseInt(an2);
						
							if(validate_data(z1,l1,a1)==1) {
									errA2.setText("");
									System.out.println(ziua2+" "+luna2+" "+an2);
									
									if(validare_date1_2(z,l,a,z1,l1,a1)==1){
										errA2.setText("");
										AdaugareTask(utilizator,NUM,DESC,z,l,a,z1,l1,a1);
										numeT.setText("");
										descriereT.setText("");
										z1T.setText("");
										l1T.setText("");
										a1T.setText("");
										z2T.setText("");
										l2T.setText("");
										a2T.setText("");
										
									}else errA2.setText("*data este mai mica decat prima");
								}else errA2.setText("* data nu este valida");
							} else errA2.setText("* nu ai completat toate campurile");
					}else errA1.setText("* data nu este valida");
				} else errA1.setText("* nu ai completat toate campurile");
			}else errNUME.setText("* nu ai completat acest camp!");
			
		}
	}
	
	/**
	 * Functie validare daca prima data este mai mica decat prima 
	 *  @param z1 - ziua din prima data
	 *  @param l1 - luna din prima data
	 *  @param a1 - anul din prima data
	 *  @param z2 - ziua din a doua data
	 *  @param l2 - luna din a doua data
	 *  @param a2 -  anul din a doua data   
	 *  @return  x - verificare daca cerinta e indeplinita          
	 */
	public static int validare_date1_2(int z1,int l1,int a1,int z2,int l2,int a2) {
		
		int x=0;
		if(a1>a2) return x;
	    if(a1==a2&& l1>l2) return x;
		if (a1==a2&&l1==l2&&z1>z2) return x;
		x=1;
		return 1;
		
	}
	
	/**
	 * Functie de verificare daca o data este valida
	 *  @param  zi - ziua
	 *  @param  luna - luna
	 *  @param  an - anul     
	 *  @return  x - verificare daca cerinta e indeplinita      
	 */
	public static int validate_data(int zi,int luna, int an) {
		
		int bisect=0;
	
		if (an%4==0 && an%100!=0) bisect=1;
		else if(an%400==0)  bisect=1;
		System.out.println(bisect);
		
		if(an<2000 || an>2050) return 0;
		if(luna<1||luna>12) return 0;
		if(zi<1||zi>31 && (luna==1||luna==3||luna==5||luna==7||luna==8||luna==10||luna==12)) return 0;
		if(zi<1||zi>30&& (luna==4||luna==6||luna==9||luna==11)) return 0;
		if(zi<1||zi>29 && luna==2 && bisect==1) return 0;
		if(zi<1||zi>28 && luna==2 && bisect==0) return 0;
		System.out.println("an bun cica");
		return 1;
	}
	
	/**
	 * Functie de adaugarea unui task atat in lista, cat si in baza de date
	 *  @param  x- utilizatorul care adauga taskul
	 *  @param  numeTask - nume task
	 *  @param  descriereTask - descriere task
	 *  @param  ziprimit - ziua primirii 
	 *  @param  lunaprimit - luna primirii
	 *  @param  anprimit - anul primirii
	 *  @param  zidat - ziua predarii
	 *  @param   lunadat - luna predarii
	 *  @param  andat - anul predarii;       
	 */
	public static void AdaugareTask(Utilizator x,String numeTask, String descriereTask, int ziprimit,int lunaprimit,int anprimit,int zidat, int lunadat, int andat) {
		Data d1=new Data(ziprimit,lunaprimit,anprimit);
		Data d2=new Data(zidat,lunadat,andat);
		int id;
		if(x.lista_task_in_proces.size()==0) id=1;
		else id=x.lista_task_in_proces.get(x.lista_task_in_proces.size()-1).getIdTask()+1;
		TaskP task=new TaskP(id,x.getIdUTL(),numeTask,descriereTask,d1,d2);
		x.lista_task_in_proces.add(task);
		
		String jdbcURL1="jdbc:derby:Baza_de_date_PROIECT";
		try {
			Connection con= DriverManager.getConnection(jdbcURL1);
			Statement st = con.createStatement();
			System.out.println("Succes ------> conectare");
			String sql="Insert into Task (idT,idU,nume,descriere,ziprimire,lunaprimire,anprimire,zitermen,lunatermen,antermen,"
					+ "stare,ore,zirezolvare,lunarezolvare,anrezolvare) values ("+id+", "+x.getIdUTL()+",'"+numeTask+"', '"+descriereTask+"', "
					+ziprimit+", "+lunaprimit+", "+anprimit+", "+zidat+", "+lunadat+","+andat+",0,0,0,0,0)";
			//System.out.println(sql);
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
