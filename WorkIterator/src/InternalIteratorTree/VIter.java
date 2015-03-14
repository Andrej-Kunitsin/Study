package InternalIteratorTree;

import InternalIteratorTree.BsTree.Node;

public class VIter implements Visitor {
	Node last;

	@Override
	public void action(Node p) {
		p.isVisited = true;
		last = p;
	}

}
