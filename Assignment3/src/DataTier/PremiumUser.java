package DataTier;

import java.util.List;

import BridgeShow.Show; 
public class PremiumUser extends User implements ChangeMovies{
	private String nume; 
	public PremiumUser()
	{
		super();
	}
	public String getNume()
	{
		return this.nume;
	}
	 
	 

	@Override
	public void update(String m) {
		System.out.println("s-a modificat starea filmului numit " + m +" !");
		
	} 
}
