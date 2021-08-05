package Third;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class ud extends JFrame implements ItemListener{
	
	JLabel name,username,dob,age,address,mob,gender,password,repass,alt_mob,pin,City,marital,title,register;
	JTextField Dob,Age,Password,Repass;
	JComboBox<String> city,Marital,Name;
	MaskFormatter m1,m2,m3;
	JFormattedTextField Mob,Alt_mob,Pin,Username;
	JTextArea Address;
	Container cnn;
	ButtonGroup bg;
	JRadioButton male,female;
	JButton update,delete;
	String Org_pass = "";
	String str_gender = "";
	ud()
	{
		cnn = getContentPane();
		cnn.setLayout(null);
		
		title = new JLabel("<HTML><U>UPDATE / DELETE FORM</U></HTML>");
		title.setFont(new Font("SERIF",Font.BOLD,25));
		
//		Font font = title.getFont();
//		
//		Map attri = font.getAttributes();
//		
//		attri.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
//		setFont(font.deriveFont(attri));
		
		name = new JLabel("NAME");
		username = new JLabel("USERNAME");
		dob = new JLabel("D.O.B");
		age = new JLabel("AGE");
		address = new JLabel("ADDRESS");
		mob = new JLabel("MOBILE");
		gender = new JLabel("GENDER");
		password = new JLabel("PASSWORD");
		repass = new JLabel("RE-TYPE PASSWORD");
		alt_mob = new JLabel("ALTERNATE NUMBER");
		pin = new JLabel("PINCODE");
		City = new JLabel("STATE");
		marital = new JLabel("MARITAL STATUS");
		
		register = new JLabel("Already registered? Click here!");
		
		Name = new JComboBox<String>();
		Dob = new JTextField();
		Address = new JTextArea();
		Password = new JTextField();
		Repass = new JTextField();
		Age = new JTextField();
		
		
		Address.setLineWrap(true);
		
		
		try
		{
			m1 = new MaskFormatter("**********");
			Mob = new JFormattedTextField(m1);
			Alt_mob = new JFormattedTextField(m1);
			
			m2 = new MaskFormatter("******");
			Pin = new JFormattedTextField(m2);
			
			m3 = new MaskFormatter("**************************************************");
			m3.setPlaceholder("username@something");
			Username = new JFormattedTextField(m3);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		Name.addItemListener(this);
		try
		{
			Name.addItem("Select Name");
			Connection con = DataBaseConnection.getCon();
			Statement smt = con.createStatement();
			String sq = "select name from bootcamp";
			PreparedStatement pstmt = con.prepareStatement(sq);
			
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next())
			{
				Name.addItem(rst.getString("name"));
			}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		bg = new ButtonGroup();
		city = new JComboBox<String>();
		Marital = new JComboBox<String>();
		
		city.addItem("Select State");
		city.addItem("TamilNadu");
		city.addItem("kerala");
		city.addItem("AndraPradash");
		city.addItem("Telungana");
		city.addItem("Karnataka");
		
		Marital.addItem("Status");
		Marital.addItem("Married");
		Marital.addItem("Single");
		
		
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		
		bg.add(male);
		bg.add(female);
		
		male.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				str_gender = ((JRadioButton)e.getSource()).getActionCommand();
				
			}
		});
		female.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str_gender = ((JRadioButton)e.getSource()).getActionCommand();
				
			}
		});
		update = new JButton("UPDATE");
		delete = new JButton("DELETE");
		
		title.setBounds(330,70,500,25);
		
		username.setBounds(550,150,120,25);   
		name.setBounds(100,150,120,25);
		dob.setBounds(100,200,120,25);
		age.setBounds(550,200,120,25);
		gender.setBounds(100,250,120,25);
		marital.setBounds(550,250,120,25);
		address.setBounds(100,300,120,25);
		City.setBounds(550,310,120,25);
		pin.setBounds(550, 370, 120, 25);
		mob.setBounds(100,420,120,25);
		alt_mob.setBounds(550, 420, 150, 25);
		password.setBounds(100,470,120,25);
		//repass.setBounds(550,470,150,25);
		
		Username.setBounds(700,150,200,25);
		Name.setBounds(230,150,200,25);
		Dob.setBounds(230,200,200,25);
		Age.setBounds(700,200,200,25);
		male.setBounds(230,250,60,25);
		female.setBounds(300,250,90,25);
		Marital.setBounds(700, 250, 200, 25);
		Address.setBounds(230,300,200,100);
		city.setBounds(700, 310, 200, 25);
		Pin.setBounds(700, 370, 200, 25);
		Mob.setBounds(230,420,200,25);
		Alt_mob.setBounds(700, 420, 200, 25);
		Password.setBounds(230,470,200,25);
		//Repass.setBounds(700,470,200,25);
		
		update.setBounds(380,550,100,25);
		delete.setBounds(550,550,100,25);
		//register.setBounds(400,550,500,25);
		
		male.setBackground(Color.pink);
		female.setBackground(Color.pink);
		
		cnn.add(title);
		
		cnn.add(name);
		cnn.add(username);
		cnn.add(dob);
		cnn.add(age);
		cnn.add(gender);
		cnn.add(address);
		cnn.add(mob);
		cnn.add(password);
		cnn.add(repass);
		cnn.add(marital);
		cnn.add(City);
		cnn.add(pin);
		cnn.add(alt_mob);
		
		cnn.add(Name);
		cnn.add(Username);
		cnn.add(Dob);
		cnn.add(Age);
		cnn.add(male);
		cnn.add(female);
		cnn.add(Address);
		cnn.add(Mob);
		cnn.add(Password);
		cnn.add(Repass);
		cnn.add(city);
		cnn.add(Marital);
		cnn.add(Pin);
		cnn.add(Alt_mob);
		
		cnn.add(delete);
		//cnn.add(register);
		Marital.setBackground(Color.white);
		city.setBackground(Color.white);
		cnn.setBackground(Color.pink);
		
		cnn.add(update);
		setSize(1000,700);
		setVisible(true);
		
		Name.addItemListener(this);
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = Name.getSelectedItem().toString();
				String username = Username.getText();
				String dob = Dob.getText();
				String address = Address.getText();
				String age = Age.getText();
				String mob = Mob.getText();
				String gender = str_gender;
				String password = Password.getText().toString();
				String repass = Repass.getText().toString();
				String alt_mob = Alt_mob.getText();
				String pin = Pin.getText();
				String state = city.getSelectedItem().toString();
				String marital = Marital.getSelectedItem().toString();
				
				Details dd = new Details();
				dd.setUsername(username);
				dd.setName(name);
				dd.setDob(dob);
				dd.setAge(age);
				dd.setAddress(address);
				dd.setMob(mob);
				dd.setGender(str_gender);
				dd.setPassword(password);
				dd.setRepass(repass);
				dd.setAlt_mob(alt_mob);
				dd.setPin(pin);
				dd.setState(state);
				dd.setMarital(marital);
				
				
				if(username.isEmpty())
				{
					JOptionPane.showMessageDialog(rootPane, "Give proper Username");
				}
				
				if(dob.isEmpty())
				{
					JOptionPane.showMessageDialog(rootPane, "Give proper DOB");
				}
				
				if(age.isEmpty())
				{
					JOptionPane.showMessageDialog(rootPane, "Give proper Age");
				}
				
				if(address.isEmpty())
				{
					JOptionPane.showMessageDialog(rootPane, "Give proper Address");
				}
				
				if(password.isEmpty())
				{
					JOptionPane.showMessageDialog(rootPane, "Give proper Password");
				}

				if(mob.isEmpty())
				{
					JOptionPane.showMessageDialog(rootPane, "Give proper Mobile Number");
				}
				
				if(pin.isEmpty())
				{
					JOptionPane.showMessageDialog(rootPane, "Give proper pincode");
				}
				
				if(state.isEmpty())
				{
					JOptionPane.showMessageDialog(rootPane, "Select proper name");
				}
				
				if(marital.isEmpty())
				{
					JOptionPane.showMessageDialog(rootPane, "Select proper name");
				}
				
				if(alt_mob.isEmpty())
				{
					JOptionPane.showMessageDialog(rootPane, "Give proper Altername Mobile Number");
				}
				
				if(password.equals(Org_pass) && !password.isEmpty())
				{
					
					backend db = new backend();
					db.update(dd);
					setVisible(false);
					new ud();
					
				}
				else
				{
					 System.out.println("Error");
					 JOptionPane.showMessageDialog(rootPane, "type the correct password");
				}
			}
		});
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String name = Name.getSelectedItem().toString();
				String username = Username.getText();
				String dob = Dob.getText();
				String address = Address.getText();
				String age = Age.getText();
				String mob = Mob.getText();
				String gender = str_gender;
				String password = Password.getText().toString();
				String repass = Repass.getText().toString();
				String alt_mob = Alt_mob.getText();
				String pin = Pin.getText();
				String state = city.getSelectedItem().toString();
				String marital = Marital.getSelectedItem().toString();
				
				Details dd = new Details();
				dd.setUsername(username);
				dd.setName(name);
				dd.setDob(dob);
				dd.setAge(age);
				dd.setAddress(address);
				dd.setMob(mob);
				dd.setGender(str_gender);
				dd.setPassword(password);
				dd.setRepass(repass);
				dd.setAlt_mob(alt_mob);
				dd.setPin(pin);
				dd.setState(state);
				dd.setMarital(marital);
				
				if(password.equals(Org_pass) && !password.isEmpty())
				{
					backend db = new backend();
					db.delete(dd);
					setVisible(false);
					new ud();
				}
				else
				{
					 System.out.println("Error");
					 JOptionPane.showMessageDialog(rootPane, "type the correct password");
				}
				
			}
		});
	}
	
	public static void main(String[] args) {
		new ud();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		ItemSelectable _itemselected = e.getItemSelectable();
		
		if(_itemselected == Name)
		{
			if(_itemselected.toString() != "Select Username")
			{
				try
				{
					String e_name = Name.getSelectedItem().toString();
					Connection con = DataBaseConnection.getCon();
					
					String st = "select username,dob,address,age,mob,gender,password,repass,alt_mob,pin,state,marital from bootcamp where name = ?";
					PreparedStatement pstmt = con.prepareStatement(st);
					
					pstmt.setString(1, e_name);
					
					ResultSet rst = pstmt.executeQuery();
					
					Details dd = new Details();
					if(rst.next())
					{
						Username.setText(rst.getString("USERNAME"));
						Dob.setText(rst.getString("dob"));
						Address.setText(rst.getString("address"));
						Age.setText(rst.getString("age"));
						Mob.setText(rst.getString("mob"));
						Org_pass = rst.getString("password");
						//Password.setText(rst.getString("password"));
						//Repass.setText(rst.getString("repass"));
						Alt_mob.setText(rst.getString("alt_mob"));
						Pin.setText(rst.getString("pin"));
						city.setSelectedItem(rst.getString("state"));
						Marital.setSelectedItem(rst.getString("marital"));
						if(rst.getString("gender").equals("Male"))
						{
							male.setSelected(true);
						}
						else
						{
							female.setSelected(true);
						}
						//bg.setSelected(rst.getString("gender"), true);
					}
					
				}
				catch (Exception ie) {
					// TODO: handle exception
					System.out.println(ie);
				}
			}
		}
	}
}
