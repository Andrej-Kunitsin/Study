package InternalIteratorTree;

import InternalIteratorTree.BsTree.Node;

public class VLifs implements Visitor
{
	int lifs = 0;
	@Override
	public void action(Node p)
	{
		if(p.left == null && p.right == null)
		{
			lifs++;
		}
	}

}
