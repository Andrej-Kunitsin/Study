package api;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class ServerListener extends Thread
{
	DataInputStream in = null;
	DataOutputStream out = null;
	Socket cs = null;
	int numGamer;

	public ServerListener(Socket cs, int numGamer) throws IOException
	{
		this.cs = cs;
		this.numGamer = numGamer;
		in = new DataInputStream(cs.getInputStream());
		out = new DataOutputStream(cs.getOutputStream());
	}

	@Override
	public void run()
	{
		String str;
		try
		{
			out.writeInt(numGamer);// возвращаю номер клиента
			while (true)
			{
				str = numGamer + in.readUTF(); // ждем ход
				ServerGame.sendMsg(str);
			}
		} catch (EOFException e)
		{
			System.out.println("Соеденение потеряно");
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				cs.close();
				ServerGame.slst.remove(this);

			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
