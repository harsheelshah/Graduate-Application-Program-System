package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="gapp_department")
public class GappDepartment implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer deptid;
	
	private String departmentname;
	
	@OneToMany(mappedBy="deptid")
	List<GappProgram> prgmid;
	
	@OneToMany(mappedBy="deptid")
	List<GappAdditional> additionalid;

	public GappDepartment() {
		super();
	}

	public GappDepartment(Integer deptid, String departmentname,
			List<GappProgram> prgmid, List<GappAdditional> additionalid) {
		super();
		this.deptid = deptid;
		this.departmentname = departmentname;
		this.prgmid = prgmid;
		this.additionalid = additionalid;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public List<GappProgram> getPrgmid() {
		return prgmid;
	}

	public void setPrgmid(List<GappProgram> prgmid) {
		this.prgmid = prgmid;
	}

	public List<GappAdditional> getAdditionalid() {
		return additionalid;
	}

	public void setAdditionalid(List<GappAdditional> additionalid) {
		this.additionalid = additionalid;
	}

	
	
}
