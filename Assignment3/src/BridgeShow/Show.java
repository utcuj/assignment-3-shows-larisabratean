package BridgeShow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import javax.persistence.OneToMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import DataTier.PremiumUser;
import DataTier.User; 
@Entity
@Table (name="`show`")
public class Show {
	@Id  
@Column(name="idshow",unique=true, nullable=false)
	private int idshow; 
	private String type; 
	private String actors; 
	private String description ; 
	private double imdb_rate; 
	private int imdb_notes;
	@Column (name = "name")

	private String name; 
	private int idadmin; 
	@OneToMany(mappedBy = "show")
	private List<Comment> comments;
	@ManyToMany( fetch = FetchType.EAGER, mappedBy = "shows", cascade = CascadeType.ALL  )
	private List<User> users;
	@Transient 
	private int state;
	public Show()
	{
		
	} 
	public Show(int id, String name, String desc, String actors, double rating, int id_a)
	{
		this.name=name;
		this.idshow=id;
		this.idadmin=1;
		this.description=desc;
		this.actors=actors;
		this.imdb_rate=0.0;
	} 
	public Show(int id,  String actors, String d, double imdb_rate, String name,int idamin)
	{
		this.idadmin=idamin;
		this.idshow=id;
		this.actors=actors; 
		this.description=d;
		this.imdb_rate=imdb_rate;
		this.name=name;
	}
	public Show(int id, String type, String name, String d,  String actors, double imdb_rate,int idamin)
	{
		this.idadmin=idamin;
		this.idshow=id;
		this.type=type;
		this.actors=actors; 
		this.description=d;
		this.imdb_rate=imdb_rate;
		this.name=name;
	}
	 public int getState()
	{
		return state;
	}
	public void setState(int s)
	{
		this.state=s;
	 	notifyAllObservers();
	}
	public void attach(User e)
	{
		this.users.add(e);
	}
	public void notifyAllObservers()
	{
		for (User a: users)
		{
			a.update(this.name);
		}
	} 

public void setIdShow(int id)
{
	this.idshow=id;
}

public void setIdA(int id)
{
	this.idadmin=id;
}
public void setType(String a)
{
	this.type=a;
}
public void setActor(String a)
{
	this.actors=a;
}  
public void setDesc(String a)
{
	this.description=a;
}

public void setName(String a)
{
	this.name=a;
}

public void setImdb(double d)
{
	this.imdb_rate=d;
}

public String getDes()
{
	return this.description;
}

public String getActors()
{
	return this.actors;
}
public String getName()
{
	return this.name;
}


public String getType()
{
	return this.type;
}
public int getIdShow() {
	return this.idshow;
}

public int getIdAdm()
{
return this.idadmin;
}
public double getIMDB()
{
	return this.imdb_rate;
}
public int getImdb_notes() {
	return imdb_notes;
}
public void setImdb_notes(int imdb_notes) {
	this.imdb_notes = imdb_notes;
}
public List<Comment> getComments() {
	return comments;
}
public void setComments(List<Comment> comments) {
	this.comments = comments;
}

}
