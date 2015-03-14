package InternalIteratorTree;

import InternalIteratorTree.BsTree.Node;

public class VNodes implements Visitor
{
	int nodes = 0;
	@Override
	public void action(Node p)
	{
		if(p.left != null || p.rigth != null)
		{
			nodes++;
		}
	}

}
