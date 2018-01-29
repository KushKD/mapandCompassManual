package Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Query {

	private int id;
	
	private int packageId;
	
	@NotNull(message="Name cannot be empty")
	@Size(min=3,message="Please enter valid name. Minimum length of name is 3")
	private String name;
	
	@NotNull(message="Email cannot be empty")
	@Email
	private String email;
	
	@NotNull(message="Mobile Number cannot be empty")
	@Size(max=10,min=10,message="Please enter valid mobile number. Minimum length of mobile number is 3")
	private String mobile;
	
	@NotNull(message="Message cannot be empty")
	@Size(min=10,message="Please enter message. Message must be at least 10 characters")
	private String message;
	
	@NotNull(message="Subject cannot be empty")
	@Size(min=3,message="Please enter Valid Name. Subject must be at least 10 characters")
	private String subject;
	
	@NotNull(message="Please enter counrty")
	private String country;
	
	private String entryDate;
	private String month;
	private String year;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Query [id=" + id + ", packageId=" + packageId + ", name=" + name + ", email=" + email + ", mobile="
				+ mobile + ", message=" + message + ", subject=" + subject + ", country=" + country + ", entryDate="
				+ entryDate + ", month=" + month + ", year=" + year + "]";
	}

	
	
	
	
	

}
