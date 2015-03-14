import java.util.Iterator;

public class LList1 implements ExList, Iterable<Integer>
{
	boolean flagLength0 = false;

	private class Node
	{
		int data;
		Node next = null;

		public Node(int val)
		{
			data = val;
		}
	}

	Node root = null;

	@Override
	public void setArray(int[] a)
	{
		init(a);
	}

	@Override
	public void init(int[] a)
	{
		clear();
		if (a.length == 0)
		{
			addStart(0);
			flagLength0 = true;
		} else
		{
			for (int i = a.length - 1; i >= 0; i--)
			{
				addStart(a[i]);
			}
		}
	}

	@Override
	public int[] toArray()
	{
		int[] ar;
		if (flagLength0)
		{
			ar = new int[0];
		} else
		{
			ar = new int[size()];
			Node tmp = root;
			int i = 0;
			while (tmp != null)
			{
				ar[i++] = tmp.data;
				tmp = tmp.next;
			}
		}
		return ar;
	}

	@Override
	public int[] getArray()
	{
		return toArray();
	}

	@Override
	public void addStart(int val)
	{
		if (flagLength0)
		{
			root.data = val;
			flagLength0 = false;
		} else
		{
			Node tmp = new Node(val);
			tmp.next = root;
			root = tmp;
		}
	}

	@Override
	public void addEnd(int val)
	{
		if (flagLength0)
		{
			root.data = val;
			flagLength0 = false;
		} else
		{
			Node tmp = root;
			while (tmp.next != null)
			{
				tmp = tmp.next;
			}
			tmp.next = new Node(val);
		}
	}

	@Override
	public void addPos(int pos, int val)
	{
		if (pos >= size() && !flagLength0)
		{
			throw new IndexOutOfBoundsException();
		}
		if (flagLength0)
		{
			root.data = val;
			flagLength0 = false;
		} else if (pos == 0)
		{
			addStart(val);
		} else
		{
			Node tmp = root;
			Node tmpVal = new Node(val);
			for (int i = 1; i < pos; i++)
			{
				tmp = tmp.next;
			}
			tmpVal.next = tmp.next;
			tmp.next = tmpVal;
		}
	}

	@Override
	public void delStart()
	{
		if (flagLength0)
		{
			throw new NegativeArraySizeException();
		}
		if (size() == 1)
		{
			flagLength0 = true;
		} else
		{
			root = root.next;
		}
	}

	@Override
	public void delEnd()
	{
		if (flagLength0)
		{
			throw new NegativeArraySizeException();
		}
		if (size() == 1)
		{
			flagLength0 = true;
		} else
		{
			Node tmp = root;
			Node tempPreView = null;
			while (tmp.next != null)
			{
				tempPreView = tmp;
				tmp = tmp.next;
			}
			tempPreView.next = null;
		}
	}

	@Override
	public void delPos(int pos)
	{
		if (flagLength0)
		{
			throw new NegativeArraySizeException();
		}
		if (size() == 1)
		{
			flagLength0 = true;
		} else
		{
			Node tmp = root;
			Node tmpVal = null;
			for (int i = 0; i < pos; i++)
			{
				tmpVal = tmp;
				tmp = tmp.next;
			}
			tmpVal.next = tmp.next;
		}
	}

	@Override
	public int max()
	{
		if (flagLength0)
		{
			throw new IndexOutOfBoundsException();
		}
		int ret = root.data;
		Node tmp = root.next;
		while (tmp != null)
		{
			if (tmp.data > ret)
			{
				ret = tmp.data;
			}
			tmp = tmp.next;
		}
		return ret;
	}

	@Override
	public int min()
	{
		if (flagLength0)
		{
			throw new IndexOutOfBoundsException();
		}
		int ret = root.data;
		Node tmp = root.next;
		while (tmp != null)
		{
			if (tmp.data < ret)
			{
				ret = tmp.data;
			}
			tmp = tmp.next;
		}
		return ret;
	}

	@Override
	public int minIndex()
	{
		if (flagLength0)
		{
			throw new IndexOutOfBoundsException();
		}
		int minVal = root.data;
		int minIndex = 0;
		int count = 0;
		Node tmp = root.next;
		while (tmp != null)
		{
			count++;
			if (tmp.data < minVal)
			{
				minIndex = count;
				minVal = tmp.data;
			}
			tmp = tmp.next;
		}
		return minIndex;
	}

	@Override
	public int maxIndex()
	{
		if (flagLength0)
		{
			throw new IndexOutOfBoundsException();
		}
		int maxVal = root.data;
		int maxIndex = 0;
		int count = 0;
		Node tmp = root.next;
		while (tmp != null)
		{
			count++;
			if (tmp.data > maxVal)
			{
				maxIndex = count;
				maxVal = tmp.data;
			}
			tmp = tmp.next;
		}
		return maxIndex;
	}

	@Override
	public void reverse()
	{
		if (flagLength0)
		{
			return;
		}
		Node tmp = root;
		root = null;
		while (tmp != null)
		{
			addStart(tmp.data);
			tmp = tmp.next;
		}
	}

	@Override
	public void sort()
	{
		if (flagLength0)
		{
			return;
		}
		for (int i = size() - 1; i >= 1; i--)
		{
			boolean sorted = true;
			for (int j = 0; j < i; j++)
			{
				if (get(j) > get(j + 1))
				{
					int temp = get(j);
					set(j, get(j + 1));
					set(j + 1, temp);
					sorted = false;
				}
			}
			if (sorted)
			{
				break;
			}
		}
	}

	@Override
	public void set(int pos, int val)
	{
		if (flagLength0)
		{
			throw new IndexOutOfBoundsException();
		}
		Node tmp = root;
		for (int i = 0; i < pos; i++)
		{
			tmp = tmp.next;
		}
		tmp.data = val;
	}

	@Override
	public int get(int pos)
	{
		if (flagLength0)
		{
			throw new IndexOutOfBoundsException();
		}
		Node tNode = root;
		for (int i = 0; i < pos; i++)
		{
			tNode = tNode.next;
		}
		return tNode.data;
	}

	@Override
	public int size()
	{
		int ret = 0;
		if (flagLength0)
		{
			return ret;
		}
		Node tmp = root;
		while (tmp != null)
		{
			ret++;
			tmp = tmp.next;
		}
		return ret;
	}

	@Override
	public void clear()
	{
		flagLength0 = false;
		root = null;
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new LListIter(root);
	}

	class LListIter implements Iterator<Integer>
	{
		Node p;

		public LListIter(Node root)
		{
			p = root;
		}

		@Override
		public boolean hasNext()
		{
			return p != null;
		}

		@Override
		public Integer next()
		{
			int data = p.data;
			p = p.next;
			return data;
		}

		@Override
		public void remove()
		{
			// TODO Auto-generated method stub

		}

	}
}
