import java.util.Iterator;

/*Лист у которого масив всегода имеет 100 элементов, 
 * а его рабочая область определяется: начало - начало масива 
 * и конец - индексом
 */
public class AList1 implements ExList, Iterable<Integer>
{
	private int[] arr = new int[100];
	private int index = 0;

	@Override
	public void setArray(int[] a)
	{
		init(a);
	}

	@Override
	public int size()
	{
		return index;
	}

	@Override
	public void init(int[] arr)
	{
		if (arr == null)
		{
			throw new NullPointerException();
		}
		clear();
		for (int i = 0; i < arr.length; i++)
		{
			this.arr[i] = arr[i];
		}
		index = arr.length;
	}

	@Override
	public void addEnd(int val)
	{
		arr[index++] = val;
	}

	@Override
	public int[] getArray()
	{
		int[] temp = new int[index];
		for (int i = 0; i < index; i++)
		{
			temp[i] = arr[i];
		}
		return temp;
	}

	// Найти мaксимальный элемент массива
	@Override
	public int max()
	{
		if (index == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		int chMax = arr[0];
		for (int i = 0; i < index; i++)
		{
			if (arr[i] > chMax)
			{
				chMax = arr[i];
			}
		}
		return chMax;
	}

	// Найти минимальный элемент массива
	@Override
	public int min()
	{
		if (index == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		int chMax = arr[0];
		for (int i = 0; i < index; i++)
		{
			if (arr[i] < chMax)
			{
				chMax = arr[i];
			}
		}
		return chMax;
	}

	// Найти индекс максимального элемента массива
	@Override
	public int maxIndex()
	{
		if (index == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		int indexRes = 0;
		int chMax = arr[0];
		for (int i = 1; i < index; i++)
		{
			if (arr[i] > chMax)
			{
				chMax = arr[i];
				indexRes = i;
			}
		}
		return indexRes;
	}

	// Найти индекс минимального элемента массива
	@Override
	public int minIndex()
	{
		if (index == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		int indexRes = 0;
		int chMin = arr[0];
		for (int i = 1; i < index; i++)
		{
			if (arr[i] < chMin)
			{
				indexRes = i;
				chMin = arr[i];
			}
		}
		return indexRes;
	}

	// Сделать реверс массива (массив в обратном направлении)
	@Override
	public void reverse()
	{
		int[] resArr = new int[arr.length];
		int j = 0;
		for (int i = index - 1; i >= 0; i--)
		{
			resArr[j] = arr[i];
			j++;
		}
		arr = resArr;
	}

	@Override
	public void sort()
	{

		for (int i = index - 1; i >= 1; i--)
		{
			boolean sorted = true;
			for (int j = 0; j < i; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
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
	public void delEnd()
	{
		if (index == 0)
		{
			throw new NegativeArraySizeException();
		}
		index--;
	}

	@Override
	public void addStart(int val)
	{
		index++;
		int[] tmp = new int[arr.length];
		for (int i = 1; i < size(); i++)
		{
			tmp[i] = arr[i - 1];
		}
		tmp[0] = val;
		arr = tmp;

	}

	@Override
	public void delStart()
	{
		if (index == 0)
		{
			throw new NegativeArraySizeException();
		}
		index--;
		int[] tmp = new int[arr.length];
		for (int i = 0; i < size(); i++)
		{
			tmp[i] = arr[i + 1];
		}
		arr = tmp;
	}

	@Override
	public void addPos(int pos, int val)
	{
		index++;

		int[] temp = new int[arr.length];
		for (int i = 0; i < size(); i++)
			if (i < pos)
			{
				temp[i] = arr[i];
			} else if (i == pos)
			{
				temp[pos] = val;
			} else
			{
				temp[i] = arr[i - 1];
			}
		arr = temp;
	}

	@Override
	public void delPos(int pos)
	{
		if (pos >= index)
		{
			throw new NegativeArraySizeException();
		}
		for (int i = pos; i < index; i++)
		{
			arr[i] = arr[i + 1];
		}
		index--;
	}

	@Override
	public void set(int pos, int val)
	{
		if (pos >= index)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		arr[pos] = val;
	}

	@Override
	public int get(int pos)
	{
		if (pos >= index)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		return arr[pos];
	}

	@Override
	public void clear()
	{
		index = 0;
	}

	@Override
	public int[] toArray()
	{
		int[] temp = new int[index];
		for (int i = 0; i < index; i++)
		{
			temp[i] = arr[i];
		}
		return temp;
	}

	/*
	 * @Override public Iterator<Integer> iterator() {
	 * 
	 * return new AListIter(toArray()); }
	 * 
	 * class AListIter implements Iterator<Integer> { int[] arr = null; int
	 * index = 0;
	 * 
	 * public AListIter(int[] arr) { this.arr = arr; }
	 * 
	 * @Override public boolean hasNext() { return index < arr.length; }
	 * 
	 * @Override public Integer next() { return arr[index++]; }
	 * 
	 * @Override public void remove() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	public Iterator<Integer> iterator()
	{

		return new AListIter(toArray(), index);
	}

	class AListIter implements Iterator<Integer>
	{
		int[] arr = null;
		int index = 0;
		int top = 0;

		public AListIter(int[] arr, int x)
		{
			top = x;
			this.arr = arr;
		}

		@Override
		public boolean hasNext()
		{
			return index < top;
		}

		@Override
		public Integer next()
		{
			return arr[index++];
		}

		@Override
		public void remove()
		{
			// TODO Auto-generated method stub

		}
	}
}
