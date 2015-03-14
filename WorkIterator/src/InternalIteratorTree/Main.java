package InternalIteratorTree;

public class Main
{

	public static void main(String[] args)
	{

		int[] arr = {4,3,2,9,5,7};
		BsTree tree = new BsTree();
		tree.init(arr);
		System.out.println("размер "+tree.size());
		System.out.println("кол-во листов "+tree.countLeafs());
		System.out.println("кол-во Nodes "+tree.countNodes());
		for (int i : tree){
			System.out.print(i+", ");
		}
	}

}
