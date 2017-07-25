import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class Server implements Runnable {

	private String threadName =  "";
	private String fileName =  "";
	private Thread thread;
	private DataOutputStream dlink = null; 

	public Server(String name, String fname, DataOutputStream link)
	{
		threadName = name;
		fileName = fname;
		dlink = link;
	}

	public void run()
	{

		String message = "";
		FileReader in = null;
		try
		{
			in = new FileReader(fileName + ".txt");

			System.out.println(fileName);

			int d = in.read();


			while(d!= -1)
			{
				message += (char)d;
				d = in.read();

			//	System.out.println(threadName +"..........."+ message);


				

				//thread.sleep(500);
			}

			dlink.writeUTF(message);


		}

		catch(Exception e)
		{
			System.out.println(e);
		}

	}

	public void start()
	{
		System.out.println("Start thread ........" + threadName);


		thread = new Thread(this,threadName);
		thread.start();

	}

}

public class ServerThread
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket socket = new ServerSocket(6668);

		Socket se = null;
		
		
		DataInputStream din;
		DataOutputStream dout;
		
		while(true)
		{
			se = socket.accept();
			din = new DataInputStream(se.getInputStream());
			dout = new DataOutputStream(se.getOutputStream());
			String data = din.readUTF();
			
			String[] array = data.split(";");
			
			String thre = array[0];
			String fn = array[1];
			
			
			Server s1 = new Server(thre,"C:\\Users\\rahulkumar.254927\\workspace\\Multithreading\\src\\"+fn,dout);
			s1.start();
		}



	}
}
