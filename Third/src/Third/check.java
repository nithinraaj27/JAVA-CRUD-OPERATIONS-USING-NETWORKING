package Third;

import java.io.Serializable;

public class check implements Serializable {

	String username;
	String pass;
	check(String username,String pass)
	{
		this.username = username;
		this.pass = pass;
	}
}
