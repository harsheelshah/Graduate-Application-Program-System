package gapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gapp_users_type")
public class GappUsersType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer typeid;
	
	private String type;

	
	
	public GappUsersType() {
		super();
	}



	public GappUsersType(Integer typeid, String type) {
		super();
		this.typeid = typeid;
		this.type = type;
	}



	public Integer getTypeid() {
		return typeid;
	}



	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}




}
