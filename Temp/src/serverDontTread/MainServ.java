package serverDontTread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainServ
{
	static List<Clients> list = Collections
			.synchronizedList(new ArrayList<Clients>());

	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(7777);
		System.out.println("Server ready...");
		Socket socket;
		while (true)
		{
			try
			{
				ss.setSoTimeout(500);
				socket = ss.accept();
				System.out.println("произошло соеденение...");
				connectStart(socket);
			} catch (SocketTimeoutException e)
			{
				System.out.println("соеденения не было...");
				listenerAllClients();
			} finally
			{
				ss.close();
			}
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

			for (Clients c : list)
			{
				if (c.name.equals(name))
				{
					outStream.writeUTF("You already chatting");
					System.out.println("Клиент сброшен");
					socket.close();
					break;
				}
			}
			if (socket.isClosed())
			{
				outStream.writeUTF("Имя существует, "
						+ "пересоеденитесь с новым именем");
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

	private static void listenerAllClients()
	{
		for (Clients client : list)
		{
			try
			{
				while (client.inStream.available() > 0)
				{
					sendMassageAllClients(client.name,
							client.inStream.readUTF());
				}
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void sendMassageAllClients(String name, String massage)
	{
		for (Clients client : list)
		{
			try
			{
				client.outStream.writeUTF("Uset " + name + " send massage "
						+ massage);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
