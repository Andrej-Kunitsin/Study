package api;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ClientListener extends Thread
{
	DataInputStream in = null;
	List<ActionListener> actionListener;

	public ClientListener(Socket cs, List<ActionListener> actionList)
			throws IOException
	{
		in = new DataInputStream(cs.getInputStream());
		actionListener = actionList;
	}

	@Override
	public void run()
	{
		try
		{
			String str = in.readUTF();

			while (true)
			{
				ActionEvent event = new ActionEvent(this, 1, str);
				for (ActionListener aa : actionListener)
				{
					aa.actionPerformed(event);
				}
				str = in.readUTF();
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
