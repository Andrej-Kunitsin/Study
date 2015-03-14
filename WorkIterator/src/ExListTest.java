import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

// Запрещено инициализировать масив NULL
// передача масива с длинной 0 это объект ПУСТЫШКА, в него можно добавить
// с ноливой позиции, запрещено удалять и читать.

public class ExListTest
{
	ExList xx;

	@Before
	public void qwe()
	{
		xx = new AList1();
	}

	@Test(expected = NullPointerException.class)
	public void testInit_NULL()
	{
		int[] zz = null;
		xx.init(zz);
	}

	@Test
	public void testInit_0()
	{
		int[] zz = {};
		int[] exp = {};
		xx.setArray(zz);
		int[] res = xx.toArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testInit_1()
	{
		int[] zz = { 10 };
		int[] exp = { 10 };
		xx.setArray(zz);
		int[] res = xx.toArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testInit_2()
	{
		int[] zz = { 10, 15 };
		int[] exp = { 10, 15 };
		xx.setArray(zz);
		int[] res = xx.toArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testInit_many()
	{
		int[] zz = { 10, 15, 20, 25, 30 };
		int[] exp = { 10, 15, 20, 25, 30 };
		xx.setArray(zz);
		int[] res = xx.toArray();
		assertArrayEquals(exp, res);
	}

	@Test(expected = NullPointerException.class)
	public void testToArray_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test
	public void testToArray_0()
	{
		int[] zz = {};
		int[] exp = {};
		xx.setArray(zz);
		int[] res = xx.toArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testToArray_1()
	{
		int[] zz = { 10 };
		int[] exp = { 10 };
		xx.setArray(zz);
		int[] res = xx.toArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testToArray_2()
	{
		int[] zz = { 10, 15 };
		int[] exp = { 10, 15 };
		xx.setArray(zz);
		int[] res = xx.toArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testToArray_many()
	{
		int[] zz = { 10, 15, 20, 25, 30 };
		int[] exp = { 10, 15, 20, 25, 30 };
		xx.setArray(zz);
		int[] res = xx.toArray();
		assertArrayEquals(exp, res);
	}

	@Test(expected = NullPointerException.class)
	public void testAddStart_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test
	public void testAddStart_0()
	{
		int[] zz = {};
		int[] exp = { 5 };
		xx.setArray(zz);
		xx.addStart(5);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testAddStart_1()
	{
		int[] zz = { 10 };
		int[] exp = { 5, 10 };
		xx.setArray(zz);
		xx.addStart(5);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testAddStart_2()
	{
		int[] zz = { 10, 20 };
		int[] exp = { 5, 10, 20 };
		xx.setArray(zz);
		xx.addStart(5);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testAddStart_many()
	{
		int[] zz = { 10, 20, 77, 11, 24, 99, 32 };
		int[] exp = { 5, 10, 20, 77, 11, 24, 99, 32 };
		xx.setArray(zz);
		xx.addStart(5);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test(expected = NullPointerException.class)
	public void testAddEnd_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test
	public void testAddEnd_0()
	{
		int[] zz = {};
		int[] exp = { 5 };
		xx.setArray(zz);
		xx.addEnd(5);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testAddEnd_1()
	{
		int[] zz = { 10 };
		int[] exp = { 10, 5 };
		xx.setArray(zz);
		xx.addEnd(5);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testAddEnd_2()
	{
		int[] zz = { 10, 20 };
		int[] exp = { 10, 20, 5 };
		xx.setArray(zz);
		xx.addEnd(5);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testAddEnd_many()
	{
		int[] zz = { 10, 20, 77, 11, 24, 99, 32 };
		int[] exp = { 10, 20, 77, 11, 24, 99, 32, 5 };
		xx.setArray(zz);
		xx.addEnd(5);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test(expected = NullPointerException.class)
	public void testAddPos_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test
	public void testAddPos_0()
	{
		int[] zz = {};
		int[] exp = { 5 };
		xx.setArray(zz);
		xx.addPos(0, 5);
		assertArrayEquals(exp, xx.getArray());
	}

	@Test
	public void testAddPos_1()
	{
		int[] zz = { 10, 5 };
		int[] exp = { 2, 10, 5 };
		xx.setArray(zz);
		xx.addPos(0, 2);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testAddPos_2()
	{
		int[] zz = { 10, 20 };
		int[] exp = { 10, 5, 20 };
		xx.setArray(zz);
		xx.addPos(1, 5);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testAddPos_many()
	{
		int[] zz = { 10, 20, 77, 11, 24, 99, 32 };
		int[] exp = { 10, 20, 77, 11, 154, 24, 99, 32 };

		xx.setArray(zz);
		xx.addPos(4, 154);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test(expected = NullPointerException.class)
	public void testDelStart_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test(expected = NegativeArraySizeException.class)
	public void testDelStart_0()
	{
		int[] zz = {};
		xx.setArray(zz);
		xx.delStart();
	}

	@Test
	public void testDelStart_1()
	{
		int[] zz = { 10 };
		int[] exp = {};
		xx.setArray(zz);
		xx.delStart();
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testDelStart_2()
	{
		int[] zz = { 10, 20 };
		int[] exp = { 20 };

		xx.setArray(zz);
		xx.delStart();
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testDelStart_many()
	{
		int[] zz = { 10, 20, 77, 11, 24, 99, 32 };
		int[] exp = { 20, 77, 11, 24, 99, 32 };

		xx.setArray(zz);
		xx.delStart();
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test(expected = NullPointerException.class)
	public void testDelEnd_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test(expected = NegativeArraySizeException.class)
	public void testDelEnd_0()
	{
		int[] zz = {};
		xx.setArray(zz);
		xx.delEnd();
	}

	@Test
	public void testDelEnd_1()
	{
		int[] zz = { 10 };
		int[] exp = {};
		xx.setArray(zz);
		xx.delEnd();
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testDelEnd_2()
	{
		int[] zz = { 10, 20 };
		int[] exp = { 10 };

		xx.setArray(zz);
		xx.delEnd();
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testDelEnd_many()
	{
		int[] zz = { 10, 20, 77, 11, 24, 99, 32 };
		int[] exp = { 10, 20, 77, 11, 24, 99 };

		xx.setArray(zz);
		xx.delEnd();
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test(expected = NullPointerException.class)
	public void testDelPos_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test(expected = NegativeArraySizeException.class)
	public void testDelPos_0()
	{
		int[] zz = {};
		xx.setArray(zz);
		xx.delPos(0);
	}

	@Test
	public void testDelPos_1()
	{
		int[] zz = { 10 };
		int[] exp = {};
		xx.setArray(zz);
		xx.delPos(0);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testDelPos_2()
	{
		int[] zz = { 10, 20 };
		int[] exp = { 10 };
		xx.setArray(zz);
		xx.delPos(1);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testDelPos_many()
	{
		int[] zz = { 10, 20, 77, 11, 24, 99, 32 };
		int[] exp = { 10, 20, 77, 11, 99, 32 };
		xx.setArray(zz);
		xx.delPos(4);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test(expected = NullPointerException.class)
	public void testClear_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test
	public void testClear_0()
	{
		int[] zz = {};
		int[] exp = {};
		xx.setArray(zz);
		xx.clear();
		assertArrayEquals(exp, xx.toArray());
	}

	@Test
	public void testClear_1()
	{
		int[] zz = { 10 };
		int[] exp = {};
		xx.setArray(zz);
		xx.clear();
		assertArrayEquals(exp, xx.toArray());
	}

	@Test
	public void testClear_2()
	{
		int[] zz = { 10, 54 };
		int[] exp = {};
		xx.setArray(zz);
		xx.clear();
		assertArrayEquals(exp, xx.toArray());
	}

	@Test
	public void testClear_many()
	{
		int[] zz = { 25, 11, 45, 23, 66 };
		int[] exp = {};
		xx.setArray(zz);
		xx.clear();
		assertArrayEquals(exp, xx.toArray());
	}

	@Test(expected = NullPointerException.class)
	public void testSize_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test
	public void testSize_0()
	{
		int[] zz = {};
		int exp = 0;
		xx.setArray(zz);
		int res = xx.size();
		assertEquals(exp, res);
	}

	@Test
	public void testSize_1()
	{
		int[] zz = { 10 };
		int exp = 1;
		xx.setArray(zz);
		int res = xx.size();
		assertEquals(exp, res);
	}

	@Test
	public void testSize_2()
	{
		int[] zz = { 10, 25 };
		int exp = 2;
		xx.setArray(zz);
		int res = xx.size();
		assertEquals(exp, res);
	}

	@Test
	public void testSize_many()
	{
		int[] zz = { 10, 25, 66, 85, 44 };
		int exp = 5;
		xx.setArray(zz);
		int res = xx.size();
		assertEquals(exp, res);
	}

	@Test(expected = NullPointerException.class)
	public void testSet_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testSet_0()
	{
		int[] zz = {};
		xx.setArray(zz);
		xx.set(0, 5);
	}

	@Test
	public void testSet_1()
	{
		int[] zz = { 10 };
		int[] exp = { 5 };
		xx.setArray(zz);
		xx.set(0, 5);
		assertArrayEquals(exp, xx.getArray());
	}

	@Test
	public void testSet_2()
	{
		int[] zz = { 10, 15 };
		int[] exp = { 5, 15 };
		xx.setArray(zz);
		xx.set(0, 5);
		assertArrayEquals(exp, xx.getArray());
	}

	@Test
	public void testSet_many()
	{
		int[] zz = { 10, 15, 20, 25, 30 };
		int[] exp = { 10, 15, 50, 25, 30 };
		xx.setArray(zz);
		xx.set(2, 50);
		assertArrayEquals(exp, xx.getArray());
	}

	@Test(expected = NullPointerException.class)
	public void testGet_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet_0()
	{
		int[] zz = {};
		xx.setArray(zz);
		xx.get(0);
	}

	@Test
	public void testGet_1()
	{
		int[] zz = { 10 };
		int exp = 10;
		xx.setArray(zz);
		int res = xx.get(0);
		assertEquals(exp, res);
	}

	@Test
	public void testGet_2()
	{
		int[] zz = { 10, 25 };
		int exp = 10;
		xx.setArray(zz);
		int res = xx.get(0);
		assertEquals(exp, res);
	}

	@Test
	public void testGet_many()
	{
		int[] zz = { 10, 15, 20, 25, 30 };
		int exp = 20;
		xx.setArray(zz);
		int res = xx.get(2);
		assertEquals(exp, res);
	}

	@Test(expected = NullPointerException.class)
	public void testMax_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testMax_0()
	{
		int[] zz = {};
		xx.setArray(zz);
		xx.max();
	}

	@Test
	public void testMax_1()
	{
		int[] zz = { 10 };
		xx.setArray(zz);
		int res = xx.max();
		assertEquals(10, res);
	}

	@Test
	public void testMax_2()
	{
		int[] zz = { 10, 20 };
		xx.setArray(zz);
		int res = xx.max();
		assertEquals(20, res);
	}

	@Test
	public void testMax_many()
	{
		int[] zz = { 10, 20, 77, 11, 24, 99, 32 };
		xx.setArray(zz);
		int res = xx.max();
		assertEquals(99, res);
	}

	@Test(expected = NullPointerException.class)
	public void testMin_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testMin_0()
	{
		int[] zz = {};
		xx.setArray(zz);
		xx.min();
	}

	@Test
	public void testMin_1()
	{
		int[] zz = { 10 };
		xx.setArray(zz);
		int res = xx.min();
		assertEquals(10, res);
	}

	@Test
	public void testMin_2()
	{
		int[] zz = { 10, 20 };
		xx.setArray(zz);
		int res = xx.min();
		assertEquals(10, res);
	}

	@Test
	public void testMin_many()
	{
		int[] zz = { 10, 20, 77, 11, 24, 99, 32 };
		xx.setArray(zz);
		int res = xx.min();
		assertEquals(10, res);
	}

	@Test(expected = NullPointerException.class)
	public void testMaxIndex_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testMaxIndex_0()
	{
		int[] zz = {};
		xx.setArray(zz);
		xx.maxIndex();
	}

	@Test
	public void testMaxIndex_1()
	{
		int[] zz = { 10 };

		xx.setArray(zz);
		int res = xx.maxIndex();
		assertEquals(0, res);
	}

	@Test
	public void testMaxIndex_2()
	{
		int[] zz = { 10, 20 };

		xx.setArray(zz);
		int res = xx.maxIndex();
		assertEquals(1, res);
	}

	@Test
	public void testMaxIndex_many()
	{
		int[] zz = { 10, 20, 77, 11, 24, 99, 32 };

		xx.setArray(zz);
		int res = xx.maxIndex();
		assertEquals(5, res);
	}

	// ======================================
	// minIndex
	// ======================================
	@Test(expected = NullPointerException.class)
	public void testMinIndex_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testMinIndex_0()
	{
		int[] zz = {};
		xx.setArray(zz);
		xx.minIndex();
	}

	@Test
	public void testMinIndex_1()
	{
		int[] zz = { 10 };

		xx.setArray(zz);
		int res = xx.minIndex();
		assertEquals(0, res);
	}

	@Test
	public void testMinIndex_2()
	{
		int[] zz = { 10, 20 };

		xx.setArray(zz);
		int res = xx.minIndex();
		assertEquals(0, res);
	}

	@Test
	public void testMinIndex_many()
	{
		int[] zz = { 10, 20, 77, 11, 24, 99, 32 };

		xx.setArray(zz);
		int res = xx.minIndex();
		assertEquals(0, res);
	}

	@Test(expected = NullPointerException.class)
	public void testReversArr_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test
	public void testReversArr_0()
	{
		int[] zz = {};
		int[] exp = {};
		xx.setArray(zz);
		xx.reverse();
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testReversArr_1()
	{
		int[] zz = { 10 };

		xx.setArray(zz);
		xx.reverse();
		int[] res = xx.getArray();
		assertArrayEquals(zz, res);
	}

	@Test
	public void testReversArr_2()
	{
		int[] zz = { 10, 20 };
		int[] exp = { 20, 10 };

		xx.setArray(zz);
		xx.reverse();
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testReversArr_many()
	{
		int[] zz = { 10, 20, 77, 11, 24, 99, 32 };
		int[] exp = { 32, 99, 24, 11, 77, 20, 10 };

		xx.setArray(zz);
		xx.reverse();
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test(expected = NullPointerException.class)
	public void testSortArr_NULL()
	{
		int[] zz = null;
		xx.setArray(zz);
	}

	@Test
	public void testSortArr_0()
	{
		int[] zz = {};
		int[] exp = {};
		xx.setArray(zz);
		xx.sort();
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);

	}

	@Test
	public void testSortArr_1()
	{
		int[] zz = { 10 };
		xx.setArray(zz);
		xx.sort();
		int[] res = xx.getArray();
		assertArrayEquals(zz, res);
	}

	@Test
	public void testSortArr_2()
	{
		int[] zz = { 10, 20 };
		int[] exp = { 10, 20 };
		xx.setArray(zz);
		xx.sort();
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testSortArr_many()
	{
		int[] zz = { 20, 10, 77, 11, 24, 99, 32 };
		int[] exp = { 10, 11, 20, 24, 32, 77, 99 };
		xx.setArray(zz);
		xx.sort();
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void testTEMP()
	{
		int[] zz = { 10, 20, 32 };
		int[] exp = { 10, 20, 32, 5 };
		xx.init(zz);
		xx.addEnd(5);
		int[] res = xx.getArray();
		assertArrayEquals(exp, res);
	}
}