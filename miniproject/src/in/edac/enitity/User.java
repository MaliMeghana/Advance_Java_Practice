package in.edac.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class User {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String fname;
	private String lname;
	@Column(unique = true)
	private String email;
	private String mobile;
	private String password;
	private String state;
	private String pincode;
	private String city;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String fname, String lname, String email, String mobile, String password, String state,
			String pincode, String city) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.state = state;
		this.pincode = pincode;
		this.city = city;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
