package BridgeShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
 
 
@Entity
@Table (name="`comment`")
public class Comment { 
	@Id 
	private int idcomment=1;
	private String comment;
	@ManyToOne
    @JoinColumn(name="idshow")
	private Show show; 
	public Comment(String a,Show s){
		this.idcomment=this.idcomment+1;
		this.comment=a;
		this.show=s;
	} 
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
 public Show getShow()
 {
	 return this.show;
 }
 public void setShow(Show a)
 {
	 this.show=a;
 }
}
