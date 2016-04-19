package gapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gapp_users")
public class GappUsers implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String lastname;

	private String firstname;

	private String email;

	private String password;

	private String CIN;

	private String phone;

	private String gender;

	private Date DOB;

	private String citizenship;

	/* @ManyToMany(cascade = CascadeType.ALL) */
	@ManyToMany
	List<GappUsersType> typeid;

	/*
	 * @OneToMany(mappedBy="id") List<GappAcademicRecords> arid;
	 */

	@OneToMany
	List<GappUserAdditional> addid;

	public GappUsers() {
		super();
	}

	public GappUsers(Integer id, String lastname, String firstname,
			String email, String password, String cIN, String phone,
			String gender, Date dOB, String citizenship,
			List<GappUsersType> typeid, List<GappUserAdditional> addid) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.password = password;
		CIN = cIN;
		this.phone = phone;
		this.gender = gender;
		DOB = dOB;
		this.citizenship = citizenship;
		this.typeid = typeid;
		this.addid = addid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public List<GappUsersType> getTypeid() {
		return typeid;
	}

	public void setTypeid(List<GappUsersType> typeid) {
		this.typeid = typeid;
	}

	public List<GappUserAdditional> getAddid() {
		return addid;
	}

	public void setAddid(List<GappUserAdditional> addid) {
		this.addid = addid;
	}

}
