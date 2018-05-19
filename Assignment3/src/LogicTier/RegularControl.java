package LogicTier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.util.List;

import javax.swing.JOptionPane;

import BridgeShow.Comment;
import BridgeShow.Show;
import BridgeShow.ShowHibernate;
import DataTier.CommentHibernate;
import DataTier.OperationsHibernate;
import DataTier.User; 
import PresentationTier.RegularFrame;
 

public class RegularControl implements ActionListener {
	private RegularFrame emp;
	private User model; 
	private List<Show> showsUser; 
	private ShowHibernate showHibernate= new ShowHibernate(); 
	private OperationsHibernate op= new OperationsHibernate();
	public RegularControl(RegularFrame m, User e)
	{
		this.model= e;
		this.emp=m; 
		this.showsUser=op.getHistoryShows(model.getIdUser()); 
		this.emp.btnAddComment.addActionListener(this); 
		
		this.emp.btnSearch.addActionListener(this);
		this.emp.btnGiveRating.addActionListener(this);
		this.emp.btnView.addActionListener(this); 

	}
public void actionPerformed(ActionEvent e)
{
	if (e.getSource()==emp.btnAddComment)
	{	
	 String nume_comment= new String(emp.textComment.getText()); 
	 String nume_Show= new String(emp.textSearchShow.getText());
	 CommentHibernate com= new CommentHibernate();
	 Show s= showHibernate.getShowName(nume_Show);
		Comment c = new Comment(nume_comment, s);
		com.addCommentDAO(c,model.getName()); 
	}  
	if (e.getSource()==emp.btnView)
	{	
		 
		afisareMedicamente(); 
	  
	}
	if (e.getSource()==emp.btnSearch)
	{	
		String nume= emp.textSearchShow.getText();
	List<Show> shows=	showHibernate.searchShow(nume);
	afisareMedicamenteTotal(shows);
	
	}
	if (e.getSource()==emp.btnGiveRating)
	{
		String rating= emp.textRate.getText();
		double rate= Double.parseDouble(rating);
		double new_imdb;
		String name= emp.textSearchShow.getText();
		Show sh= showHibernate.getShowName(name);
		if (sh.getImdb_notes()!=0) {
		 new_imdb= (rate+sh.getIMDB())/sh.getImdb_notes();
		}
		else {
			new_imdb=rate;
		}
		sh.setImdb(new_imdb);
		sh.setImdb_notes(sh.getImdb_notes()+1);
		
		showHibernate.update(sh);
		
		sh.notifyAllObservers();
		
		List<Show> shows= showHibernate.selectShows();
		   JOptionPane.showMessageDialog(null, "Succes!");
			 
		afisareMedicamenteTotal(shows);
		
	}
	
		
		
}
public void afisareMedicamenteTotal(List<Show> show)
{
	   this.emp.table_1.setRowCount(0);
		
	    for (Object sh : show) {
	     	
	      String[] ob = { String.valueOf(((Show) sh).getName()),String.valueOf(((Show) sh).getType()),
	    		  String.valueOf(((Show) sh).getIdShow()),
	    		  String.valueOf(((Show)sh).getDes()),
	    		  String.valueOf(((Show)sh).getIMDB()),
	    		  String.valueOf(((Show)sh).getActors())
	      };
	  
	      emp.table_1.addRow(ob);
	      		 
	    			}  
}

public   void afisareMedicamente()  {
	   this.emp.table_1.setRowCount(0);
		
	    for (Object sh : this.showsUser) {
	     	
	      String[] ob = { String.valueOf(((Show) sh).getName()),String.valueOf(((Show) sh).getType()),
	    		  String.valueOf(((Show) sh).getIdShow()),
	    		  String.valueOf(((Show)sh).getDes()),
	    		  String.valueOf(((Show)sh).getIMDB()),
	    		  String.valueOf(((Show)sh).getActors())
	      };
	  
	      emp.table_1.addRow(ob);
	      		 
	    			}  
}

}
