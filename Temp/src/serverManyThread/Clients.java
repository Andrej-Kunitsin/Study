package serverManyThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Clients implements Runnable
{
	String name;
	DataInputStream inStream;
	DataOutputStream outStream;

	public Clients(String name, DataInputStream inStream,
			DataOutputStream outStream) throws IOException
	{
		this.inStream = inStream;
		this.outStream = outStream;
		this.name = name;

	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
	}
}
