package LogicTier;

import java.util.ArrayList;
import java.util.List;

import BridgeShow.ShowHibernate;
import DataTier.OperationsHibernate;
import DataTier.User;
import DataTier.UserHibernate;
import BridgeShow.Show;

public class ClientProtocol {
	private Show sh= new Show();
	private ShowHibernate showHibernate = new ShowHibernate();
	private OperationsHibernate historyHibernate = new OperationsHibernate();
	private UserHibernate userHibernate= new UserHibernate();
	public Data procesare(Data theInput) {
		Data output = new Data();
		int id_user;
		int id_show;
		String operatie = (String) theInput.operatie;
		switch (operatie) {
		case "search":
			String name = (String) theInput.data.get(0)[0];
			output.data = search(name);
			break;
		case "getData":
			output.data = getData();
			break;
		case "addShowUser":
			id_user = (int) theInput.data.get(0)[0];
			id_show = (int) theInput.data.get(1)[0];
			addShow(id_user, id_show);
			break;
		case "getShows":
			id_user = (int) theInput.data.get(0)[0];
			output.data = getShows(id_user);
			break;
		case "updateShow":
			updateS(theInput.data.get(0));
			break;
		default:
			output = null;
			break;
		}
		return output;
	}

	private List<Object[]> getData() {
		List<Show> shows = showHibernate.selectShows();
		List<Object[]> data = new ArrayList<Object[]>();
		System.out.println("Protocol: getData ");
		for (Show s : shows) {
			Object[] o = { s.getName(), s.getType(), s.getIdShow(), s.getDes(), s.getIMDB(), s.getActors() };
			data.add(o);
			System.out.println(s.getName());
		}
		return data;
	}

	private List<Object[]> search(String name) {
		List<Show> shows = showHibernate.searchShow(name);
		List<Object[]> data = new ArrayList<Object[]>();
		for (Show s : shows) {
			Object[] o = { s.getName(), s.getType(), s.getDes(), s.getIMDB(), s.getActors(), s.getIdShow() };
			data.add(o);

		}
		return data;
	}

	private void addShow(int id, int ids) {
		Show sh=showHibernate.getShow(ids);
		User us= userHibernate.getUserId(id);
		sh.attach(us);
		historyHibernate.addShowUser(id, ids);

	}

	private List<Object[]> getShows(int id) {
		List<Show> shows = historyHibernate.getHistoryShows(id);
		List<Object[]> data = new ArrayList<Object[]>();
		System.out.println("Protocol: getHistoryshows ");
		for (Show s : shows) {
			Object[] o = { s.getIdShow(), s.getName(), s.getType(), s.getDes(), s.getIMDB(), s.getActors() };
			data.add(o);
			System.out.println(o[1]);
		}
		return data;
	}

	private void updateS(Object[] data) {

		int id = (int) data[0];
		String name = (String) data[1];
		String description = (String) data[3];
		String type = (String) data[2];
		double imdb = (double) data[4];
		String actors = (String) data[6];
		Show sh = new Show(id, type, actors, description, imdb, name, 1);
		sh.notifyAllObservers();
		showHibernate.update(sh);
	}
}
