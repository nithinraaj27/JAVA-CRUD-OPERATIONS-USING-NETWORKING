package Third;

import java.io.Serializable;

public class util implements Serializable{

	private String username = "";
	private String name = "";
	private String dob = "";
	private String age = "";
	private String address = "";
	private String mob = "";
	private String gender = "";
	private String password ="";
	private String repass = "";
	private String alt_mob = "";
	private String pin = "";
	private String state = "";
	private String marital = "";
	
	util(String username,String name,String dob,String age,String address,String mob,String gender,String password,String repass,String alt_mob,String pin,String state,String marital)
	{
		this.username = username;
		this.name = name;
		this.dob = dob;
		this.age = age;
		this.address = address;
		this.mob = mob;
		this.gender = gender;
		this.password = password;
		this.repass = repass;
		this.alt_mob = alt_mob;
		this.pin = pin;
		this.state = state;
		this.marital = marital;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}
	
	public String getDob() {
		return dob;
	}
	
	public String getAge() {
		return age;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getMob() {
		return mob;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getRepass() {
		return repass;
	}
	
	public String getAlt_mob() {
		return alt_mob;
	}
	
	public String getPin() {
		return pin;
	}
	
	public String getState() {
		return state;
	}
	
	public String getMarital() {
		return marital;
	}

}
