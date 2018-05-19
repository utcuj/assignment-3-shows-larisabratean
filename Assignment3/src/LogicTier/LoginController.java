package LogicTier;
  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DataTier.Admin;
import DataTier.AdminHibernate;
import DataTier.User;
import DataTier.UserHibernate;
import PresentationTier.AdminFrame;
import PresentationTier.LoginFrame;
import PresentationTier.PremiumFrame;
import PresentationTier.RegularFrame; 
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
	
		 AdminFrame adminView=new AdminFrame(a);
		 new AdminControl(adminView,a);
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
		if (use.getType().equals("Premium"))
		{
		PremiumFrame clientView=new PremiumFrame(use);
		 new ClientControl(clientView,use);
		
		  clientView.setFrame();
		}
		else
		{
			RegularFrame reg= new RegularFrame(use);
			new RegularControl(reg, use);
			reg.setFrame();
		}
	 
	}
	else {
		JOptionPane.showMessageDialog(null, "Angajatul-ul nu exista!");

	}
	
}
}
}
