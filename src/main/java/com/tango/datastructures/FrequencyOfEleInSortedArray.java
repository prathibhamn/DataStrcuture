package com.tango.datastructures;

public class FrequencyOfEleInSortedArray {
	
	static int count(int arr[],int toFind,int origArrLngth)
	{
		
		int i=0;
		int j=0;
		i =first(arr,0,origArrLngth,toFind,origArrLngth);
		if (i==-1)
		{
			return i;
		}
		j= last(arr,i,origArrLngth,toFind,origArrLngth);
		return j-i+1;
	}

	static int first(int arr[], int low, int high, int toFind, int origArrLngth) {

		if (high >= low) {

			int mid = (high + low) / 2;
			if ((mid == 0 || toFind > arr[mid - 1]) && arr[mid] == toFind) {
				return mid;
			}

			else if (toFind > arr[mid])

				return first(arr, mid + 1, high, toFind, origArrLngth);
			else
				return first(arr, 0, mid - 1, toFind, origArrLngth);
		}
		return -1;
	}
	
	static int last(int arr[], int low, int high,int toFind, int origArrLngth)
	{
		if(high>=low)
		{
			int mid = (high+low)/2;
			if((mid==origArrLngth-1||toFind <arr[mid+1])&&arr[mid]==toFind)
			{
				return mid;
			}
			else if(toFind <arr[mid])
				return last(arr,low,mid-1,toFind,origArrLngth);
			else return last(arr,mid+1,high,toFind,origArrLngth);
		}
		return -1;
		
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 2, 3, 3, 3, 3};
        
        // Element to be counted in arr[]
        int x =  2; 
        int n = arr.length;
        int c = count(arr, x, n);
        System.out.println(x+" occurs "+c+" times");
	}

}
