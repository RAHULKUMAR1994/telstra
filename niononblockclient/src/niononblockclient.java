import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;


public class niononblockclient {
	
	public static void main(String a[]) throws IOException
	{
		InetSocketAddress add = new InetSocketAddress("localhost",6555);
		SocketChannel chan = SocketChannel.open(add);
		
		
		String s= "hi";
		

			byte array[]=  new String(s).getBytes();
			
			ByteBuffer buffer = ByteBuffer.wrap(array);
			chan.write(buffer);
			
			buffer.clear();
			
			
			
		}
		
		
		
	
	
	
	
}
