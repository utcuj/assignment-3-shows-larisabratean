package DataTier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name="`admin`")
public class Admin {
	@Id

@GeneratedValue(strategy=GenerationType.AUTO)
private int adm; 
private String nume;
private String password;

public int getId()
{
	return this.adm;
	
}
public String getNume()
{
	return this.nume;
	
}
public String getPass()
{
	return this.password;
}
}
