package InternalIteratorTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

public class BsTree implements Iterable<Integer>
{

	public class Node
	{
		public int data;
		public Node right;
		public Node left;
		public Node parent = null;
		public boolean isVisited = false;

		public Node(int data, Node parent)
		{
			this.data = data;
			this.parent = parent;
		}
	}

	private Node root = null;

	public Node getNode()
	{
		return this.root;
	}

	public void clear()
	{
		root = null;

	}

	public void add(int val)
	{
		if (root == null)
		{
			root = new Node(val, null);
		} else
		{
			addNode(root, val);
		}
	}

	private void addNode(Node p, int val)
	{
		if (val < p.data)
		{
			if (p.left == null)
			{
				p.left = new Node(val, p);
			} else
			{
				addNode(p.left, val);
			}
		} else
		{
			if (p.right == null)
			{
				p.right = new Node(val, p);
			} else
			{
				addNode(p.right, val);
			}
		}
	}

	public void init(int[] array)
	{
		if (array == null || array.length == 0)
		{
			array = new int[0];
		}
		for (int i : array)
		{
			add(i);
		}
	}

	public int[] toArray()
	{
		List<Integer> list = new ArrayList<Integer>();
		if (root == null || size() == 0)
		{

		} else
		{
			list = toArray(root, list);
		}
		int i = 0;
		int[] arr = new int[list.size()];
		for (int ch : list)
		{
			arr[i] = ch;
			i++;
		}
		return arr;
	}

	private List<Integer> toArray(Node p, List<Integer> list)
	{
		if (p == null)
			return list;
		list = toArray(p.left, list);
		list.add(p.data);
		list = toArray(p.right, list);
		return list;
	}

	public String toString()
	{
		int[] arr = toArray();
		String string = "";
		for (int i : arr)
		{
			string = string + i + ", ";
		}
		return string.replaceFirst(", $", "");
	}

	private void visit(Node p, Visitor v)
	{
		if (p == null)
			return;
		visit(p.left, v);
		v.action(p);
		visit(p.right, v);
	}

	public int size()
	{
		VSize v = new VSize();
		visit(root, v);
		return v.count;
	}

	public int countLeafs()
	{
		VLifs v = new VLifs();
		visit(root, v);
		return v.lifs;
	}

	public int countNodes()
	{
		VNodes v = new VNodes();
		visit(root, v);
		return v.nodes;
	}

	public int width()
	{

		return 0;
	}

	public int height()
	{
		int countWidth = 0;
		if (root == null)
		{
			return countWidth;
		} else
		{
			countWidth = height(root);
		}
		return countWidth;
	}

	private int height(Node p)
	{
		if (p == null)
			return 0;
		int leftHeight = height(p.left);
		int rigthHeight = height(p.right);

		return Math.max(leftHeight, rigthHeight) + 1;
	}

	public void print()
	{
		printNode(root);
	}

	private void printNode(Node p)
	{
		if (p == null)
			return;
		printNode(p.left);
		System.out.print(p.data + ", ");
		printNode(p.right);
	}

	@Override
	public Iterator<Integer> iterator()
	{

		return new TreeListIter(root);
	}

	private void visit2(Node p, Visitor v)
	{
		if (p == null)
			return;
		if (!p.isVisited)
		{
			visit2(p.left, v);
		}
		p.isVisited = true;

	}

	class TreeListIter implements Iterator<Integer>
	{
		Node next;
		int index = size();
		VIter v = new VIter();

		public TreeListIter(Node root)
		{
			if (root == null)
				return;
			next = root;
			while (next.left != null)
				next = next.left;
		}

		@Override
		public boolean hasNext()
		{
			return next != null;
		}

		@Override
		public Integer next()
		{
			Node r = next;
			if (next.right != null)
			{
				next = next.right;
				while (next.left != null)
					next = next.left;
				return r.data;
			} else
				while (true)
				{
					if (next.parent == null)
					{
						next = null;
						return r.data;
					}
					if (next.parent.left == next)
					{
						next = next.parent;
						return r.data;
					}
					next = next.parent;
				}
		}

		@Override
		public void remove()
		{
		}
	}

}
