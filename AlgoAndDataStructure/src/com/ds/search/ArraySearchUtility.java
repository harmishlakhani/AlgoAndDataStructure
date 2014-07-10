package com.ds.search;

public class ArraySearchUtility {

	//O(nlogn)
	public int findIncDecSequenceIndex(int[] array, int n) {
		
		int i = 0, j = n - 1;
		int mid = 0;
		
		if(n == 1)
			return array[0];
		else if(n == 2)
			return Math.max(array[i], array[j]);
		
		while(i <= j) {
			
			mid = i + (j - i)/2;
			
			if(array[mid - 1] < array[mid] && array[mid] > array[mid + 1])
				return array[mid];
			else if(array[mid - 1] < array[mid] && array[mid] < array[mid + 1])
				i = mid + 1;
			else if(array[mid - 1] > array[mid] && array[mid] > array[mid + 1])
				j = mid - 1;
		}
		
		return Integer.MIN_VALUE;
	}
	
	//O(nlogn)
	public int findElementInRotatedSortedArray(int[] array, int key) {
		
		int pivot = pivot(array, array.length);
		
		if(pivot == -1)
			return binarySearch(array, 0, array.length - 1, key);
		
		if(array[pivot] == key)
			return pivot;
		
		else if(array[0] <= key)
			return binarySearch(array, 0, pivot - 1, key);
		else if(array[0] > key)
			return binarySearch(array, pivot + 1, array.length, key);
		
		return Integer.MIN_VALUE;
	}
	
	//O(nlogn)
	public int pivot(int[] array, int n) {
		
		int i = 0, j = n - 1;
		int mid = 0;
		
		if(n == 1)
			return 0;
		else if(n == 2)
			return array[i] > array[j] ? i : j;
		
		while(i <= j) {
			
			mid = i + (j - i)/2;
			if(mid < j && array[mid] > array[mid + 1])
				return mid;
			
			if(array[mid] > array[i])
				i = mid + 1;
			else if(array[mid] <= array[i])
				j = mid - 1;
		}
		
		return -1;
	}
	
	//O(nlogn)
	public int binarySearch(int[] array, int low, int high, int key) {
		
		int i = low, j = high;
		int mid = 0;
		
		while(i <= j) {
			
			mid = i + (j - i)/2;
			if(array[mid] == key)
				return mid;
			else if(array[mid] > key)
				j = mid - 1;
			else if(array[mid] < key)
				i = mid + 1;
		}
		
		return -1;
	}
	
	//O(nlogn)
	public int findFirstOccuranceInArray(int[] array, int key) {
		
		int i = 0, j = array.length - 1;
		int mid = 0;
		
		while(i <= j) {
			
			mid = i + (j - i)/2;
			
			if(array[mid] == key && (i == mid || array[mid - 1] < array[mid]))
				return mid;
			
			if(key <= array[mid])
				j = mid - 1;
			else
				i = mid + 1;
		}
		
		return -1;
	}
	
	public int findLastOccuranceInArray(int[] array, int key) {
		
		int i = 0, j = array.length - 1;
		int mid = 0;
		
		while(i <= j) {
			
			mid = i + (j - i)/2;
			
			if(array[mid] == key && (j == mid || array[mid + 1] > array[mid]))
				return mid;
			
			if(key < array[mid])
				j = mid - 1;
			else
				i = mid + 1;
		}
		
		return -1;
	}
	
	public int countOccurance(int[] array, int key) {
		
		int leftOccurance = findFirstOccuranceInArray(array, key);
		int rightOccurance = findLastOccuranceInArray(array, key);
		
		return rightOccurance - leftOccurance + 1;
	}
	
	public void separateEvenOddInArray(int[] array) {
		
		int left = 0;
		int right = array.length - 1;
		
		while(left < right) {
			
			while(array[left] % 2 == 0 && left < right)
				left++;
			
			while(array[right] % 2 == 1 && left < right)
				right--;
			
			if(left < right) {
				array[left] = 0;
				array[right] = 1;
				left++;
				right--;
			}
		}
	}
	
	public void separate1s0sInArray(int[] array) {
		
		int left = 0, temp = 0;
		int right = array.length - 1;
		
		while(left < right) {
			
			while(array[left] == 0 && left < right)
				left++;
			
			while(array[right] == 1 && left < right)
				right--;
			
			if(left < right) {
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
	}
	
	public void print(int[] array) {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
	
 	public static void main(String[] args) {

		ArraySearchUtility obj = new ArraySearchUtility();
		//System.out.println(obj.findIncDecSequenceIndex(new int[]{-6,-5,-4,-3,-2,-1,5,3,2,1}, 10));
		//System.out.println(obj.findElementInRotatedSortedArray(new int[]{3,4,5,1,2}, 2));
		//System.out.println(obj.findElementInRotatedSortedArray(new int[]{1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, 1));
		//System.out.println(obj.findElementInRotatedSortedArray(new int[]{2, 3, 0, 2, 2, 2, 2, 2, 2, 2}, 3));
		//System.out.println(obj.findElementInRotatedSortedArray(new int[]{1, 2, 3, 4}, 4));
		//System.out.println(obj.findFirstOccuranceInArray(new int[]{1, 2, 3, 4, 4, 4}, 3));
		//System.out.println(obj.findLastOccuranceInArray(new int[]{1, 2, 3, 4, 4, 4}, 4));
		//System.out.println(obj.countOccurance(new int[]{1, 2, 3, 4, 4, 4}, 3));
		
		/*int[] array = new int[]{5, 7};
		obj.separateEvenOddInArray(array);
		obj.print(array);*/
		
		int[] array = new int[]{1, 0, 0, 0, 1, 1, 0};
		obj.separate1s0sInArray(array);
		obj.print(array);
		
	}

}
