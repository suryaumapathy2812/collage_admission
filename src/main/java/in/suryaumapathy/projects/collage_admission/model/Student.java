package in.suryaumapathy.projects.collage_admission.model;

import java.sql.Date;

import com.google.protobuf.Timestamp;

public class Student {

	private int id;
	private String name;
	private String email;
	private long mobileNo;
	private String password;
	private char gender;
	private Date dob;
	private Timestamp createdDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
	
	@Override
	public String toString() {
	    return "Student{" +
	            "id=" + id +
	            ", name='" + name + '\'' +
	            ", email='" + email + '\'' +
	            ", mobileNo=" + mobileNo +
	            ", password='" + password + '\'' +
	            ", gender=" + gender +
	            ", dob=" + dob +
	            ", createdDate=" + createdDate +
	            '}';
	}
	
	
}
