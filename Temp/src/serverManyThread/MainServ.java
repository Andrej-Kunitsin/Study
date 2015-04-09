package serverManyThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainServ
{
	public static Socket socket;
	public static ArrayList<Socket> listSocket = null;

	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(7777);
		System.out.println("Server ready...");
		listSocket = new ArrayList<Socket>();

		Thread thread;
		while (true)
		{
			socket = ss.accept();
			listSocket.add(socket);
			System.out.println("произошло соеденение...");
			thread = new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					Socket nextSocket = socket;
					DataInputStream inStream = null;
					DataOutputStream outStream = null;
					try
					{

						inStream = new DataInputStream(
								nextSocket.getInputStream());

						outStream = new DataOutputStream(
								nextSocket.getOutputStream());

						// outStream.writeUTF("Enter your name...");
						// String name = inStream.readUTF();
					} catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					while (!nextSocket.isClosed())
					{

						try
						{
							String incoming = inStream.readUTF();
							for (int i = 0; i < listSocket.size(); i++)
							{

								outStream = new DataOutputStream(listSocket
										.get(i).getOutputStream());
								outStream.writeUTF("Client " + i + ": "
										+ incoming);

							}
						} catch (IOException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					try
					{
						nextSocket.close();
					} catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					listSocket.remove(nextSocket);
				}
			});
			thread.start();
			// socket.close();
		}
	}

	static void connectStart(Socket socket)
	{

	}
}
