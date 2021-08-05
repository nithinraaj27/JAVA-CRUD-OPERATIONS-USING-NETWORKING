package Third;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;


public class form extends JFrame implements Runnable{
	
	ObjectOutputStream op;
	Socket s;
	JLabel name,username,dob,age,address,mob,gender,password,repass,alt_mob,pin,City,marital,title;
	JTextField Name,Dob,Age;
	JComboBox<String> city,Marital;
	JFormattedTextField Mob,Alt_mob,Pin,Username;
	MaskFormatter m1,m2,m3;
	JPasswordField Password,Repass;
	JTextArea Address;
	Container cnn;
	ButtonGroup bg;
	JRadioButton male,female;
	JButton submit,view,update,delete,back;
	String str_gender = "";
	boolean bool = true;
	form()
	{
		cnn = getContentPane();
		cnn.setLayout(null);
		
		title = new JLabel("<HTML><U>REGISTRATION FORM</U></HTML>");
		title.setFont(new Font("VERDANA",Font.BOLD,25));
		
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
		
		
		Name = new JTextField();
		Dob = new JTextField();
		Address = new JTextArea();
		Password = new JPasswordField();
		Repass = new JPasswordField();
		Age = new JTextField();
		
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
		
		Password.setEchoChar('*');
		Repass.setEchoChar('*');

		Address.setLineWrap(true);
		
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
		
		submit = new JButton("submit");
		view = new JButton("View");
		update = new JButton("Update");
		delete = new JButton("Delete");
		back = new JButton("Back");
		
		title.setBounds(360,70,500,25);
		
		name.setBounds(100,150,120,25);
		username.setBounds(550,150,120,25);
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
		repass.setBounds(550,470,150,25);
		
		Name.setBounds(230,150,200,25);
		Username.setBounds(700,150,200,25);
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
		Repass.setBounds(700,470,200,25);
		
		submit.setBounds(290,550,100,25);
		update.setBounds(405,550,100,25);
		delete.setBounds(525,550,100,25);
		view.setBounds(645,550,100,25);
		back.setBounds(460, 600, 100, 25);
		
		male.setBackground(Color.cyan);
		female.setBackground(Color.cyan);
		
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
		
		
		cnn.add(view);
		cnn.add(update);
		cnn.add(delete);
		cnn.add(back);
		Marital.setBackground(Color.white);
		city.setBackground(Color.white);
		cnn.setBackground(Color.cyan);
		
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				String username = Username.getText();
				String name = Name.getText();
				String dob = Dob.getText();
				String address = Address.getText();
				String age = Age.getText();
				String mob = Mob.getText();
				//String gender = bg.getSelection().getSelectedObjects().toString();
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
				
				util uu = new util(
						dd.getUsername(),
						dd.getName(),
						dd.getDob(),
						dd.getAge(),
						dd.getAddress(),
						dd.getMob(),
						dd.getGender(),
						dd.getPassword(),
						dd.getRepass(),
						dd.getAlt_mob(),
						dd.getPin(),
						dd.getState(),
						dd.getMarital()
						);
				
				
				while(bool)
				{
					if(dd.getName().isEmpty())
					{
						JOptionPane.showMessageDialog(rootPane, "Give proper name");
						break;
					}
					
					if(dd.getUsername().isEmpty())
					{
						JOptionPane.showMessageDialog(rootPane, "Give proper Username");
						break;
					}
					
					else {
			            
			            String userName_Str = uu.getUsername();
			            
			            
			            try {
			              
			              Connection conn = DataBaseConnection.getCon();
			              
			              Boolean boo = false;
			              
			              String query = "SELECT USERNAME FROM BOOTCAMP";
			              
			              PreparedStatement pstmt = conn.prepareStatement(query);
			              
			              ResultSet rst = pstmt.executeQuery();
			              
			              while(rst.next()) {
			                
			                if(userName_Str.equals(rst.getString("USERNAME"))){
			                  boo = true;
			                  break;
			                }
			              }
			              
			              if(boo){
			                JOptionPane.showMessageDialog(null, "USERNAME ALREADY EXISTS !");
			                break;
			              }
			          
			              
			            }
			            catch(Exception ex) {
			              JOptionPane.showMessageDialog(null, "ERROR FETCHING DATABASE !"+ex);
			              break;
			            }
			            
			            
			            
			          }
					
					if(dd.getDob().isEmpty())
					{
						JOptionPane.showMessageDialog(rootPane, "Give proper DOB");
						break;
					}
					
					if(dd.getAge().isEmpty())
					{
						JOptionPane.showMessageDialog(rootPane, "Give proper Age");
						break;
					}
					
					if(dd.getAddress().isEmpty())
					{
						JOptionPane.showMessageDialog(rootPane, "Give proper Address");
						break;
					}
					
					if(dd.getPassword().isEmpty())
					{
						JOptionPane.showMessageDialog(rootPane, "Give proper Password");
						break;
					}
					
					if(dd.getRepass().isEmpty())
					{
						JOptionPane.showMessageDialog(rootPane, "Give proper Re type password");
						break;
					}
					
					if(dd.getMob().isEmpty())
					{
						JOptionPane.showMessageDialog(rootPane, "Give proper Mobile Number");
						break;
					}
					
					if(dd.getGender().isEmpty())
					{
						JOptionPane.showMessageDialog(rootPane, "Select proper gender");
						break;
					}
					
					if(dd.getPin().isEmpty())
					{
						JOptionPane.showMessageDialog(rootPane, "Give proper pincode");
						break;
					}
					
					if(dd.getState().isEmpty())
					{
						JOptionPane.showMessageDialog(rootPane, "Select proper State");
						break;
					}
					
					if(dd.getMarital().isEmpty())
					{
						JOptionPane.showMessageDialog(rootPane, "Select proper Marital status");
						break;
					}
					
					if(dd.getAlt_mob().isEmpty())
					{
						JOptionPane.showMessageDialog(rootPane, "Give proper Altername Mobile Number");
						break;
					}
					
					if(password.equals(repass) && !password.isEmpty())
					{
						bool = false;
						try
						{
							op.writeObject(uu);
							op.flush();
						}catch (Exception se) {
							// TODO: handle exception
							System.out.println(se);
						}
						setVisible(false);
						new form();
						
					}
					else
					{
						 System.out.println("Error");
						 JOptionPane.showMessageDialog(rootPane, "Password and Re type password is not matching");
					}
				}
			}
		});
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ud u = new ud();
				
			}
		});
		
		view.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view v = new view();
				setVisible(false);
			}
		});
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ud u = new ud();
			}
		});
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 new login();
				 setVisible(false);
			}
		});
		cnn.add(submit);
		setSize(1000,700);
		setVisible(true);
		try
		{
			s = new Socket("127.0.0.1",2130);
			OutputStream oo = s.getOutputStream();
			op = new ObjectOutputStream(oo);
			Thread th = new Thread(this);
			th.start();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
		
	public static void main(String[] args) {
		new form();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			s.setSoTimeout(1000);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Time Out");
		}
		
	}
}
