package serverManyThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RunClients extends Thread
{
	Socket socket;

	public RunClients(Socket socket)
	{
		this.socket = socket;
	}
	
	@Override
	public void run()
	{
		try
		{
			DataInputStream inStream;
			inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream;
			outStream = new DataOutputStream(socket.getOutputStream());

			outStream.writeUTF("Enter your name...");
			String name = inStream.readUTF();
			Thread thread = new Thread(new Clients(name,inStream,outStream),name);
			thread.start();
			wait();
		}catch (Exception e){
			
		}
	}
}
