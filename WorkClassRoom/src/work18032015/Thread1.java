package work18032015;

public class Thread1 extends Thread
{
public void run(){
	while(true){
		System.out.println("New Theard");
		try
		{
			sleep(1);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
}
