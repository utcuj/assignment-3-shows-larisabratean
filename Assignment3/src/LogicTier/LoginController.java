package LogicTier;
  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DataTier.Admin;
import DataTier.AdminHibernate;
import DataTier.User;
import DataTier.UserHibernate;
import PresentationTier.AdminUser;
import PresentationTier.LoginFrame;
import PresentationTier.PremiumFrame; 
public class LoginController implements ActionListener  {
	
	private LoginFrame signInView = new LoginFrame();
	
	private UserHibernate us= new UserHibernate();
	private AdminHibernate ad= new AdminHibernate();

	
	public LoginController(LoginFrame signInView) {
		this.signInView = signInView;
		

this.signInView.btnEmployee.addActionListener(this);

this.signInView.btnAdmin.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
{
	if (e.getSource()==signInView.btnAdmin)
	{	 
		String pass=new String(signInView.passwordField.getPassword());
		String nume= new String(signInView.textUsername.getText());
	
	Admin a = ad.getAdmin(nume,pass);
	if (a!=null)
	{ 
		 new AdminController();
		 AdminUser adminView=new AdminUser(a);
		  adminView.setFrame();
		 
	}

	else {
		JOptionPane.showMessageDialog(null, "Admin-ul nu exista!");

	}
	}
if (e.getSource()==signInView.btnEmployee)
{ 
	String pass=new String(signInView.passwordField.getPassword());
	String nume= new String(signInView.textUsername.getText());
	 
	
	User use= us.getUser(nume, pass);
	if (use!=null)
	{
		 new ClientController();
		  PremiumFrame clientView=new PremiumFrame(use);
		  clientView.setFrame();
		  
	 
	}
	else {
		JOptionPane.showMessageDialog(null, "Angajatul-ul nu exista!");

	}
	
}
}
}
