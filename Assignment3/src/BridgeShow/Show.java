package BridgeShow;

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

import DataTier.PremiumUser;
import DataTier.User;
@Entity
@Table (name="`show`")
public class Show {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
@Column(name="idshow",unique=true, nullable=false)
	private int idshow; 
	private String type; 
	private String actors; 
	private String description ; 
	private double imdb_rate; 
	@Column (name = "name")

	private String name; 
	private int idadmin;
	@ManyToMany( fetch = FetchType.LAZY, mappedBy = "shows", cascade = CascadeType.ALL  )
	private List<User> users;
	@Transient
	
	private int state;
	public Show()
	{
		
	}
	//public User getOBs()
	//{
	//	return ((Object) this.obs).get(0);
	//}
	public Show(int id,  String actors, String d, double imdb_rate, String name,int idamin)
	{
		this.idadmin=idamin;
		this.idshow=id;
		this.actors=actors; 
		this.description=d;
		this.imdb_rate=imdb_rate;
		this.name=name;
	}
	public Show(int id, String type, String actors, String d, double imdb_rate, String name,int idamin)
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

}
