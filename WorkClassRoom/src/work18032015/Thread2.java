package work18032015;

public class Thread2 extends Thread
{
	public void run()
	{
		while (true)
		{
			System.out.println("New Theard2");
			try
			{
				sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
