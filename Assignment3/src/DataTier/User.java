package DataTier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import BridgeShow.Show;

@Entity
@Table(name="`user`")
public class User   {  
   
@Id 
private int iduser;
private String password;
private String nume;
private String type; 
@Transient
private List<String> rec;
private   int id_admin=4;
	//public abstract boolean searchShow();//select and view also
//	public abstract String viewHistory();
	//public abstract void giveRate();
//	public abstract void addComment(); 
@ManyToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }  )
@JoinTable(
      name = "operations", 
       joinColumns = {@JoinColumn(name = "iduser")},
       inverseJoinColumns = {@JoinColumn(name = "idshow")}
 )
private List<Show> shows;
public User()
{

}
public User (int id1 , String nume, String password, String type, int id)
{
	this.iduser=id1;
	this.password=password;
	this.nume=nume;
	this.type=type;
 this.id_admin=id;
}

public User(int id, String username, String password, String premium) {
	this.iduser=id;
	this.nume = username;
	this.password = password; 
	this.type = premium;
}

public List<Show> getSh()
{
	return this.shows;
}
public void setShows(List<Show> s)
{
	this.shows=s;
	
}
public void setPass(String a)
{
	this.password=a;
}
public void setName(String a)
{
	this.nume=a;
}
public void setIdA(int id)
{
	this.id_admin=id;
}
public void setType(String a)
{
	this.type=a;
}
public void setIdUser(int a)
{
	this.iduser=a;
}


public String getPas()
{
	return this.password;
}

public String getName()
{
	return this.nume;
}

public String getType()
{
	return this.type;
}
public int getIdUser() {
	return this.iduser;
}

public int getIdAdm()
{
return this.id_admin;
}

public void addInterest(Show s)
{
	this.shows.add(s);
	for (Show sr: shows) {
	if (sr.getIdShow()==s.getIdShow())
	{
		sr.attach(this);
	}
	} 
}

public void update(String name) {
	if (this.type.equals("Premium"))
System.out.println("Buna ziua, "+this.getName()+"! Serialul "+name+" s-a modificat!");	
}
public List<String> getRec() {
	return rec;
}
public void setRec(List<String> rec) {
	this.rec = rec;
}
}
