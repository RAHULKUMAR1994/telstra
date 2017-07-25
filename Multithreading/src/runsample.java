import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


class sample implements Runnable{

	private String threadName;
	private Thread thread;
	private String fileName;


	public sample(String name, String fname)
	{
		threadName = name; 
		fileName = fname;
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
				
				System.out.println(threadName +"..........."+ message);
				
				thread.sleep(500);
			}
			
			
		}

		catch(Exception e)
		{
			System.out.println(e);
		}

	}

	public void start()
	{
		System.out.println("Start thread ........" + threadName);
		if(thread == null)
		{
			thread = new Thread(this,threadName);
			thread.start();
		}
	}

}


public class runsample
{
	public static void main(String args[])
	{
		sample s1 = new sample("thread-1", "C:\\Users\\rahulkumar.254927\\workspace\\Multithreading\\src\\in1");
		s1.start();
		
		sample s2 = new sample("thread-2","C:\\Users\\rahulkumar.254927\\workspace\\Multithreading\\src\\in2");
		s2.start();
		
	}
}



