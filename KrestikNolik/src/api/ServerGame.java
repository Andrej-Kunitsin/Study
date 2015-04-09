package api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerGame
{
	static ArrayList<ServerListener> slst = new ArrayList<ServerListener>();

	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(7777);

		while (true)
		{
			System.out.println("Server ready...");
			Socket cs = ss.accept();
			if (slst.size() <= 2)// проверка на кол-во игроков
			{
				ServerListener sl = new ServerListener(cs, slst.size()+1);// создаем
																		// слушателя
																		// клиента
				slst.add(sl);// список клиентов
				sl.start();// поток клиентов
			} else
			{
				DataOutputStream out = new DataOutputStream(
						cs.getOutputStream());
				out.writeUTF("нет мест!");
				out.close();
				cs.close();
			}
		}
	}

	public static void sendMsg(String str) throws IOException
	{
		for (ServerListener sl : slst)
		{
			sl.out.writeUTF(str);// отправка всему списку клиентов сообщения
		}
	}
}
