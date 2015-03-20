package work18032015;

public class Thread3 extends Thread
{
	public void run(){
		while(true){
			System.out.println("New Theard3");
			try
			{
				sleep(1500);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
