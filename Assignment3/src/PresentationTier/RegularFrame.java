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
 
import javax.swing.JButton;
	import javax.swing.JScrollPane;
import javax.swing.JTable; 
import DataTier.User;
	public class RegularFrame {
		public DefaultTableModel table_3  ;
		
		public JScrollPane scrollPane_1;
		public JTable table1;
		public DefaultTableModel table_1;
		public JFrame frame; 
		public JTextField textComment;
		private User us;
		public JButton btnView;
		public JTextField textSearchShow;
		public JTextField textRate;
		public JScrollPane scrollPane ;
		public JButton btnSearch ;
		public JButton btnGiveRating ;
		public JButton btnAddComment;
		 
		public RegularFrame()
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
		public RegularFrame(User us) {   
		this.us=us; 
		initialize();
	}
 
		  
		 
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 521, 417);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblViewHistory = new JLabel("View History:");
			lblViewHistory.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblViewHistory.setBounds(35, 194, 114, 19);
			frame.getContentPane().add(lblViewHistory);
			
			  btnView = new JButton("View");
			 
			btnView.setBounds(174, 192, 89, 23);
			frame.getContentPane().add(btnView);
			
			JLabel lblAddComment = new JLabel("Add comment:");
			lblAddComment.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblAddComment.setBounds(35, 114, 104, 24);
			frame.getContentPane().add(lblAddComment);
			
			textComment = new JTextField();
			textComment.setBounds(161, 117, 86, 20);
			frame.getContentPane().add(textComment);
			textComment.setColumns(10);
			
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
			table_1.addColumn("Comments");
			table1.setModel(table_1);
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(35, 224, 360, 143);
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
  
			
			btnGiveRating.setBounds(289, 75, 89, 23);
			frame.getContentPane().add(btnGiveRating);
			
			JLabel lblEnterRating = new JLabel("Enter rating:");
			lblEnterRating.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblEnterRating.setBounds(35, 77, 104, 16);
			frame.getContentPane().add(lblEnterRating);
			
			textRate = new JTextField();
			textRate.setBounds(151, 76, 86, 20);
			frame.getContentPane().add(textRate);
			textRate.setColumns(10);
			
			 btnAddComment = new JButton("Add Comment");
			btnAddComment.setBounds(281, 116, 125, 23);
			frame.getContentPane().add(btnAddComment);
			
			JLabel label = new JLabel("");
			label.setBounds(35, 202, 46, 14);
			frame.getContentPane().add(label);
		}
	}
