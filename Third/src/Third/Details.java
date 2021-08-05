package Third;

import java.io.Serializable;
import java.text.SimpleDateFormat;


public class Details implements Serializable{

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
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		if(username.contains("@") && !username.isEmpty() && !username.equals("SELECT USERNAME"))
		{
			this.username = username;
		}
	}
	
	/////////////////////////////
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name.length() > 5 && !name.isEmpty())
		{
			this.name = name;
		}
	}
	/////////////////////////////
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		boolean bool = false;
		if(!dob.isEmpty()) {
			bool = true;
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        dateFormat.setLenient(false);
	        try {
	            dateFormat.parse(dob.trim());
	        } catch (Exception pe) {
	            bool = false;
	        }
		}
		if(bool) {
			this.dob = dob;
		}			
		//this.dob = dob;
	}
	////////////////////////////////
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		int ag = 0;
			if(!age.isEmpty())
			{
				try
				{
					ag = Integer.parseInt(age);
				}
				catch (Exception e) {
					ag = 0;
				}
				
				if(ag != 0)
				{
					this.age = age;
				}
			}
	}
	
	////////////////////////////////
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
			if(!gender.isEmpty())
			{
				this.gender = gender;
			}
	}
	////////////////////////////////
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		if(password.length() > 7 && !password.isEmpty())
		{
			this.password = password;
		}
	}
	/////////////////////////////////
	
	public void setRepass(String repass) {
		if(repass.equals(password) && !repass.isEmpty())
		{
			this.repass = repass;
		}
	}
	
	public String getRepass() {
		return repass;
	}
	//////////////////////////////////
	
	public String getMob() {
		return mob;
	}
	
	public void setMob(String mob) {
		if(mob.length() == 10 && !mob.isEmpty())
		{
			this.mob = mob;
		}
	}
	//////////////////////////////////
	
	public String getAlt_mob() {
		return alt_mob;
	}
	
	public void setAlt_mob(String alt_mob) {
		if(alt_mob.length() == 10 && !alt_mob.isEmpty())
		{
			this.alt_mob = alt_mob;
		}
	}
	////////////////////////////////////
	
	public String getPin() {
		return pin;
	}
	
	public void setPin(String pin) {
		int ag = 0;
			if(!pin.isEmpty())
			{
				try
				{
					ag = Integer.parseInt(pin);
				}
				catch (Exception e) {
					ag = 0;
				}
				
				if(ag != 0)
				{
					this.pin = pin;
				}
			}
	}
	////////////////////////////////
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		if(!state.equals("Select State"))
		{
			this.state = state;
		}
	}
	
	////////////////////////////////
	
	public String getMarital() {
		return marital;
	}
	
	public void setMarital(String marital) {
			if(!marital.equals("Status"))
			{
				this.marital = marital;
			}
	}
	////////////////////////////////////////
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		if(!address.isEmpty() && !address.isEmpty())
		{
			this.address = address;
		}
	}
	////////////////////////////////
}
