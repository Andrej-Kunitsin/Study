package serverOneThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainServ
{
	static List<Clients> list = new ArrayList<Clients>();

	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(7777);
		System.out.println("Server ready...");
		Socket socket;
		Thread thread = new Thread(new RunClients());
		thread.start();
		while (true)
		{
			socket = ss.accept();
			System.out.println("произошло соеденение...");
			connectStart(socket);

		}
	}

	static void connectStart(Socket socket)
	{
		try
		{
			DataInputStream inStream;
			inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream;
			outStream = new DataOutputStream(socket.getOutputStream());

			outStream.writeUTF("Enter your name...");
			String name = inStream.readUTF();
			synchronized (list)
			{
				for (Clients c : list)
				{
					if (c.name.equals(name))
					{
						outStream.writeUTF("You already chatting");
						socket.close();
						break;
					}
				}
			}
			if (socket.isClosed())
			{
				return;
			} else
			{
				outStream.writeUTF("Вы вошли в чат...");
				list.add(new Clients(name, inStream, outStream));
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
