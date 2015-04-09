package api;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class GameClient
{
	Socket socket = null;
	DataOutputStream out = null;
	List<ActionListener> actionList;
	public int idClient;
	private boolean isConnect = true;

	public GameClient()
	{
		do
		{
			try
			{
				socket = new Socket("localhost", 7777);
				isConnect = false;
				out = new DataOutputStream(socket.getOutputStream());
				DataInputStream in = new DataInputStream(
						socket.getInputStream());
				idClient = in.readInt();
				actionList = new LinkedList<ActionListener>();
				ClientListener cl = new ClientListener(socket, actionList);
				cl.start();

			} catch (IOException e)
			{
				int i = JOptionPane
						.showConfirmDialog(
								null,
								"Cоеденение с сервером не произошло, повторить соеденение?",
								"Ошибка соеденения",
								JOptionPane.OK_CANCEL_OPTION);
				switch (i)
				{
				case JOptionPane.OK_OPTION:
					break;
				case JOptionPane.CANCEL_OPTION:
					System.exit(0);
					break;

				}
				// e.printStackTrace();
			}
		} while (isConnect);
	}

	public void sendMesage(String string)
	{
		try
		{
			out.writeUTF(string);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void addActionListener(ActionListener actionListener)
	{
		actionList.add(actionListener);
	}
}
