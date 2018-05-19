package LogicTier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import BridgeShow.Comment;
import BridgeShow.Show;
import BridgeShow.ShowHibernate;
import DataTier.CommentHibernate;
import DataTier.Operations;
import DataTier.OperationsHibernate;
import DataTier.PremiumUser;
import DataTier.User;
import DataTier.UserHibernate;
import PresentationTier.PremiumFrame;

public class ClientControl implements ActionListener {
	private PremiumFrame emp;
	private User model;
	private List<Show> showsUser;
	private ShowHibernate showHibernate = new ShowHibernate();
	private OperationsHibernate op = new OperationsHibernate();

	public ClientControl(PremiumFrame m, User e) {
		this.model = e;
		this.emp = m;
		this.showsUser = op.getHistoryShows(model.getIdUser());
		this.emp.btnAddComment.addActionListener(this);
		this.emp.btnAddInterest.addActionListener(this);
		this.emp.btnRecomand.addActionListener(this);
		this.emp.btnSeeNotifications.addActionListener(this);
		this.emp.btnSearch.addActionListener(this);
		this.emp.btnGiveRating.addActionListener(this);
		this.emp.btnView.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == emp.btnSeeNotifications) {

			List<String> lista = model.getRec();
			String a = new String();
			if (lista != null) {
				for (int i = 0; i < lista.size(); i++) {
					a += lista.get(i) + " ";
				}
				emp.recomands.setText(a);
			} else {
				emp.recomands.setText("Nicio notificare");
			}

		}
		if (e.getSource() == emp.btnAddComment) {
			String nume_comment = new String(emp.textComment.getText());
			String nume_Show = new String(emp.textSearchShow.getText());
			CommentHibernate com = new CommentHibernate();
			Show s = showHibernate.getShowName(nume_Show);
			Comment c = new Comment(nume_comment, s);
			com.addCommentDAO(c, model.getName());
		}

		if (e.getSource() == emp.btnRecomand) {
			String nume_user = new String(emp.recomandtxt.getText());
			String nume_show_rec = new String(emp.showRecm.getText());
			UserHibernate us = new UserHibernate();
			User user = us.searchUser(nume_user);

			if (user.getType().equals("Premium")) { 
				List<String> lis = new ArrayList<String>();

				if (user.getRec() == null) {
					lis.add(nume_show_rec);
					user.setRec(lis);
					us.update(user.getIdUser(), user.getName(), user.getPas(), user.getType(),lis);
					System.out.println(user.getRec().get(0));
				} else {
					lis = user.getRec();
					lis.add(nume_show_rec);
					user.setRec(lis);
					us.update(user.getIdUser(), user.getName(), user.getPas(), user.getType(),lis);
				}
			
				JOptionPane.showMessageDialog(null, "S-a recomandat!");
			} else {
				JOptionPane.showMessageDialog(null, "Nu este premium!");

			}
		}
		if (e.getSource() == emp.btnAddInterest) {
			String nume_film = emp.textSearchShow.getText();
			Show s = showHibernate.getShowName(nume_film);
			op.addShowUser(this.model.getIdUser(), s.getIdShow());

			showsUser.add(s);
			for (Show sr : showsUser) {
				if (sr.getIdShow() == s.getIdShow()) {
					sr.attach(model);
				}
			}
			JOptionPane.showMessageDialog(null, "Succes!");
		}
		if (e.getSource() == emp.btnView) {

			afisareMedicamente();

		}
		if (e.getSource() == emp.btnSearch) {
			String nume = emp.textSearchShow.getText();
			List<Show> shows = showHibernate.searchShow(nume);
			afisareMedicamenteTotal(shows);

		}
		if (e.getSource() == emp.btnGiveRating) {
			String rating = emp.textRate.getText();
			double rate = Double.parseDouble(rating);
			String name = emp.textSearchShow.getText();
			Show sh = showHibernate.getShowName(name);
			double new_imdb = (rate + sh.getIMDB()) / sh.getImdb_notes();
			if (new_imdb <= 10) {
				sh.setImdb(new_imdb);

			} else {
				sh.setImdb(10.0);
			}
			sh.setImdb_notes(sh.getImdb_notes() + 1);

			showHibernate.update(sh);

			sh.notifyAllObservers();

			List<Show> shows = showHibernate.selectShows();
			JOptionPane.showMessageDialog(null, "Succes!");

			afisareMedicamenteTotal(shows);

		}

	}

	public void afisareMedicamenteTotal(List<Show> show) {
		this.emp.table_1.setRowCount(0);

		for (Object sh : show) {

			String[] ob = { String.valueOf(((Show) sh).getName()), String.valueOf(((Show) sh).getType()),
					String.valueOf(((Show) sh).getIdShow()), String.valueOf(((Show) sh).getDes()),
					String.valueOf(((Show) sh).getIMDB()), String.valueOf(((Show) sh).getActors()) };

			emp.table_1.addRow(ob);

		}
	}

	public void afisareMedicamente() {
		this.emp.table_1.setRowCount(0);

		for (Object sh : this.showsUser) {

			String[] ob = { String.valueOf(((Show) sh).getName()), String.valueOf(((Show) sh).getType()),
					String.valueOf(((Show) sh).getIdShow()), String.valueOf(((Show) sh).getDes()),
					String.valueOf(((Show) sh).getIMDB()), String.valueOf(((Show) sh).getActors()) };

			emp.table_1.addRow(ob);

		}
	}

}
