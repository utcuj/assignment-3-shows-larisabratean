package DataTier;

import java.util.List;

import BridgeShow.Show; 
public class PremiumUser extends User implements ChangeMovies{
	private String nume;
	private Show s;
	public PremiumUser(String n)
	{
		this.nume=n;
	}
	public String getNume()
	{
		return this.nume;
	}
	public boolean searchShow() {
		// TODO Auto-generated method stub
		return false;
	}
 
	
	public void recFriend()
	{
		
	}
	public void addInterest(Show s)
	{
		this.s=s;
		
	//	this.s.attach(this);
	}

	@Override
	public void update(String m) {
		System.out.println("s-a modificat starea filmului numit " + m +" !");
		
	}
 
}
