package Third;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server1 extends Thread {

	private ServerSocket dr;
	static Socket ds;
	static ObjectInputStream dis;
	static ObjectOutputStream ois;
	static check dd = null;
	static boolean ans = false;
	
	public server1(int port) throws IOException
	{
		dr = new ServerSocket(port);
	}
	
	static Thread writer = new Thread()
	{
		public void run()
		{
			try
			{
				OutputStream oo = ds.getOutputStream();
				ois = new ObjectOutputStream(oo);
				utilserver1 uz = new utilserver1(ans);
				System.out.println("Writer thread: "+ ans); 
				ois.writeObject(uz);
				System.out.println("writer");
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e+ "writing");
			}
		}
	};
	
	public void run()
	{
		try
		{
			while(true)
			{
				ds = dr.accept();
				System.out.println("Sucess Connected");
				try
				{
					    //System.out.println("Reader in client");
						InputStream in = ds.getInputStream();
						dis = new ObjectInputStream(in);
						dd = (check)dis.readObject();
						backend bb = new backend();
						ans = bb.check(dd.username, dd.pass);
						System.out.println(ans);
						writer.start();
				
				}
				catch (Exception e) {
				
					// TODO: handle exception
					System.out.println(e+ "reading");
				
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e + "Connection Error");
		}
	}
	
	public static void main(String[] args) {
         
		int port = 2168;
		try
		{
			Thread  connector = new server1(port);
			connector.start();
			try
			{
				connector.join();
				
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
			
			//reader.start();
			System.out.println("Checking");
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
