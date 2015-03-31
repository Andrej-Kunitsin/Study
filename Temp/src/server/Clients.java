package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Clients
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
}
