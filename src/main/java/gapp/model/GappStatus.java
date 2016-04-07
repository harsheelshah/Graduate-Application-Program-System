package gapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gapp_status")
public class GappStatus implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer statid;
	
	private String name;
	
	private String desription;

	public GappStatus() {
		super();
	}

	public GappStatus(Integer statid, String name, String desription) {
		super();
		this.statid = statid;
		this.name = name;
		this.desription = desription;
	}

	public Integer getStatid() {
		return statid;
	}

	public void setStatid(Integer statid) {
		this.statid = statid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}
	
	
	
}
