import java.util.*;
import java.io.*;

public class helloworld
{
	
	static String message = "";
	public static void main()
	{
		try
		{
			FileReader read1 = new FileReader("C:\\Users\\rahulkumar.254927\\workspace\\sampleproject\\src\\in.txt");
			
			int d = read1.read();
			message += Character.toString((char) d);
			
			while(d != -1)
			{
				message += Character.toString((char) d);
				d = read1.read();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

