package DataTier;
 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="`operations")
public class Operations {
private int id_user;
private int show_id;
private int rating;
private String comment;
private String date;
public Operations()
{
	
}
public Operations(int idu, int idshow)
{
	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	Date dateobj = new Date();

	this.id_user=idu;
	this.show_id=idshow;
	this.date= df.format(dateobj);
}
public int getUser()
{
	return this.id_user;
}
public int getShowID()
{
	return this.show_id;
}

public int getRate()
{
	return this.rating;
}
public String getComent()
{
	return this.comment;
}
public void setShow(int id)
{
	this.show_id=id;
}
public void setUs(int id)
{
	this.id_user=id;
}
public void setRating(int r)
{
	this.rating=r;
}
public void setComment(String c)
{
	this.comment=c;
}
public void setDate(String d)
{
	this.date=d;
}
public String getDate()
{
	return this.date;
}
}
