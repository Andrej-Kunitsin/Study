package myClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main
{

	public static void main(String[] args) throws UnknownHostException,
			IOException
	{
		Socket cs = new Socket("LocalHost", 7777);
		final DataOutputStream out = new DataOutputStream(cs.getOutputStream());
		DataInputStream in = new DataInputStream(cs.getInputStream());
		Runnable runnable = new Runnable()
		{

			@Override
			public void run()
			{
				Scanner scanner = new Scanner(System.in);
				try
				{
					while (true)
					{
						String msg = scanner.nextLine();
						out.writeUTF(msg);
					}
				} catch (Exception e)
				{
					System.out.println("Упс");
				} finally
				{
					scanner.close();
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		while (true)
		{
			while (in.available() > 0)
			{
				String string = in.readUTF();
				System.out.println(string);
			}
			if (cs.isClosed())
				break;

		}
		in.close();
		out.close();
		cs.close();
	}
}
