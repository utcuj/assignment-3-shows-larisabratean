package PresentationTier; 
 
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DataTier.Admin; 

import javax.swing.JLabel;
import java.awt.Font; 
import javax.swing.JButton; 
import javax.swing.JTable ;
import javax.swing.JScrollPane; 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List; 

public class AdminFrame {

	public JFrame frame;
	private Admin ad;
	public JTextField numeShow;
	public JTextField numeType;
	public JTextField numeActor;
	public JTextField descriere;
	public JTextField numeRate;
	public JTextField textNumeUser;
	public JButton btnAddShow ;
	public DefaultTableModel table_3,table_1;
	public JTable table,table1;
	public JButton btnDeleteShow ;
	
	public JButton btnUpdate ;
	
	public JButton btnVire ;
	 
	
	public JButton btnView;
	
	public JButton btnAddEmployee ;
	
	public JButton btnDeleteEmployee ;
	
	public JButton btnUpdateEmployee ;
	public JTextField idShow;
	public JLabel lblParola;
	public JTextField textParola;
	public JLabel lblType;

	 
	public JTextField textTip; 
	public JTextField textIduser;
	 
  
	public void cleanModel(){
        // remove all rows
        while (table1.getRowCount() > 0) {
            ((DefaultTableModel) table1.getModel()).removeRow(0);
        }
    }  
	public void cleanModel2(){
        // remove all rows
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
    }  
	public AdminFrame(Admin ad) {
		this.ad=ad;
	//	adminController = new  AdminController(this,this.ad);
		initialize(); 
		
	}  
	public JFrame getFrame()
	{
		return this.frame;
	}
	 
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 777, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		numeShow = new JTextField();
		numeShow.setBounds(151, 47, 86, 20);
		frame.getContentPane().add(numeShow);
		numeShow.setColumns(10);
		
		JLabel lblOperationsForMedicine = new JLabel("Operations for Shows");
		lblOperationsForMedicine.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblOperationsForMedicine.setBounds(33, 24, 184, 14);
		frame.getContentPane().add(lblOperationsForMedicine);
		
		JLabel lblOperationsForEmployees = new JLabel("Operations for Employees:");
		lblOperationsForEmployees.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblOperationsForEmployees.setBounds(410, 24, 184, 14);
		frame.getContentPane().add(lblOperationsForEmployees);
		
		JLabel lblNume = new JLabel("Nume:");
		lblNume.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNume.setBounds(33, 49, 46, 14);
		frame.getContentPane().add(lblNume);
		
		JLabel lblManufacter = new JLabel("Type:");
		lblManufacter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblManufacter.setBounds(33, 74, 79, 14);
		frame.getContentPane().add(lblManufacter);
		
		JLabel lblIngredients = new JLabel("Actors:");
		lblIngredients.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIngredients.setBounds(33, 99, 79, 20);
		frame.getContentPane().add(lblIngredients);
		
		JLabel lblPrice = new JLabel("Rate:");
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPrice.setBounds(33, 130, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Description:");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblQuantity.setBounds(33, 155, 86, 14);
		frame.getContentPane().add(lblQuantity);
		
		numeType = new JTextField();
		numeType.setText("");
		numeType.setBounds(151, 72, 86, 20);
		frame.getContentPane().add(numeType);
		numeType.setColumns(10);
		
		numeActor = new JTextField();
		numeActor.setBounds(151, 100, 86, 20);
		frame.getContentPane().add(numeActor);
		numeActor.setColumns(10);
		
		descriere = new JTextField();
		descriere.setText("");
		descriere.setBounds(151, 153, 86, 20);
		frame.getContentPane().add(descriere);
		descriere.setColumns(10);
		
		numeRate = new JTextField();
		numeRate.setBounds(151, 128, 86, 20);
		frame.getContentPane().add(numeRate);
		numeRate.setColumns(10);
		table1=new JTable();
		table_1= new DefaultTableModel();
		//shows
		table_1.addColumn("Nume");
		table_1.addColumn("Type");
		table_1.addColumn("ID");  
		table_1.addColumn("Descrp");
		table_1.addColumn("Rate");
		table_1.addColumn("Actors");
		table1.setModel(table_1); 
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 231, 389, 100);
		scrollPane.setViewportView(table1);
		frame.getContentPane().add(scrollPane);
		table=new JTable();
		table_3= new DefaultTableModel();
		 
		table_3.addColumn("ID");
		table_3.addColumn("Name");
		table_3.addColumn("Type"); 
		table.setModel(table_3);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(459, 211, 251, 100);
		scrollPane_1.setViewportView(table);
		frame.getContentPane().add(scrollPane_1);
		
		textNumeUser = new JTextField();
		textNumeUser.setBounds(505, 72, 86, 20);
		frame.getContentPane().add(textNumeUser);
		textNumeUser.setColumns(10);
		
		JLabel label = new JLabel("Nume:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label.setBounds(411, 74, 46, 14);
		frame.getContentPane().add(label);
		btnAddShow = new JButton("Add");
		 
		btnAddShow.setBounds(17, 186, 95, 23);
		frame.getContentPane().add(btnAddShow);
		
	 btnDeleteShow = new JButton("Delete"); 
		 
		btnDeleteShow.setBounds(122, 186, 89, 23);
		frame.getContentPane().add(btnDeleteShow);
		
	 btnUpdate = new JButton("Update");
	 
		btnUpdate.setBounds(227, 186, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
	 btnVire = new JButton("View");
	 
		btnVire.setBounds(115, 354, 89, 23);
		frame.getContentPane().add(btnVire);
		
		
	 btnView = new JButton("View Employees");
 
		btnView.setBounds(574, 177, 121, 23);
		frame.getContentPane().add(btnView);
		
		btnAddEmployee = new JButton("Add Employee");

		 
		btnAddEmployee.setBounds(428, 152, 121, 23);
		frame.getContentPane().add(btnAddEmployee);
		
		 btnDeleteEmployee = new JButton("Delete Employee");
		 
		btnDeleteEmployee.setBounds(428, 177, 121, 23);
		frame.getContentPane().add(btnDeleteEmployee);
		
		 btnUpdateEmployee = new JButton("Update Employee");
		  
		btnUpdateEmployee.setBounds(574, 152, 121, 23);
		frame.getContentPane().add(btnUpdateEmployee);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(201, 16, 79, 20);
		frame.getContentPane().add(lblId);
		
		idShow = new JTextField();
		idShow.setBounds(290, 18, 86, 20);
		frame.getContentPane().add(idShow);
		idShow.setColumns(10);
		
		lblParola = new JLabel("Parola:");
		lblParola.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblParola.setBounds(410, 103, 46, 14);
		frame.getContentPane().add(lblParola);
		
		textParola = new JTextField();
		textParola.setBounds(505, 100, 86, 20);
		frame.getContentPane().add(textParola);
		textParola.setColumns(10);
		
		lblType = new JLabel("Type:");
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblType.setBounds(411, 131, 46, 14);
		frame.getContentPane().add(lblType);
		
		textTip = new JTextField();
		textTip.setBounds(505, 128, 86, 20);
		frame.getContentPane().add(textTip);
		textTip.setColumns(10);
		
		JLabel label_1 = new JLabel("Id:");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_1.setBounds(410, 50, 79, 20);
		frame.getContentPane().add(label_1);
		
		textIduser = new JTextField();
		textIduser.setBounds(508, 47, 86, 20);
		frame.getContentPane().add(textIduser);
		textIduser.setColumns(10);
	 
	} 
	 
	public void setFrame()
	{
		this.frame.setVisible(true);
	}
}
