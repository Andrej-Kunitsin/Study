package work05042015;

import javax.swing.plaf.SliderUI;

public class MTimer implements Runnable
{
	int timer;
	int num;

	public MTimer(int timer, int num)
	{
		this.timer = timer;
		this.num = num;
	}

	@Override
	public void run()
	{

		while (true)
		{
			System.out.println(num);
			try
			{
				Thread.sleep(timer);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
