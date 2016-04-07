package gapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gapp_application_status")
public class GappApplicationStatus implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer statusid;
	
	private String name;
	
	private String comments;

	public GappApplicationStatus() {
		super();
	}

	public GappApplicationStatus(Integer statusid, String name,
			 String comments) {
		super();
		this.statusid = statusid;
		this.name = name;
		
		this.comments = comments;
	}

	public Integer getStatusid() {
		return statusid;
	}

	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	
}
