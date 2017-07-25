import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientThread {

	public static void main(String arfs[]) throws  IOException
	{
		Socket se = new Socket("localhost",6666);
		
		DataInputStream din= null; 
		DataOutputStream dout= null;  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

		String str="",str2="";  
		while(!str.equals("stop")){ 
			
			din=new DataInputStream(se.getInputStream());
			dout=new DataOutputStream(se.getOutputStream());
			str=br.readLine();
			
			System.out.println(str);
			
			System.out.println("fileb........." + str);
			
			dout.writeUTF(str);  
			dout.flush();  
			str2=din.readUTF();
			
			
			
			System.out.println("Server says: "+str2);  
		}  

		dout.close();  
		se.close();  
		
		
	}
	
}
