package PresentationTier; 
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BridgeShow.Show;

import javax.swing.JButton;
	import javax.swing.JScrollPane;
import javax.swing.JTable; 
import DataTier.User;
	public class PremiumFrame {
		public DefaultTableModel table_3  ;
		
		public JScrollPane scrollPane_1;
		public JTable table1;
		public DefaultTableModel table_1;
		public JFrame frame; 
		public JTextField textComment;
		private User us;
		public JButton btnRecomand;
		public JButton btnAddInterest;
		public JButton btnView;
		public JTextField textSearchShow;
		public JTextField textRate;
		public JScrollPane scrollPane ;
		public JButton btnSearch ;
		public JButton btnGiveRating ;
		public JButton btnAddComment;
		public JTextField recomandtxt;
		public JTextField recomands;
		private JLabel lblTheShow;
		public JTextField showRecm;
		public JButton btnSeeNotifications;
		 
		public PremiumFrame()
		{
			
		}

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						PremiumFrame window = new PremiumFrame();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		public void setFrame()
		{
			this.frame.setVisible(true);
		} 

		/**
		 * Create the application.
		 * @wbp.parser.entryPoint
		 */
		public PremiumFrame(User us) {  System.out.println("View");
		this.us=us; 
		initialize();
	}
 
		  
		 
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 798, 417);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblViewHistory = new JLabel("View History:");
			lblViewHistory.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblViewHistory.setBounds(394, 195, 114, 19);
			frame.getContentPane().add(lblViewHistory);
			
			  btnView = new JButton("View");
			 
			btnView.setBounds(519, 193, 89, 23);
			frame.getContentPane().add(btnView);
			
			JLabel lblAddComment = new JLabel("Add comment:");
			lblAddComment.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblAddComment.setBounds(35, 168, 104, 24);
			frame.getContentPane().add(lblAddComment);
			
			textComment = new JTextField();
			textComment.setBounds(151, 171, 86, 20);
			frame.getContentPane().add(textComment);
			textComment.setColumns(10);
			
			 btnAddInterest = new JButton("Add Interest");
			 
			btnAddInterest.setBounds(295, 74, 114, 23);
			frame.getContentPane().add(btnAddInterest);
			
			JLabel lblAddInterestTo = new JLabel("Add interest to the show: ");
			lblAddInterestTo.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblAddInterestTo.setBounds(35, 76, 191, 16);
			frame.getContentPane().add(lblAddInterestTo);
			
			textSearchShow = new JTextField();
			textSearchShow.setBounds(217, 35, 86, 20);
			frame.getContentPane().add(textSearchShow);
			textSearchShow.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Hello!");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblNewLabel.setBounds(21, 7, 46, 14);
			frame.getContentPane().add(lblNewLabel);
			table_3= new DefaultTableModel();
			
			table_3.addColumn("Nume");
			table1=new JTable();
			table_1= new DefaultTableModel();
		    
			table_1.addColumn("Name");
			table_1.addColumn("Type");
			table_1.addColumn("ID");
			table_1.addColumn("Description");
			table_1.addColumn("IMDB note");
			table_1.addColumn("Actors");
			table1.setModel(table_1);
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(394, 227, 360, 143);
			scrollPane_1.setViewportView(table1);
			frame.getContentPane().add(scrollPane_1);
			 btnSearch = new JButton("Search");
			 
			btnSearch.setBounds(336, 34, 89, 23);
			frame.getContentPane().add(btnSearch);
			
			JLabel lblShow = new JLabel("Modify the show with name:");
			lblShow.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblShow.setBounds(35, 37, 177, 14);
			frame.getContentPane().add(lblShow);
			
			  btnGiveRating = new JButton("Give Rating");
  
			
			btnGiveRating.setBounds(272, 139, 114, 23);
			frame.getContentPane().add(btnGiveRating);
			
			JLabel lblEnterRating = new JLabel("Enter rating:");
			lblEnterRating.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblEnterRating.setBounds(35, 141, 104, 16);
			frame.getContentPane().add(lblEnterRating);
			
			textRate = new JTextField();
			textRate.setBounds(151, 140, 86, 20);
			frame.getContentPane().add(textRate);
			textRate.setColumns(10);
			
			 btnAddComment = new JButton("Add Comment");
			btnAddComment.setBounds(272, 170, 125, 23);
			frame.getContentPane().add(btnAddComment);
			
			JLabel label = new JLabel("");
			label.setBounds(35, 202, 46, 14);
			frame.getContentPane().add(label);
			
			JLabel lblRecomandToThe = new JLabel("Recomand to the user: ");
			lblRecomandToThe.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblRecomandToThe.setBounds(21, 222, 177, 24);
			frame.getContentPane().add(lblRecomandToThe);
			
			recomandtxt = new JTextField();
			recomandtxt.setBounds(178, 225, 86, 20);
			frame.getContentPane().add(recomandtxt);
			recomandtxt.setColumns(10);
			
			 btnRecomand = new JButton("Recomand");
			btnRecomand.setBounds(85, 307, 141, 23);
			frame.getContentPane().add(btnRecomand);
			
			recomands = new JTextField();
			recomands.setBounds(465, 35, 250, 127);
			frame.getContentPane().add(recomands);
			recomands.setColumns(10);
			
			lblTheShow = new JLabel("the show: ");
			lblTheShow.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblTheShow.setBounds(21, 257, 104, 24);
			frame.getContentPane().add(lblTheShow);
			
			showRecm = new JTextField();
			showRecm.setBounds(178, 257, 86, 20);
			frame.getContentPane().add(showRecm);
			showRecm.setColumns(10);
			
			btnSeeNotifications = new JButton("See notifications: ");
			btnSeeNotifications.setBounds(519, 4, 135, 23);
			frame.getContentPane().add(btnSeeNotifications);
		}
	}
