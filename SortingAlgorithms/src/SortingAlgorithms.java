
/**
 * This class represent five sorting algorithm, selection sort, 
 * merge sort, heap sort, and quick sort with first element 
 * being the pivot and random element being the pivot.
 */
import java.util.Random;

public class SortingAlgorithms {
	
	long comparisons;
	
	/**
	 * Constructor
	 */
	public SortingAlgorithms() {
		this.comparisons = 0;
	}

	/**
	 * Return comparisons
	 * @return comparisons
	 */
	public long getComparisons() {
		return this.comparisons;
	}
	
	/**
	 * Reset comparisons to 0
	 */
	public void resetComparisons() {
		this.comparisons = 0;
	}
	
	/**
	 * Print out the array
	 * @param arr the array
	 */
	public void print(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}
	
	/**
	 * Swap the position of two elements in an array.
	 * @param arr the array
	 * @param a the index of the first element
	 * @param b the index of the second element
	 */
	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	/**
	 * Find the smallest element in an array
	 * @param arr the array
	 * @param startingIndex the index to begin searching
	 * @return the index of the smallest element
	 */
	private int findMinIndex(int[] arr, int startingIndex) {
		int min = arr[startingIndex], minIndex = startingIndex;
		for (int i = startingIndex+1; i < arr.length; ++i) {
			if (arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}
			this.comparisons += 1;
		}
		return minIndex;
	}
	/**
	 * Selection sort
	 * @param arr the array to be sorted
	 */
	public void selectionSort(int[] arr) {
		this.comparisons = 0;
		int current = 0;
		while (current < arr.length-1) {
			swap(arr, current, findMinIndex(arr, current));
			current += 1;
		}
	}
	
	/**
	 * Helper function for merge sort
	 * @param arr the array to be sorted
	 * @param start the head of the array
	 * @param mid the mid point of the array
	 * @param end the tail of the array
	 */
	private void merge(int[] arr, int start, int mid, int end) {
		int lengthOfLeft = mid - start + 1, lengthOfRight = end - mid;
		
		int[] left = new int[lengthOfLeft];
		int[] right = new int[lengthOfRight];
		
		for (int i = 0; i < lengthOfLeft; ++i) {
			left[i] = arr[start+i];
		}
		for (int i = 0; i < lengthOfRight; ++i) {
			right[i] = arr[mid+1+i];
		}
		
		int l = 0, r = 0, i = start;
		while (l < lengthOfLeft && r < lengthOfRight) {
			if (left[l] <= right[r]) {
				arr[i] = left[l];
				++l;
			} else {
				arr[i] = right[r];
				++r;
			}
			++i;
			this.comparisons += 1;
		}
		while (l < lengthOfLeft) {
			arr[i] = left[l];
			++l;
			++i;
		}
		while (r < lengthOfRight) {
			arr[i] = right[r];
			++r;
			++i;
		}
	}
	/**
	 * Merge sort
	 * @param arr the array to be sorted
	 * @param start the head of the array
	 * @param end the tail of the array
	 */
	public void mergeSort(int[] arr, int start, int end) {
		if (end > start) {
			int mid = start + (end-start) / 2;
			
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	
	/**
	 * Helper function for heap sort
	 * @param arr the array to be sorted
	 * @param length the length of arr
	 * @param index the index of the root
	 */
	private void heapify(int[] arr, int length, int index) {
		int largest = index, leftChild = 2*index + 1, rightChild = 2*index + 2;
		
		if (leftChild < length && arr[leftChild] > arr[largest]) {
			largest = leftChild;
		}
		if (rightChild < length && arr[rightChild] > arr[largest]) {
			largest = rightChild;
		}
		this.comparisons += 2;
		
		if (largest != index) {
			swap(arr, largest, index);
			heapify(arr, length, largest);
		}
	}
	/**
	 * Heap sort
	 * @param arr the array to be sorted
	 */
	public void heapSort(int[] arr) {
		int length = arr.length;
		
		for (int i = length/2-1; i >= 0; --i) {
			heapify(arr, length, i);
		}
		
		for (int i = length-1; i > 0; --i) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}
	
	/**
	 * Helper function for quick sort with the first element as pivot
	 * @param arr the array to be sorted
	 * @param start the head of the array
	 * @param end the end of the array
	 * @return the index of the right position for the pivot
	 */
	private int partitionFp(int[] arr, int start, int end) {
		int pivot = arr[start], last = start;
		
		for (int i = start+1; i <= end; ++i) {
			if (arr[i] < pivot) {
				++last;
				swap(arr, last, i);
			}
			this.comparisons += 1; 
		}
		swap(arr, start, last);
		return last;
	}
	/**
	 * Quick sort that use the first element as pivot
	 * @param arr the array to be sorted
	 * @param start the head of the array
	 * @param end the tail of the array
	 */
	public void quickSortFp(int[] arr, int start, int end) {
		if (start < end) {
			int position = partitionFp(arr, start, end);
			quickSortFp(arr, start, position-1);
			quickSortFp(arr, position+1, end);
		}
	}
	
	/**
	 * Helper function for quick sort with a random element as pivot
	 * @param arr the array to be sorted
	 * @param start the head of the array
	 * @param end the end of the array
	 * @return the index of the right position for the pivot
	 */
	private int partitionRp(int[] arr, int start, int end) {
		Random rand= new Random(); 
        int pivotIndex = rand.nextInt(end-start)+start, pivot = arr[pivotIndex], last = start;
        swap(arr, start, pivotIndex);
		
		for (int i = start+1; i <= end; ++i) {
			if (arr[i] < pivot) {
				++last;
				swap(arr, last, i);
			}
			this.comparisons += 1; 
		}
		swap(arr, start, last);
		return last;
	}
	/**
	 * Quick sort that use a random element as pivot
	 * @param arr the array to be sorted
	 * @param start the head of the array
	 * @param end the tail of the array
	 */
	public void quickSortRp(int[] arr, int start, int end) {
		if (start < end) {
			int position = partitionRp(arr, start, end);
			quickSortRp(arr, start, position-1);
			quickSortRp(arr, position+1, end);
		}
	}
}
