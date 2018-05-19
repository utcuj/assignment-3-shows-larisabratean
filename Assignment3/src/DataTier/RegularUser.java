package DataTier;

 
public class RegularUser extends User implements ChangeMovies{
	private String nume; 
	public RegularUser()
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
