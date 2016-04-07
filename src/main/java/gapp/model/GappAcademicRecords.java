package gapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="gapp_academic_records")
public class GappAcademicRecords  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer arid;
	
	private String collegename;
	
	private String timeattended;
	
	private String degreeearned;
	
	private String major;
	
	private String GPA;
	
	@ManyToOne
	GappApplication appid;

	public GappAcademicRecords() {
		super();
	}

	public GappAcademicRecords(Integer arid, String collegename,
			String timeattended, String degreeearned, String major, String gPA,
			GappApplication appid) {
		super();
		this.arid = arid;
		this.collegename = collegename;
		this.timeattended = timeattended;
		this.degreeearned = degreeearned;
		this.major = major;
		GPA = gPA;
		this.appid = appid;
	}

	public Integer getArid() {
		return arid;
	}

	public void setArid(Integer arid) {
		this.arid = arid;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getTimeattended() {
		return timeattended;
	}

	public void setTimeattended(String timeattended) {
		this.timeattended = timeattended;
	}

	public String getDegreeearned() {
		return degreeearned;
	}

	public void setDegreeearned(String degreeearned) {
		this.degreeearned = degreeearned;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGPA() {
		return GPA;
	}

	public void setGPA(String gPA) {
		GPA = gPA;
	}

	public GappApplication getAppid() {
		return appid;
	}

	public void setAppid(GappApplication appid) {
		this.appid = appid;
	}

	

}
