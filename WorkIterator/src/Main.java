public class Main
{

	public static void main(String[] args)
	{
		int[] arr = { 5, 6, 4, 8, 2, 14, 5 };
		LList1 list = new LList1();
		list.init(arr);
		for (int i : list)
		{
			System.out.print(i + ", ");
		}
	}
}
