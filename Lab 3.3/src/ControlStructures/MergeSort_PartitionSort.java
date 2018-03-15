package ControlStructures;

import java.util.Arrays;

public class MergeSort_PartitionSort {

	public static void main(String[] args)
	{
		String[] a = {"d", "e", "f", "g", "a", "b", "c"};
		String[] m1 = {"a", "c", "e"};
		String[] m2 = {"b", "d", "f"};
		for(String x : a)
		{
			System.out.print(x + ", ");
		}
		
		System.out.println();
		
		long in = System.nanoTime();
		//String[] s =
		String[] m = mergeSort(a);
		long out = System.nanoTime();
		long time = out - in;
		
		System.out.println("mergeSort took " + time + " ns.");	
		for(String x : m)
		{
			System.out.print(x + ", ");
		}
	}
	
	public static String[] mergeSort(String[] S)
	{
		if(S.length >= 2)
		{
			String[] s1 = new String[S.length/2];
			for(int i = 0; i < s1.length; i++)
			{
				s1[i] = S[i];
			}
			String[] s2 = new String[S.length-S.length/2];
			for(int i = s1.length; i < S.length; i++)
			{
				s2[i - s1.length] = S[i];
			}
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
		while(xc + yc < combo.length)
		{
			
				while(x[xc].compareTo(y[yc])<0)
				{
					combo[xc + yc] = x[xc];
					if(xc < x.length-1)
					{
						xc++;
					}
				}
				while(x[xc].compareTo(y[yc])>=0)
				{
					combo[xc + yc] = y[yc];
					if(yc < y.length-1)	
					{
						yc++;
					}
				}
		}
		return combo;
	}
	
	public static String[] partitionSort(String[] x, int a, int b)
	{
		int p = partition(x, a, b);
		if(x.length>1)	
		{
				partitionSort(x, a, p-1);
				partitionSort(x, p+1, b);
		}
		return x;
	}
	
	public static int partition(String[] x, int a, int b)
	{
		int Piv = (b-a)/2;
		String P = x[(b-a)/2];
		int R = b;
		int L = a;
		boolean Lb;
		boolean Rb;
		while(L<R)
		{
		//	if(x[L].compareTo(P)>0)
			
			
			Lb = true;
			Rb = true;
			while(Lb)
			{
				if(L==Piv)
				{
					swap(x, Piv, Piv+1);
					Piv++;
				}
				if((x[L].compareTo(P)>0))
				{
					Lb = false;
				}
				L++;
			}
			while(Rb)
			{
				if(R==Piv)
				{
					swap(x, Piv, Piv-1);
					Piv--;
				}
				if((x[R].compareTo(P)<=0))
				{
					Rb = false;
				}
				R--;
			}
			swap(x, L, R);
			for(String s : x)
			{
				System.out.print(s + ", ");
			}
		}
		return Piv;
	}
	
	//public static int partition(String[] x, int a, int b)
	//{
		//int Piv = a;
//		String P = x[a];
	//	int Lmax = a + 1;
	//	int Lmin = Lmax;
	//	int Rmin;
//		int Rmax;
//	
//		
//		while(Lmin < b + 1)
	//	{
//			Lmin = Lmax;
//			if(x[Lmin].compareTo(P)>=0)
//			{	
//				while((x[Lmax].compareTo(P)>=0))
//				{
//					Lmax++;
//				}
//				Rmin = Lmax;
//				Rmax = Lmax;
//			Lmax--;
//				while(x[Rmax].compareTo(P)<0)
	//			{
	//				Rmax++;
	//			}
	//			Rmax--;
	//			swapChunks(x, Lmin, Lmax, Rmin, Rmax);
	//		}
	//		else
	//		{
	//			while((x[Lmin].compareTo(P)<0))
	//			{
	//				Lmax++;
	//			}
	//			Lmax--;
	//			swapChunk(x, Piv, Lmin, Lmax);
	//			Piv = Lmax;
	//			Lmin = Piv + 1;
	//		}
	//		Lmax++;
	//	}
//		return Piv;
	//}
	// only for when P == L-1!!!!!!!!!
	public static void swapChunk(String[] a, int P, int L, int U)
	{
		String p = a[P];
		for(int x = 0; x <= U-L; x++)
		{
			a[P+x] = a[L+x];
			a[x] = p;
		}
	}
	public static void swapChunks(String[] a, int Lmin, int Lmax, int Rmin, int Rmax)
	{
		String[] Left = new String[Lmax-Lmin];
		for(int x = 0; x < Left.length; x++)
		{
			Left[x] = a[Lmin+x];
		}
		
		for(int i = Lmin; i < Lmin + Rmax - Rmin; i++)
		{
			swap(a, Lmin + i, Rmin + i);
		}
		for(int x = 0; x < Left.length; x++)
		{
			a[Lmin+Rmax-Rmin+x] = Left[x];
		}
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
