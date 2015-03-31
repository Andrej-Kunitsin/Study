package myClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main
{

	public static void main(String[] args) throws UnknownHostException,
			IOException
	{
		Socket cs = new Socket("LocalHost", 7777);
		DataOutputStream out = new DataOutputStream(cs.getOutputStream());
		DataInputStream in = new DataInputStream(cs.getInputStream());
		Scanner scanner = new Scanner(System.in);
		while (true)
		{
			while (in.available() > 0)
			{
				String string = in.readUTF();
				System.out.println(string);
			}
			while (scanner.hasNextLine())
			{
				out.writeUTF(scanner.nextLine());
			}
			if (cs.isClosed())
				break;

		}
		scanner.close();
		in.close();
		out.close();
		cs.close();
	}
}
