package InternalIteratorTree;

import InternalIteratorTree.BsTree.Node;

public class VSize implements Visitor
{
int count = 0;
	@Override
	public void action(Node p)
	{
		count++;
	}

}
