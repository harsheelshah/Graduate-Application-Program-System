package gapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="gapp_program")
public class GappProgram implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer prgmid;
	
	private String programname;
	
	@ManyToOne
	@JsonIgnore	
	GappDepartment deptid;

	public GappProgram() {
		super();
	}

	public GappProgram(Integer prgmid, String programname, GappDepartment deptid) {
		super();
		this.prgmid = prgmid;
		this.programname = programname;
		this.deptid = deptid;
	}

	public Integer getPrgmid() {
		return prgmid;
	}

	public void setPrgmid(Integer prgmid) {
		this.prgmid = prgmid;
	}

	public String getProgramname() {
		return programname;
	}

	public void setProgramname(String programname) {
		this.programname = programname;
	}

	public GappDepartment getDeptid() {
		return deptid;
	}

	public void setDeptid(GappDepartment deptid) {
		this.deptid = deptid;
	}

	
	
}
