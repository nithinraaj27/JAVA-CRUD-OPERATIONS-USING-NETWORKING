package Third;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class backend {

	public void dbinsert(util dd)
	{
		try
		{
			Connection con = DataBaseConnection.getCon();
			Statement smt = con.createStatement();
			
			
			String username = dd.getUsername();
			String name = dd.getName();
			String dob = dd.getDob().toString();
			String address = dd.getAddress();
			String age = dd.getAge();
			String mob = dd.getMob();
			String gender = dd.getGender();
			String password = dd.getPassword();
			String repass = dd.getRepass();
			String alt_mob = dd.getAlt_mob();
			String pin = dd.getPin();
			String state = dd.getState();
			String marital = dd.getMarital();
			
			String sq = "insert into bootcamp values('"+username+"','"+name+"','"+dob+"','"+address+"','"+age+"','"+mob+"','"+gender+"','"+password+"','"+repass+"','"+alt_mob+"','"+pin+"','"+state+"','"+marital+"')";
			
			smt.executeUpdate(sq);
			con.close();
			JOptionPane.showMessageDialog(null,"Thank You '"+name+ "' ,Your form is submitted successfully");
			System.out.println("Details Entered successfully");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	public void update(Details dd)
	{
		try
		{
			Connection con = DataBaseConnection.getCon();
			
			String username = dd.getUsername();
			String name = dd.getName();
			String dob = dd.getDob().toString();
			String address = dd.getAddress();
			String age = dd.getAge();
			String mob = dd.getMob();
			String gender = dd.getGender();
			String alt_mob = dd.getAlt_mob();
			String pin = dd.getPin();
			String state = dd.getState();
			String marital = dd.getMarital();
			
			String sq = "update bootcamp set username =?,dob =?,address=?,age=?,mob =?,gender =?, alt_mob=?,pin=?,state =?,marital =? where name =? ";
			PreparedStatement pstmt=con.prepareStatement(sq);
			pstmt .setString(1, username);
			pstmt .setString(2, dob);
			pstmt .setString(3, address);
			pstmt .setString(4, age);
			pstmt .setString(5, mob);
			pstmt .setString(6, gender);
			pstmt .setString(7, alt_mob);
			pstmt .setString(8, pin);
			pstmt .setString(9, state);
			pstmt .setString(10, marital);
			pstmt .setString(11, name);
			
			pstmt.executeUpdate();
			con.setAutoCommit(true);
			JOptionPane.showMessageDialog(null,"Thank You '"+name+ "' ,Your form is Updated successfully");
			System.out.println("Details Updated successfully");
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Sorry there is an error in updating yout details");
			System.out.println(e);
		}
	}
	
	public void delete(Details dd)
	{
		try
		{
			Connection con = DataBaseConnection.getCon();
			String name = dd.getName();
			String sq = "delete from bootcamp where name = ?";
			PreparedStatement pstmt = con.prepareStatement(sq);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			con.setAutoCommit(true);
			JOptionPane.showMessageDialog(null,"Thank You '"+name+ "' ,Your deletion process completed successfully");
			System.out.println("Details deleted successfully");
			
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Sorry there is an error in deleting yout details");
			System.out.println(e);
		}
	}
	
	public boolean check(String username,String password)
	{
		String org_pass = "";
		boolean ans = false;
		try
		{
			Connection con = DataBaseConnection.getCon();
			String sq = "select password from bootcamp where username =?";
			PreparedStatement pstmt = con.prepareStatement(sq);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			//con.setAutoCommit(true);
			
			if(rs.next())
			{
				org_pass = rs.getString("password");
			}
			if(password.equals(org_pass))
			{
				ans = true;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return ans;
	}
}
