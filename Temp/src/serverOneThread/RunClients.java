package serverOneThread;

import java.io.IOException;

public class RunClients extends Thread
{
	@Override
	public void run()
	{
		while (true)
		{
			String allMessage = null;
			synchronized (MainServ.list)
			{
				for (Clients client : MainServ.list)
				{
					try
					{
						while (client.inStream.available() > 0)
						{
							allMessage = "User " + client.name
									+ " send massage: "
									+ client.inStream.readUTF();
						}
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
			if (allMessage != null)
			{
				sendMassageAllClients(allMessage);
			}
		}
	}

	private void sendMassageAllClients(String massage)
	{
		synchronized (MainServ.list)
		{
			for (Clients client : MainServ.list)
			{
				try
				{
					client.outStream.writeUTF(massage);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
