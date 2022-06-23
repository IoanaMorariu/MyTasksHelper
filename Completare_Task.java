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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import Clase_Obiecte.Data;
import Clase_Obiecte.TaskG;
import Clase_Obiecte.TaskP;
import Clase_Obiecte.Utilizator;
/**
 * @author      Ioana Morariu 
 * @version     1.0                 (current version number of program)	
 */
public class Completare_Task implements ActionListener{
	JFrame frame= new JFrame();
	Utilizator utilizator;
	JButton inapoi=new JButton("<- Inapoi");
	JLabel titlu= new JLabel("Task selectat:");
	List <Utilizator> lista_utl=new ArrayList<>();
	DefaultListModel<String> fundal1= new DefaultListModel<>();
	JList <String> fundal=new JList<>(fundal1);
	JLabel idnume= new JLabel();
	JLabel descriere= new JLabel();
	JLabel primired= new JLabel();
	JLabel limitad= new JLabel();
	JLabel datarez= new JLabel("Data rezolvarii:");
	JLabel zi= new JLabel("zi: ");
	JLabel luna= new JLabel("luna: ");
	JLabel an= new JLabel("an: ");
	JTextField zT= new JTextField(25);
	JTextField lT= new JTextField(25);
	JTextField aT= new JTextField(25);
	JLabel datatermen= new JLabel("Timpul acordat: ");
	JTextField tT= new JTextField(25);
	JButton completareT=new JButton("Completare");
	JLabel errData= new JLabel("");
	JLabel errTimp= new JLabel("");

	TaskP tak_comp;
	
	/**
	 * Constructor pentru pagina de completare a unui task
	 * @param x - utilizatorul aplicatiei
	 * @param lista_utilizatori - lista de utilizatori
	 * @param task -  taskul care trebuie completat
	 */
	public Completare_Task(Utilizator x,List <Utilizator> lista_utilizatori, TaskP task) {
		
		tak_comp=task;
		utilizator=x;lista_utl=lista_utilizatori;
		Color c1= new Color(230, 247, 255);
		Color c2= new Color(160, 230, 255);
		Color c3= new Color(255, 255, 153);
		Color c4= new Color(179, 0, 0);
		//Color c5= new Color(102, 163, 255);
		
		titlu.setBounds(60,75,370,30);
		titlu.setFont(new Font(null,Font.PLAIN,24));
		frame.add(titlu);
		
		
		inapoi.setBounds(15,10,90,20);
		inapoi.setFont(new Font(null,Font.BOLD,12));
		inapoi.setFocusable(false);
		inapoi.addActionListener(this);
		inapoi.setBackground(c3);
		frame.add(inapoi);
		
		idnume.setBounds(60,145,370,15);
		idnume.setFont(new Font(null,Font.BOLD,12));
		frame.add(idnume);
		
		descriere.setBounds(60,165,370,15);
		descriere.setFont(new Font(null,Font.BOLD,12));
		frame.add(descriere);
		
		primired.setBounds(60,185,370,15);
		primired.setFont(new Font(null,Font.BOLD,12));
		frame.add(primired);
		
		limitad.setBounds(60,205,370,15);
		limitad.setFont(new Font(null,Font.BOLD,12));
		frame.add(limitad);
				
		idnume.setText("Id: " + tak_comp.getIdTask()+"     Nume: "+tak_comp.getNumeTask());
		descriere.setText("Descriere: "+tak_comp.getDescriereTask());
		primired.setText("Data primire: "+tak_comp.getDataprimire());
		limitad.setText("Termne: "+tak_comp.getDatatermen());
		
		fundal.setBounds(50,130,370,110);
		fundal.setVisibleRowCount(15);
		fundal.setFixedCellHeight(20);
		fundal.setFixedCellWidth(220);
		frame.add(fundal);
		
		
		datarez.setBounds(60,280,370,35);
		datarez.setFont(new Font(null,Font.PLAIN,16));
		frame.add(datarez);
	
		
		zi.setBounds(190,291,370,15);
		zi.setFont(new Font(null,Font.PLAIN,17));
		frame.add(zi);
		zT.setBounds(240,290,50,22);
		frame.add(zT);
		
		luna.setBounds(190,321,370,15);
		luna.setFont(new Font(null,Font.PLAIN,17));
		frame.add(luna);
		lT.setBounds(240,320,50,22);
		frame.add(lT);
		
		an.setBounds(190,351,370,15);
		an.setFont(new Font(null,Font.PLAIN,17));
		frame.add(an);
		aT.setBounds(240,350,50,22);
		frame.add(aT);
		
		datatermen.setBounds(60,400,370,35);
		datatermen.setFont(new Font(null,Font.PLAIN,16));
		frame.add(datatermen);
		tT.setBounds(180,406,50,22);
		frame.add(tT);
		
		completareT.setBounds(230,490,130,40);
		completareT.setFont(new Font(null,Font.BOLD,12));
		completareT.setFocusable(false);
		completareT.addActionListener(this);
		completareT.setBackground(c1);
		frame.add(completareT);
		
		errData.setBounds(310,354,370,15);
		errData.setFont(new Font(null,Font.BOLD,12));
		errData.setForeground(c4);
		frame.add(errData);
		
		errTimp.setBounds(250,406,370,15);
		errTimp.setFont(new Font(null,Font.BOLD,12));
		errTimp.setForeground(c4);
		frame.add(errTimp);
		
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
		
		if(e.getSource()==completareT) {
			String ziua=zT.getText();
			String luna=lT.getText();
			String an=aT.getText();
			String t=tT.getText();
			errTimp.setText("");errData.setText("");
			if(!ziua.equals("")&&!luna.equals("")&&!an.equals("")) {
				errData.setText("");
				int z=Integer.parseInt(ziua);
				int l=Integer.parseInt(luna);
				int a=Integer.parseInt(an);
				
				if(validate_data(z,l,a)==1){
					errData.setText("");
					if(!t.equals(""))	{
						errTimp.setText("");
						Float tm=Float.parseFloat(t);
						CompletareTask(utilizator,tak_comp,tm, z, l, a);
						Task_in_Proces_butonul1 back=new Task_in_Proces_butonul1(utilizator,lista_utl);
						frame.setVisible(false);
						
					}else errTimp.setText("* nu ai completat acest camp");
				}else 	errData.setText("* data nu este valida");		
			}else errData.setText("* nu ai completat toate campurile");
		}
	}
	
	/**
	 * Functie de verificare daca o data este valida
	 *  @param  zi - ziua 
	 *  @param  luna - luna
	 *  @param  an - anul;     
	 *  @return ok - validarea    
	 */
	public static int validate_data(int zi,int luna, int an) {
		
		int bisect=0,ok=0;
	
		if (an%4==0 && an%100!=0) bisect=1;
		else if(an%400==0)  bisect=1;
		System.out.println(bisect);
		
		if(an<2000 || an>2050) return 0;
		if(luna<1||luna>12) return 0;
		if(zi<1||zi>31 && (luna==1||luna==3||luna==5||luna==7||luna==8||luna==10||luna==12)) return ok;
		if(zi<1||zi>30&& (luna==4||luna==6||luna==9||luna==11)) return ok;
		if(zi<1||zi>29 && luna==2 && bisect==1) return ok;
		if(zi<1||zi>28 && luna==2 && bisect==0) return ok;
		//System.out.println("an bun cica");
		ok++;
		return ok;
	}
	
	
	
	/**
	 * Functie de completare a unui task atat in lista, cat si in baza de date
	 *  @param x - utilizatorul care detine taskul
	 *  @param task - taskul care trebuie completat;
	 *  @param timp - timpul acordat
	 *  @param zi - ziua completarii
	 *  @param luna - luna completarii
	 *  @param an - anul completarii
	 */
	public static void CompletareTask(Utilizator x,TaskP task,float timp, int zi, int luna, int an) {
		int nr=task.getIdTask();
		int i,nr1;
		for(i=0;i<x.lista_task_in_proces.size();i++)
			if(x.lista_task_in_proces.get(i).getIdTask()==nr)
				x.lista_task_in_proces.remove(i);
		if(x.lista_task_gata.size()==0) nr1=0;
		else nr1=x.lista_task_gata.get(x.lista_task_gata.size()-1).getIdTask()+1;
		Data d=new Data(zi,luna,an);
		TaskG tgata=new TaskG(nr1,x.getIdUTL(),task.getNumeTask(),task.getDescriereTask(),task.getDataprimire(),task.getDatatermen(),timp,d);
		tgata.setStareTask(true);
		x.lista_task_gata.add(tgata);
		
		String jdbcURL1="jdbc:derby:Baza_de_date_PROIECT";
		try {
			Connection con= DriverManager.getConnection(jdbcURL1);
			Statement st = con.createStatement();
			System.out.println("Succes ------> conectare");
			String sql="update Task set stare=1,ore="+timp+", zirezolvare="+zi+", lunarezolvare="+luna+", anrezolvare="+an+", idT="+nr1+" where idT="+nr+" and stare=0";
			      
			System.out.println(sql);
			int rand= st.executeUpdate(sql);
			if(rand>0) {
				System.out.println("Randul a fost sters in tabel");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
