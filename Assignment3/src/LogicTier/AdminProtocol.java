package LogicTier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import BridgeShow.Movie;
import BridgeShow.Show;
import BridgeShow.ShowAfterAbstraction;
import BridgeShow.ShowBridge;
import BridgeShow.ShowHibernate;
import BridgeShow.Sport;
import BridgeShow.Theatre;
import DataTier.OperationsHibernate;
import DataTier.User;
import DataTier.UserHibernate;

public class AdminProtocol {

	private ShowHibernate showHibernate = new ShowHibernate();
	private OperationsHibernate historyHibernate = new OperationsHibernate();
	private UserHibernate userHibernate = new UserHibernate();

	/*
	 * theInput = Object[ Object[Object] ]
	 */
	public Data processInput(Data theInput) {
		Data theOutput = new Data(); 

		String methodName = (String) theInput.operatie;

		switch (methodName) {
		case "updateShow":
			updateShow(theInput.data.get(0));
			break;
		case "addShow":
			addShow(theInput.data.get(0));
			break;
		case "deleteShow":
			deleteShow(theInput.data.get(0));
			break;
		case "retriveAll":
			theOutput.data = retrieveAll();
			break;
		case "addUser":
			addUser(theInput.data.get(0));
			break;
		case "retrieveAllUsers":
			theOutput.data = retrieveAllUsers();
			break;
		case "updateUser":
			updateUser(theInput.data.get(0));
			break;
		case "deleteUser":
			deleteUser(theInput.data.get(0));
			break;
		default:
			theOutput = null;
			break;
		}

		return theOutput;
	}

	private void updateShow(Object[] data) {
		System.out.print("Admin Protocol: updateShow");
		int id = Integer.parseInt((String) data[2]);
		String name = (String) data[0];
		String description = (String) data[3];
		String type = (String) data[1];
		double imdb = (double) data[4];
		String actors = (String) data[5];

		Show show = new Show(id, type, actors, description, imdb, name, 1);

		showHibernate.update(show);
	}

	private void addShow(Object[] data) {
		System.out.print("Admin Protocol: addShow");
		int id = Integer.parseInt((String) data[2]);
		String name = (String) data[0];
		String description = (String) data[3];
		String type = (String) data[1];
		String nota=(String)data[4];
		double imdb = Double.parseDouble(nota);
		String actors = (String) data[5]; 

		Show show = new Show(id, type, actors, description, imdb, name, 1);

		ShowAfterAbstraction sb;
		if (type.equals("Movie")) {
			sb = new ShowAfterAbstraction(new Movie());
		} else if (type.equals("Sport")) {
			sb = new ShowAfterAbstraction(new Sport());
		} else
			sb = new ShowAfterAbstraction(new Theatre());

		showHibernate.add(show, sb);
	}

	private List<Object[]> retrieveAll() {

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

	private void addUser(Object[] data) {
		String id= (String)data[0];
		String username = (String) data[1];
		String password = (String) data[2];
		String premium;
		if (((String) data[3]).equals("Premium")) {
			premium = "Premium";
		} else
			premium = "Basic";

		userHibernate.addUser(id, username, password, premium);
	}

	private List<Object[]> retrieveAllUsers() {
		List<User> users = userHibernate.selectusers();
		List<Object[]> data = new ArrayList<Object[]>();
		System.out.println("Protocol: retrieveAll ");
		for (User u : users) {
			Object[] o = { u.getIdUser(), u.getName(), u.getType() };
			data.add(o);
		}
		return data;
	}

	private void updateUser(Object[] data) {
		int id = Integer.parseInt((String) data[0]);
		String username = (String) data[1];
		String password = (String) data[2];
		String premium;
		if (((String) data[3]).equals("Premium")) {
			premium = "Premium";
		} else
			premium = "Basic";
		userHibernate.update(id, username, password, premium);
	}

	public void deleteUser(Object[] data) {
		String id_s= (String) data[0];
		int id = Integer.parseInt(id_s.trim());
		userHibernate.delete(id);
	}

	public void deleteShow(Object[] data) {
		String id_s= (String) data[2];
		int id = Integer.parseInt(id_s.trim());
		showHibernate.delete(id);
	}
}
