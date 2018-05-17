package PresentationTier;

import LogicTier.LoginController;
import PresentationTier.LoginFrame;

public class Main {
	public static void main(String [] args)
	{
	LoginFrame l= new LoginFrame();
	l.setFrame();
	LoginController cl= new LoginController(l);
}
}
