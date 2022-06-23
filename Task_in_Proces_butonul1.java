package Interfete_app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;

import Clase_Obiecte.TaskG;
import Clase_Obiecte.TaskP;
import Clase_Obiecte.Utilizator;
/**
 * @author      Ioana Morariu 
 * @version     1.0                 (current version number of program)	
 */
public class Task_in_Proces_butonul1 implements ActionListener{
	JFrame frame= new JFrame();
	Utilizator utilizator;
	JButton inapoi=new JButton("<- Inapoi");
	JButton stergere=new JButton("Stergere");
	JButton adaugare=new JButton("Adaugare");
	JButton completare=new JButton("Completare");
	DefaultListModel<TaskP> lista= new DefaultListModel<>();
	JList <TaskP> lista_task;
	JRadioButton denumire,primire,id;
	JLabel text= new JLabel("Sortare lista dupa:");
	JLabel idnume= new JLabel();
	JLabel descriere= new JLabel();
	JLabel primired= new JLabel();
	JLabel limitad= new JLabel();
	JLabel robot1= new JLabel();
	
	DefaultListModel<String> fundal1= new DefaultListModel<>();
	JList <String> fundal=new JList<>(fundal1);
	JButton desc=new JButton("Vezi detaliile");
	JButton gol=new JButton("Golire");
	JButton sort=new JButton("Sorteaza");
	JLabel poza=new JLabel();
	List <Utilizator> lista_utl=new ArrayList<>();
	
	/**
	 * Constructor pentru pagina in care putem vedea taskurile in proces de realizare
	 * @param x - utilizatorul aplicatiei
	 * @param lista_utilizatori - lista de utilizatori
	 */
	public Task_in_Proces_butonul1(Utilizator x,List <Utilizator> lista_utilizatori) {
		
		utilizator=x;lista_utl=lista_utilizatori;
		Color c1= new Color(230, 247, 255);
		Color c2= new Color(160, 230, 255);
		Color c3= new Color(255, 255, 153);
		Color c4= new Color(0, 184, 230);
		Color c5= new Color(102, 163, 255);
		
		inapoi.setBounds(15,10,90,20);
		inapoi.setFont(new Font(null,Font.BOLD,12));
		inapoi.setFocusable(false);
		inapoi.addActionListener(this);
		inapoi.setBackground(c3);
		frame.add(inapoi);
		
	
		stergere.setBounds(30,460,90,40);
		stergere.setFont(new Font(null,Font.BOLD,12));
		stergere.setFocusable(false);
		stergere.addActionListener(this);
		stergere.setBackground(c1);
		frame.add(stergere);
		
		adaugare.setBounds(190,460,90,40);
		adaugare.setFont(new Font(null,Font.BOLD,12));
		adaugare.setFocusable(false);
		adaugare.addActionListener(this);
		adaugare.setBackground(c1);
		frame.add(adaugare);
		
		completare.setBounds(285,460,100,40);
		completare.setFont(new Font(null,Font.BOLD,12));
		completare.setFocusable(false);
		completare.addActionListener(this);
		completare.setBackground(c1);
		frame.add(completare);
		
		
		setDefaultListModel(utilizator.lista_task_in_proces,lista);
		lista_task=new JList<>(lista);
		lista_task.setBounds(30,50,350,400);
		//lista_task.setBounds(15,50,35,40);
		lista_task.setVisibleRowCount(15);
		lista_task.setFixedCellHeight(20);
		lista_task.setFixedCellWidth(220);
		frame.add(lista_task);
		
		idnume.setBounds(418,55,370,15);
		idnume.setFont(new Font(null,Font.BOLD,12));
		frame.add(idnume);
		
		descriere.setBounds(418,75,370,15);
		descriere.setFont(new Font(null,Font.BOLD,12));
		frame.add(descriere);
		
		primired.setBounds(418,95,370,15);
		primired.setFont(new Font(null,Font.BOLD,12));
		frame.add(primired);
		
		limitad.setBounds(418,115,370,15);
		limitad.setFont(new Font(null,Font.BOLD,12));
		frame.add(limitad);
		
		
		fundal.setBounds(410,50,370,130);
		fundal.setVisibleRowCount(15);
		fundal.setFixedCellHeight(20);
		fundal.setFixedCellWidth(220);
		frame.add(fundal);
		
		desc.setBounds(410,188,130,30);
		desc.setFont(new Font(null,Font.BOLD,12));
		desc.setFocusable(false);
		desc.addActionListener(this);
		desc.setBackground(c4);
		desc.addActionListener(this);
		frame.add(desc);
		
		gol.setBounds(560,188,130,30);
		gol.setFont(new Font(null,Font.BOLD,12));
		gol.setFocusable(false);
		gol.addActionListener(this);
		gol.setBackground(c4);
		gol.addActionListener(this);
		frame.add(gol);
		
		
		text.setBounds(420,240,150,50);
		text.setFont(new Font(null,Font.PLAIN,18));
		
		id= new JRadioButton("Id");
		id.setBounds(420,325,150,20);
		id.setFocusable(false);
		id.setFont(new Font(null,Font.PLAIN,13));
		id.setBackground(c2);
		id.addActionListener(this);
		
		denumire= new JRadioButton("Nume");
		denumire.setBounds(420,295,80,20);
		denumire.setFocusable(false);
		denumire.setFont(new Font(null,Font.PLAIN,13));
		denumire.setBackground(c2);
		denumire.addActionListener(this);

		primire= new JRadioButton("Data primirii");
		primire.setBounds(420,355,150,20);
		primire.setFocusable(false);
		primire.setFont(new Font(null,Font.PLAIN,13));
		primire.setBackground(c2);
		primire.addActionListener(this);
	
		sort.setBounds(410,400,130,30);
		sort.setFont(new Font(null,Font.BOLD,12));
		sort.setFocusable(false);
		sort.addActionListener(this);
		sort.setBackground(c5);
		sort.addActionListener(this);
		frame.add(sort);
		
		Image img=(new ImageIcon("D://01 - Facultate//Anul 2//P3//Proiect_Ioana_Morariu//MyTasksHelper//IMAGINI//3321.png")).getImage();
		robot1.setIcon(new ImageIcon(img));
		robot1.setBounds(605,215,198,361);
		frame.getContentPane().add(robot1);
		
		frame.add(denumire);frame.add(text);frame.add(primire);frame.add(id);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(880,560);
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
		if(e.getSource()==inapoi) {
			MeniuPrincipal meniu=new MeniuPrincipal(utilizator,lista_utl);
			frame.setVisible(false);
		}
		
		if(e.getSource()==adaugare) {
			Adaugare_Task adaugare=new Adaugare_Task(utilizator,lista_utl);
			frame.setVisible(false);
		}
		
		if(e.getSource()==completare) {
			if(lista_task.getSelectedValue()!=null){
				TaskP de_completat=lista_task.getSelectedValue();
			Completare_Task comp= new Completare_Task(utilizator,lista_utl, de_completat);
			frame.setVisible(false);}
		}
		
		if(e.getSource()==desc) {
			if(lista_task.getSelectedValue()!=null) {
			idnume.setText("Id: " + lista_task.getSelectedValue().getIdTask()+"     Nume: "+lista_task.getSelectedValue().getNumeTask());
			descriere.setText("Descriere: "+lista_task.getSelectedValue().getDescriereTask());
			primired.setText("Data primire: "+lista_task.getSelectedValue().getDataprimire());
			limitad.setText("Termne: "+lista_task.getSelectedValue().getDatatermen());
			
			 
				}	
			}
		
		if(e.getSource()==gol) {
			idnume.setText("");
			descriere.setText("");
			primired.setText("");
			limitad.setText("");
			
		}
		
			if(e.getSource()==denumire) {
			//timp,denumire,primire,predare
			primire.setSelected(false);
			id.setSelected(false);
		}
		
		if(e.getSource()==primire) {
			//timp,denumire,primire,predare
			denumire.setSelected(false);
			id.setSelected(false);
		}
		if(e.getSource()==id) {
			//timp,denumire,primire,predare
			denumire.setSelected(false);
			primire.setSelected(false);
		}
	
		
		if(e.getSource()==sort) {
			if(denumire.isSelected()) {
				sortare_nume(utilizator.lista_task_in_proces);
				setDefaultListModel(utilizator.lista_task_in_proces,lista);
				
			}
			
			if(primire.isSelected()) {
				sortare_primire(utilizator.lista_task_in_proces);
				setDefaultListModel(utilizator.lista_task_in_proces,lista);

			}
			
			if(id.isSelected()) {
				sortare_id(utilizator.lista_task_in_proces);
				setDefaultListModel(utilizator.lista_task_in_proces,lista);

			}
		}
		
		if(e.getSource()==stergere) {
			if(lista_task.getSelectedValue()!=null) {
				TaskP de_sters=lista_task.getSelectedValue();
				StergereTask_inproces(de_sters,utilizator.lista_task_in_proces) ;
				setDefaultListModel(utilizator.lista_task_in_proces,lista);
				
			}
		}
	}
	
	/**
	 * Functie de stergerea unui task atat in lista, cat si in baza de date
	 *  @param x - taskul care trebuie sters 
	 *  @param l - lista din care trebuie sters
	 */
	public static void StergereTask_inproces(TaskP x,List<TaskP> l) {
		int nr=x.getIdTask();
		int i;
		for(i=0;i<l.size();i++)
			if(l.get(i).getIdTask()==nr) 
				l.remove(i);
		
		
		String jdbcURL1="jdbc:derby:Baza_de_date_PROIECT";
		try {
			Connection con= DriverManager.getConnection(jdbcURL1);
			Statement st = con.createStatement();
			System.out.println("Succes ------> conectare");
			String sql="delete from Task where idT="+nr+" and stare=0";
			        
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
	
	
	/**
	 * Functie de completare a listei DefaultListModel
	 *  @param lista_task_in_proces - lista cu taskuri ale utilizatorului lista de taskuri din interfata
	 *  @param lista - lista de taskuri din interfata
	 */
	public static void setDefaultListModel(List<TaskP> lista_task_in_proces,DefaultListModel<TaskP> lista) {
		lista.clear();
		for(TaskP i: lista_task_in_proces)
			lista.addElement(i);
	}
	
	/**
	 * Functie de sortare dupa nume
	 *  @param  l - lista cu taskuri ale utilizatorului 
	 */
	public static void sortare_nume(List<TaskP> l) {
		Collections.sort(l, new Comparator<TaskP>() {

			public int compare(TaskP t1, TaskP t2) {
				// TODO Auto-generated method stub
				if(t1.getNumeTask().equals(t2.getNumeTask())) {
					if(t1.getIdTask() > t2.getIdTask())
						return 1;
					else
						return -1;
				}
				return t1.getNumeTask().compareTo(t2.getNumeTask());
			}

		});
	}
	

	
	/**
	 * Functie de sortare dupa id
	 *  @param  l - lista cu taskuri ale utilizatorului 
	 */
	public static void sortare_id(List<TaskP> l) {
		int i,j;
		for(i=0;i<l.size()-1;i++)
			for(j=i+1;j<l.size();j++)
				if(l.get(i).getIdTask() > l.get(j).getIdTask())
					Collections.swap(l,i,j);
	}
	
	
	/**
	 * Functie de sortare dupa data primirii
	 *  @param l - lista cu taskuri ale utilizatorului 
	 */
	public static void sortare_primire(List<TaskP> l) {
		int i,j;
		for(i=0;i<l.size()-1;i++)
			for(j=i+1;j<l.size();j++)
				if(l.get(i).getDataprimire().getAn() > l.get(j).getDataprimire().getAn())
					Collections.swap(l,i,j);
				else if(l.get(i).getDataprimire().getAn()==l.get(j).getDataprimire().getAn()&&l.get(i).getDataprimire().getLuna() > l.get(j).getDataprimire().getLuna())
					Collections.swap(l,i,j);
				else if(l.get(i).getDataprimire().getAn()==l.get(j).getDataprimire().getAn()&&l.get(i).getDataprimire().getLuna()==l.get(j).getDataprimire().getLuna()&&l.get(i).getDataprimire().getZi() > l.get(j).getDataprimire().getZi())
					Collections.swap(l,i,j);
	}
	
}
