package LogicTier;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener; 
	import java.util.List;

	import javax.swing.JOptionPane;

import BridgeShow.Movie;
import BridgeShow.Show;
import BridgeShow.ShowAfterAbstraction;
import BridgeShow.ShowHibernate;
import BridgeShow.Sport;
import BridgeShow.Theatre;
import DataTier.Admin;
import DataTier.User;
import DataTier.UserHibernate;
import PresentationTier.AdminFrame; 
	public class AdminControl implements ActionListener {
		private AdminFrame adm;
		private Admin admin;
		private List<User> users;
		private List<Show> shows;
		ShowHibernate showHibernate= new ShowHibernate();
		UserHibernate usersHibernate= new UserHibernate();
		public AdminControl(AdminFrame m, Admin e)
		{
			this.admin=e;
			this.adm=m;
			
			this.shows= showHibernate.selectShows();
			this.users= usersHibernate.selectusers();
	 
			this.adm.btnAddEmployee.addActionListener(this);
			this.adm.btnAddShow.addActionListener(this);
			this.adm.btnDeleteEmployee.addActionListener(this);
			this.adm.btnDeleteShow.addActionListener(this);
			this.adm.btnDeleteShow.addActionListener(this); 
			this.adm.btnUpdate.addActionListener(this);
			this.adm.btnUpdateEmployee.addActionListener(this);
			this.adm.btnView.addActionListener(this);
			this.adm.btnVire.addActionListener(this);
		}

	public List<Show>getShows()
	{
		return this.shows;
	}
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource()==adm.btnAddEmployee)
			{
				
				usersHibernate.addUser(adm.textIduser.getText(), adm.textNumeUser.getText(), adm.textParola.getText(), adm.textTip.getText(), 1);
 				   JOptionPane.showMessageDialog(null, "Succes!");
 				  
 					this.users= usersHibernate.selectusers();
 				   adm.cleanModel2();
				afisareEmployees();
			 
			}

			if (e.getSource()==adm.btnAddShow)
			{ 
				String type = adm.numeType.getText();
 
				  
				 ShowAfterAbstraction sb;
				if (type.equals("Movie")) {
					sb = new ShowAfterAbstraction(new Movie(Integer.parseInt(adm.idShow.getText()),adm.numeShow.getText() 
							, adm.descriere.getText(),adm.numeActor.getText(),0.0f, 1));
				} else if (type.equals("Sport")) {
					sb = new ShowAfterAbstraction(new Sport(Integer.parseInt(adm.idShow.getText()),adm.numeShow.getText() 
							, adm.descriere.getText(),adm.numeActor.getText(),0.0f, 1));
				} else
					sb = new ShowAfterAbstraction(new Theatre(Integer.parseInt(adm.idShow.getText()),adm.numeShow.getText() 
							, adm.descriere.getText(),adm.numeActor.getText(),0.0f, 1));
				sb.add(); 
	   JOptionPane.showMessageDialog(null, " The show was added!");
	   this.shows= showHibernate.selectShows(); 
				afisareMedicamente();
		 
			}
			if (e.getSource()==adm.btnDeleteEmployee)
			{
				int id_us=Integer.parseInt( adm.textIduser.getText());
			   
				usersHibernate.delete(id_us);
				this.users=usersHibernate.selectusers();
				adm.cleanModel2();
				afisareEmployees();
		  
			}
			if (e.getSource()==adm.btnDeleteShow)
			{
			 int id_sh= Integer.parseInt(adm.idShow.getText());
			 showHibernate.delete(id_sh);
				this.shows=showHibernate.selectShows();
				afisareMedicamente();
			}
			  
			if (e.getSource()==adm.btnUpdate)
			{
				String type = adm.numeType.getText();
				 
				Show s= showHibernate.getShow(Integer.parseInt(adm.idShow.getText()));
			 	s.setName(adm.numeShow.getText());
				s.setDesc(adm.descriere.getText());
				s.setActor(adm.numeActor.getText());
				s.setImdb(Double.parseDouble(adm.numeRate.getText()));
				
				showHibernate.update(s);
				s.notifyAllObservers();
				this.shows=showHibernate.selectShows();
				
				afisareMedicamente();
			}
			if (e.getSource()==adm.btnUpdateEmployee)
			{ 
				String premium;
				if ((adm.textTip.getText()).equals("Premium")) {
					premium = "Premium";
				} else
					premium = "Basic";
				usersHibernate.update(Integer.parseInt(adm.textIduser.getText()), adm.textNumeUser.getText(), adm.textParola.getText(), premium,null);
				this.users=usersHibernate.selectusers();
				afisareEmployees();
			}
			if (e.getSource()==adm.btnView)
			{
				afisareEmployees();
			}
			if (e.getSource()==adm.btnVire)
			{
				afisareMedicamente();
			}
			
		}
		public   void afisareMedicamente()  {
			   this.adm.table_1.setRowCount(0);
				
			    for (Object sh : shows) {
			     	
			      String[] ob = { String.valueOf(((Show) sh).getName()),String.valueOf(((Show) sh).getType()),
			    		  String.valueOf(((Show) sh).getIdShow()),
			    		  String.valueOf(((Show)sh).getDes()),
			    		  String.valueOf(((Show)sh).getIMDB()),
			    		  String.valueOf(((Show)sh).getActors())
			      };
			  
			      adm.table_1.addRow(ob);
			      		 
			    			}  
		}
		
		public   void afisareEmployees()  {
			   this.adm.table_3.setRowCount(0);
				 
			    for (Object ang : users) {
			     
			      String[] ob = {String.valueOf(((User) ang).getIdUser()), String.valueOf(((User) ang).getName()),
			    		  String.valueOf(((User)ang).getType())
			      };
			  
			      adm.table_3.addRow(ob);
			      		 
			    			}  
		}

}
