package gapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="gapp_applications")
public class GappApplication implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer appid;
	
	private String GRE;
	
	private String TOEFL;
	
	private String term;
	
	private Date Date;
	
	private String applicantfirstname;
	
	private String applicantlastname;
	
	private String applicantemail;
	
	private String CIN;
	
	private String phone;
	
	private String gender;
	
	private String DOB;
	
	private String citizenship;
	
	
	@OneToOne
    private GappFile transcript;
	
	@OneToOne
	GappUsers id;
	
	@OneToOne(orphanRemoval=true)
	GappProgram prgmid;
	
	@OneToOne
	GappApplicationStatus statusid;
	
	@OneToMany(mappedBy="appid")
	List<GappAcademicRecords> arid;

	public GappApplication() {
		super();
	}

	public GappApplication(Integer appid, String gRE, String tOEFL,
			String term, java.util.Date date, String applicantfirstname,
			String applicantlastname, String applicantemail, String cIN,
			String phone, String gender, String dOB, String citizenship,
			GappFile transcript, GappUsers id, GappProgram prgmid,
			GappApplicationStatus statusid, List<GappAcademicRecords> arid) {
		super();
		this.appid = appid;
		GRE = gRE;
		TOEFL = tOEFL;
		this.term = term;
		Date = date;
		this.applicantfirstname = applicantfirstname;
		this.applicantlastname = applicantlastname;
		this.applicantemail = applicantemail;
		CIN = cIN;
		this.phone = phone;
		this.gender = gender;
		DOB = dOB;
		this.citizenship = citizenship;
		this.transcript = transcript;
		this.id = id;
		this.prgmid = prgmid;
		this.statusid = statusid;
		this.arid = arid;
	}

	public Integer getAppid() {
		return appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public String getGRE() {
		return GRE;
	}

	public void setGRE(String gRE) {
		GRE = gRE;
	}

	public String getTOEFL() {
		return TOEFL;
	}

	public void setTOEFL(String tOEFL) {
		TOEFL = tOEFL;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getApplicantfirstname() {
		return applicantfirstname;
	}

	public void setApplicantfirstname(String applicantfirstname) {
		this.applicantfirstname = applicantfirstname;
	}

	public String getApplicantlastname() {
		return applicantlastname;
	}

	public void setApplicantlastname(String applicantlastname) {
		this.applicantlastname = applicantlastname;
	}

	public String getApplicantemail() {
		return applicantemail;
	}

	public void setApplicantemail(String applicantemail) {
		this.applicantemail = applicantemail;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public GappFile getTranscript() {
		return transcript;
	}

	public void setTranscript(GappFile transcript) {
		this.transcript = transcript;
	}

	public GappUsers getId() {
		return id;
	}

	public void setId(GappUsers id) {
		this.id = id;
	}

	public GappProgram getPrgmid() {
		return prgmid;
	}

	public void setPrgmid(GappProgram prgmid) {
		this.prgmid = prgmid;
	}

	public GappApplicationStatus getStatusid() {
		return statusid;
	}

	public void setStatusid(GappApplicationStatus statusid) {
		this.statusid = statusid;
	}

	public List<GappAcademicRecords> getArid() {
		return arid;
	}

	public void setArid(List<GappAcademicRecords> arid) {
		this.arid = arid;
	}

	
	
	
}
