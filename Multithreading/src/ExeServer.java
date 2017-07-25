import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


class TempSer implements Runnable {

	private Thread thread = null;
	private Socket socket = null;
	private String threadName = "";

	public TempSer(Socket soc)
	{
		this.socket = soc;
	}
	public void run()
	{
		
		String fileName = "";
		DataInputStream din = null;
		DataOutputStream dout = null;

		try {
			din = new DataInputStream(socket.getInputStream());
			dout = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e2) {
			e2.printStackTrace();
		}



		String message = "";
		FileReader in = null;

		String input = "";


		while(!input.equals("stop"))
		{
			try {
				input  = din.readUTF();
				
				String arr[] = input.split(";");
				
				fileName = "C:\\Users\\rahulkumar.254927\\workspace\\Multithreading\\src\\" + arr[1];
				threadName = arr[0];
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try
			{
				in = new FileReader(fileName + ".txt");

				//	System.out.println(fileName);

				int d = in.read();


				while(d!= -1)
				{
					message += (char)d;
					d = in.read();

					//	System.out.println(threadName +"..........."+ message);






					//System.out.println(d);
				}
				//thread.sleep(5000);



				dout.writeUTF(message);


			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}



	}

	public void start()
	{
		System.out.println("Start thread ........" + threadName);


		thread = new Thread(this,threadName);
		thread.start();

	}
}


class handleSuspendedThread implements RejectedExecutionHandler 
{
	public void rejectedExecution(Runnable r, ThreadPoolExecutor exe) {

		System.out.println(exe + " " + r);

	}
}

public class ExeServer
{
	public static void main(String a[]) throws IOException, InterruptedException
	{
		ServerSocket se = new ServerSocket(6666);


		Socket socket = null;	

		handleSuspendedThread handler = new handleSuspendedThread();

		ThreadFactory factory = Executors.defaultThreadFactory();

		ThreadPoolExecutor executor =  new ThreadPoolExecutor(4, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), factory, handler); 




		while(true)
		{

			socket = se.accept();
			//executor.execute(new TempSer(thre,"C:\\Users\\rahulkumar.254927\\workspace\\Multithreading\\src\\"+fn,din,dout));
			executor.execute(new TempSer(socket));
		}

		//Thread.sleep(30000);

		//executor.shutdown();




	}
}