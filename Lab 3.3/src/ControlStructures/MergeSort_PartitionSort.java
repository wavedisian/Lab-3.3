package ControlStructures;

import java.util.Arrays;

public class MergeSort_PartitionSort {

	public static void main(String[] args)
	{
		String[] a = {"d", "f", "a", "g", "c", "b", "e"};
		for(String x : a)
		{
			System.out.print(x + ", ");
		}
		System.out.println();
		long in = System.nanoTime();
		String[] b = mergeSort(a);
		long out = System.nanoTime();
		long time = out - in;
		System.out.println("mergeSort took " + time + " ns");
		for(String x : b)
		{
			System.out.print(x + ", ");
		}
	}
	
	public static String[] mergeSort(String[] S)
	{
		if(S.length >= 2)
		{
			String[] s1 = new String[S.length/2];
			s1 = Arrays.copyOfRange(S, 0, (S.length/2)-1);
			String[] s2 = new String[S.length-S.length/2];
			s2 = Arrays.copyOfRange(S, S.length/2, S.length-1);
			return merge(mergeSort(s1), mergeSort(s2));
		}
		else
		{
			return S;
		}
	}
	
	
	public static String[] merge(String[] x, String[] y)
	{
		String[] combo = new String[x.length + y.length];
		int xc = 0;
		int yc = 0;
		while(xc + yc < (x.length + y.length) - 1)
		{
			if(x[xc].compareTo(y[yc])>=0)
			{
				combo[xc + yc] = y[yc];
				yc++;
			}
			if(x[xc].compareTo(y[yc])<0)
			{
				combo[xc + yc] = x[xc];
				xc++;
			}
		}
		return combo;
	}
	
	public static String[] partitionSort(String[] x, int a, int b)
	{
		int p = partition(x, a, b);
		partitionSort(x)
		
	}
	
	public static int partition(String[] x, int a, int b)
	{
		String P = x[0];
		int Piv = 0;
		int L = a;
		int R = b;
		while(R > L)
		{
			while(x[R].compareTo(P)<=0)
			{	
				R--;
			}
			swap(x, Piv, R);
			Piv = R - 1;
			while(x[L].compareTo(P)>=0)
			{		
				L++;
			}
			swap(x, Piv, L);
			Piv = L + 1;
		}
		return Piv;
	}
	
	public static void swap(int[] a, int x, int y)
	{
		int s = a[x];
		a[x] = a[y];
		a[y] = s;
	}
	public static void swap(double[] a, int x, int y)
	{
		double s = a[x];
		a[x] = a[y];
		a[y] = s;
	}
	public static void swap(String[] a, int x, int y)
	{
		String s = a[x];
		a[x] = a[y];
		a[y] = s;
	}
}