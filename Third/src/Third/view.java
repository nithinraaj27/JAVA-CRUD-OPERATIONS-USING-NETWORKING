package Third;


import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class view extends JFrame{
	Container cnn;
	String columnnames[] = {"NAME","USERNAME","D.O.B","ADDRESS","AGE","MOBILE","GENDER","ALT MOBILE","PIN","STATE","MARITAL"};
	
	void view(String Username)
	{
		cnn = getContentPane();
		int s=0;
		try
		{
			Connection con = DataBaseConnection.getCon();
			PreparedStatement st = con.prepareStatement("select * from bootcamp");
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				s++;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		String row[][] = new String[s][12];
		setLayout(null);
		JLabel label = new JLabel("<HTML><U>USER DETAILS</U></HTML>");
		
		JButton edit = new JButton("Edit");
		label.setFont(new Font("VERDANA", Font.BOLD, 25));
		label.setForeground(new Color(13,146,142));
		edit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		try
		{
			Connection con = DataBaseConnection.getCon();			
			PreparedStatement pstmt = con.prepareStatement("Select * from bootcamp where username= ?");
			pstmt.setString(1, Username);
			ResultSet rs = pstmt.executeQuery();
			int i=0;
			while(rs.next())
			{
				int j=0;
				row[i][j++] = rs.getString("name");
				row[i][j++] = rs.getString("username");
				row[i][j++] = rs.getString("dob");
				row[i][j++] = rs.getString("address");
				row[i][j++] = rs.getString("age");
				row[i][j++] = rs.getString("mob");
				row[i][j++] = rs.getString("gender");
				row[i][j++] = rs.getString("alt_mob");
				row[i][j++] = rs.getString("pin");
				row[i][j++] = rs.getString("state");
				row[i][j++] = rs.getString("marital");
				i++;
			}
			
			rs.close();
			pstmt.close();
			con.close();	
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.out.println(e);
		}
		
		JTable table = new JTable(row,columnnames);
		JTableHeader th = table.getTableHeader();
		th.setPreferredSize(new Dimension(25,25));
		th.setForeground(new Color(22,124,120));
		th.setBackground(new Color(255,255,255));
		JScrollPane ss = new JScrollPane(table);
		
		ss.setBackground(Color.cyan);
		ss.setBounds(10,70,1500,400);
		ss.setBorder(BorderFactory.createEmptyBorder());
		ss.getViewport().setBackground(Color.CYAN);
		
		JButton back = new JButton("Back");
		
		label.setBounds(650, 25, 350, 25);
		edit.setBounds(1320,700,150,25);
		back.setBounds(1150, 700, 150, 25);
		
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ud u = new ud();
			}
		});
		cnn.add(ss);
		cnn.add(label);
		cnn.add(edit);
		cnn.add(back);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new login();
				setVisible(false);
			}
		});
		cnn.setBackground(Color.CYAN);
		setSize(5000,5000);
		setVisible(true);


	}
	public static void main(String[] args) {
		
	}
}
