package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="gapp_additional")
public class GappAdditional implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer additionalid;
	
	private String additionalname;
	
	private String field;
	
	private boolean required;
	
	private String type;
	
	@ManyToOne
	GappDepartment deptid;

	public GappAdditional() {
		super();
	}

	public GappAdditional(Integer additionalid, String additionalname,
			String field, boolean required, String type, GappDepartment deptid) {
		super();
		this.additionalid = additionalid;
		this.additionalname = additionalname;
		this.field = field;
		this.required = required;
		this.type = type;
		this.deptid = deptid;
	}

	public Integer getAdditionalid() {
		return additionalid;
	}

	public void setAdditionalid(Integer additionalid) {
		this.additionalid = additionalid;
	}

	public String getAdditionalname() {
		return additionalname;
	}

	public void setAdditionalname(String additionalname) {
		this.additionalname = additionalname;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public GappDepartment getDeptid() {
		return deptid;
	}

	public void setDeptid(GappDepartment deptid) {
		this.deptid = deptid;
	}

	
	
	
}
