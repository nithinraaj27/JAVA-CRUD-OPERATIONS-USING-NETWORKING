package Third;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	private ServerSocket ss;
	Socket sd;
	ObjectInputStream dis;
	util dd = null;
	
	public server()
	{
		try
		{
			ss = new ServerSocket(2130);
			while(true)
			{
				sd = ss.accept();
				InputStream in = sd.getInputStream();
				dis = new ObjectInputStream(in);
				dd = (util)dis.readObject();
				backend bb = new backend();
				bb.dbinsert(dd);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new server();
	}
}
