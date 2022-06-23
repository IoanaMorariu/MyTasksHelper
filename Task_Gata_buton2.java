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


import Clase_Obiecte.*;
/**
 * @author      Ioana Morariu 
 * @version     1.0                 (current version number of program)	
 */
public class Task_Gata_buton2 implements ActionListener{
	JFrame frame= new JFrame();
	JButton inapoi=new JButton("<- Inapoi");
	JButton stergere=new JButton("Stergere");
	Utilizator utilizator;
	DefaultListModel<TaskG> lista= new DefaultListModel<>();
	JList <TaskG> lista_task;
	JRadioButton timp,denumire,primire,predare;
	JLabel text= new JLabel("Sortare lista dupa:");
	JLabel idnume= new JLabel();
	JLabel descriere= new JLabel();
	JLabel primired= new JLabel();
	JLabel limitad= new JLabel();
	JLabel predatd= new JLabel();
	JLabel timpd= new JLabel();
	DefaultListModel<String> fundal1= new DefaultListModel<>();
	JList <String> fundal=new JList<>(fundal1);
	JButton desc=new JButton("Vezi detaliile");
	JButton gol=new JButton("Golire");
	JButton sort=new JButton("Sorteaza");
	JLabel poza=new JLabel();
	List <Utilizator> lista_utl=new ArrayList<>();
	
	/**
	 * Constructor pentru pagina in care putem vedea taskurile gata
	 * @param x - utilizatorul aplicatiei
	 * @param lista_utilizatori - lista de utilizatori
	 */
	public Task_Gata_buton2(Utilizator x,List <Utilizator> lista_utilizatori) {
		
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
		
		stergere.setBounds(30,460,90,40);
		stergere.setFont(new Font(null,Font.BOLD,12));
		stergere.setFocusable(false);
		stergere.addActionListener(this);
		stergere.setBackground(c1);
		
		
		setDefaultListModel(utilizator.lista_task_gata,lista);
		
		lista_task=new JList<>(lista);
		lista_task.setBounds(30,50,350,400);
		//lista_task.setBounds(15,50,35,40);
		lista_task.setVisibleRowCount(15);
		lista_task.setFixedCellHeight(20);
		lista_task.setFixedCellWidth(220);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////// DESCRIERE	
		
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
		
		predatd.setBounds(418,135,370,15);
		predatd.setFont(new Font(null,Font.BOLD,12));
		frame.add(predatd);
		
		timpd.setBounds(418,155,370,15);
		timpd.setFont(new Font(null,Font.BOLD,12));
		frame.add(timpd);
		
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
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		text.setBounds(420,240,150,50);
		text.setFont(new Font(null,Font.PLAIN,18));
		denumire= new JRadioButton("Nume");
		denumire.setBounds(420,285,80,20);
		denumire.setFocusable(false);
		denumire.setFont(new Font(null,Font.PLAIN,13));
		denumire.setBackground(c2);
		denumire.addActionListener(this);
		timp = new JRadioButton("Timpul de realizare");
		timp.setBounds(420,305,150,20);
		timp.setFocusable(false);
		timp.setFont(new Font(null,Font.PLAIN,13));
		timp.setBackground(c2);
		timp.addActionListener(this);
		primire= new JRadioButton("Data primirii");
		primire.setBounds(420,325,150,20);
		primire.setFocusable(false);
		primire.setFont(new Font(null,Font.PLAIN,13));
		primire.setBackground(c2);
		primire.addActionListener(this);
		predare= new JRadioButton("Data rezolvarii");
		predare.setBounds(420,345,150,20);
		predare.setFocusable(false);
		predare.setFont(new Font(null,Font.PLAIN,13));
		predare.setBackground(c2);
		predare.addActionListener(this);
		
		sort.setBounds(410,390,130,30);
		sort.setFont(new Font(null,Font.BOLD,12));
		sort.setFocusable(false);
		sort.addActionListener(this);
		sort.setBackground(c5);
		sort.addActionListener(this);
		frame.add(sort);
		
		Image robot1=(new ImageIcon("D://01 - Facultate//Anul 2//P3//Proiect_Ioana_Morariu//MyTasksHelper//IMAGINI//12.png")).getImage();
		poza.setIcon(new ImageIcon(robot1));
		poza.setBounds(580,330,231,200);
		frame.getContentPane().add(poza);
		
		
		frame.add(text);
		frame.add(denumire);frame.add(timp);frame.add(primire);frame.add(predare);
		
		frame.add(lista_task);	
		frame.add(inapoi);frame.add(stergere);
		
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
		if(e.getSource()==desc) {
			if(lista_task.getSelectedValue()!=null) {
			idnume.setText("Id: " + lista_task.getSelectedValue().getIdTask()+"     Nume: "+lista_task.getSelectedValue().getNumeTask());
			descriere.setText("Descriere: "+lista_task.getSelectedValue().getDescriereTask());
			primired.setText("Data primire: "+lista_task.getSelectedValue().getDataprimire());
			limitad.setText("Termne: "+lista_task.getSelectedValue().getDatatermen());
			predatd.setText("Predat: "+lista_task.getSelectedValue().getDatarezolvare());
			timpd.setText("Timp: "+lista_task.getSelectedValue().getTimprezolvare());
			 
				}	
			}
		
		if(e.getSource()==gol) {
			idnume.setText("");
			descriere.setText("");
			primired.setText("");
			limitad.setText("");
			predatd.setText("");
			timpd.setText("");
		}

		if(e.getSource()==denumire) {
			//timp,denumire,primire,predare
			timp.setSelected(false);
			primire.setSelected(false);
			predare.setSelected(false);
		}
		
		if(e.getSource()==timp) {
			//timp,denumire,primire,predare
			denumire.setSelected(false);
			primire.setSelected(false);
			predare.setSelected(false);
		}
		if(e.getSource()==primire) {
			//timp,denumire,primire,predare
			denumire.setSelected(false);
			timp.setSelected(false);
			predare.setSelected(false);
		}
		if(e.getSource()==predare) {
			//timp,denumire,primire,predare
			denumire.setSelected(false);
			primire.setSelected(false);
			timp.setSelected(false);
		}
		
		if(e.getSource()==sort) {
			if(denumire.isSelected()) {
				sortare_nume(utilizator.lista_task_gata);
				setDefaultListModel(utilizator.lista_task_gata,lista);
				//(utilizator.lista_task_gata,lista);
			}
			if(timp.isSelected()) {
				sortare_timp(utilizator.lista_task_gata);
				setDefaultListModel(utilizator.lista_task_gata,lista);
				//(utilizator.lista_task_gata,lista);
			}
			if(primire.isSelected()) {
				sortare_primire(utilizator.lista_task_gata);
				setDefaultListModel(utilizator.lista_task_gata,lista);
				//(utilizator.lista_task_gata,lista);
			}
			if(predare.isSelected()) {
				sortare_rezolvare(utilizator.lista_task_gata);
				setDefaultListModel(utilizator.lista_task_gata,lista);
				//(utilizator.lista_task_gata,lista);
			}
		}
		
		if(e.getSource()==stergere) {
			if(lista_task.getSelectedValue()!=null) {
				TaskG de_sters=lista_task.getSelectedValue();
				StergereTask_gata(de_sters,utilizator.lista_task_gata) ;
				setDefaultListModel(utilizator.lista_task_gata,lista);
				
			}
		}
		
	}
	
	
	/**
	 * Functie de stergerea unui task atat in lista, cat si in baza de date
	 *  @param x - taskul care trebuie sters 
	 *  @param l - lista din care trebuie sters
	 */
	public static void StergereTask_gata(TaskG x,List<TaskG> l) {
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
			String sql="delete from Task where idT="+nr+" and stare=1";
			        
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
	 *  @param  l - lista cu taskuri ale utilizatorului 
	 *  @param  lista - lista de taskuri din interfata
	 */
	public static void setDefaultListModel(List<TaskG> l,DefaultListModel<TaskG> lista) {
		lista.clear();
		for(TaskG i: l)
			lista.addElement(i);
	}
	
	/**
	 * Functie de sortare dupa nume
	 *  @param l - lista cu taskuri ale utilizatorului 
	 * 
	 */
	public static void sortare_nume(List<TaskG> l) {
		Collections.sort(l, new Comparator<TaskG>() {

			public int compare(TaskG t1, TaskG t2) {
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
	 * Functie de sortare dupa timpul de realizare a unui task
	 *  @param l - lista cu taskuri ale utilizatorului 
	 */
	public static void sortare_timp(List<TaskG> l) {
		int i,j;
		for(i=0;i<l.size()-1;i++)
			for(j=i+1;j<l.size();j++)
				if(l.get(i).getTimprezolvare() > l.get(j).getTimprezolvare())
					Collections.swap(l,i,j);
				
	}
	
	/**
	 * Functie de sortare dupa data primirii
	 *  @param  l - lista cu taskuri ale utilizatorului 
	 */
	public static void sortare_primire(List<TaskG> l) {
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
	
	
	/**
	 * Functie de sortare dupa data rezolvarii
	 *  @param   l - lista cu taskuri ale utilizatorului 
	 */
	public static void sortare_rezolvare(List<TaskG> l) {
		int i,j;
		for(i=0;i<l.size()-1;i++)
			for(j=i+1;j<l.size();j++)
				if(l.get(i).getDatarezolvare().getAn() > l.get(j).getDatarezolvare().getAn())
					Collections.swap(l,i,j);
				else if(l.get(i).getDatarezolvare().getAn()==l.get(j).getDatarezolvare().getAn()&&l.get(i).getDatarezolvare().getLuna() > l.get(j).getDatarezolvare().getLuna())
					Collections.swap(l,i,j);
				else if(l.get(i).getDatarezolvare().getAn()==l.get(j).getDatarezolvare().getAn()&&l.get(i).getDatarezolvare().getLuna()==l.get(j).getDatarezolvare().getLuna()&&l.get(i).getDatarezolvare().getZi() > l.get(j).getDatarezolvare().getZi())
					Collections.swap(l,i,j);
	}
	
}
