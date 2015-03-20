package work18032015;

public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Thread1 tt = new Thread1();
		Thread2 tt2 = new Thread2();
		Thread3 tt3 = new Thread3();
		tt.start();
		tt2.start();
		tt3.start();
		
	}

}
