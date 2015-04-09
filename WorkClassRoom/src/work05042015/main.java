package work05042015;

import java.util.Timer;

public class main
{

	public static void main(String[] args)
	{
		Thread thread1 = new Thread(new MTimer(100, 1));
		Thread thread2 = new Thread(new MTimer(300, 2));
		Thread thread3 = new Thread(new MTimer(500, 3));
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
