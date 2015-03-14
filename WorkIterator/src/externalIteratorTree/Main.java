package externalIteratorTree;

public class Main
{

	public static void main(String[] args)
	{

		int[] arr = {4,3,2,9,5,7};
		BsTree tree = new BsTree();
		tree.init(arr);
		for (int i : tree){
			System.out.print(i+", ");
		}
	}

}
