package quickSort;


import homework2.LinkedDataStack;


public class QuickSort {
	
	/**
	 * a function that uses iterative quick sort to sort an array.
	 * @param array the target array
	 */
	public static void quickSortByIteration(int[] array, int firstIndex, int lastIndex) {
		
		if(firstIndex > lastIndex) {
			return;
		}
		LinkedDataStack<Integer> stack = new LinkedDataStack<>();
		stack.push(-1);
		stack.push(lastIndex);
		stack.push(firstIndex);
		int left;
		int right;
		int leftPointer;
		int rightPointer;
		int pivot;
		while(stack.peek() != -1) {
			left = stack.pop();
			leftPointer =left;
			right = stack.pop();
			rightPointer = right;
			pivot = array[(leftPointer + rightPointer) / 2];
			while(rightPointer >= leftPointer) {
				while(array[leftPointer] < pivot) {
					leftPointer++;
				}
				while(array[rightPointer] > pivot) {
					rightPointer--;
				}
				
				if(rightPointer >= leftPointer) {
					int temp = array[leftPointer];
					array[leftPointer] = array[rightPointer];
					array[rightPointer] = temp;
					leftPointer++;
					rightPointer--;
				}

			}
			if(rightPointer > left) {
				stack.push(rightPointer);
				stack.push(left);
			}

			
			if(right > leftPointer) {
				stack.push(right);
				stack.push(leftPointer);
			}

		}
	}// end quickSortByIteration
	
	
	/**
	 * a function that uses recursive quick sort to sort an array.
	 * @param array the target array
	 * @param firstIndex The index of the first unsorted element.
	 * @param lastIndex The index of the last unsorted element.
	 */
	public static void quickSortByRecursion(int[] array, int firstIndex, int lastIndex) {
		
		if(firstIndex <= lastIndex) {
			doQuickSort(array, firstIndex, lastIndex);
		}
	}// end quickSortByRecursion

	
	/**
	 * a function that uses recursive quick sort to sort an array.
	 * @param array the target array
	 * @param firstIndex the lower bound
	 * @param lastIndex the upper pound
	 */
	private static void doQuickSort(int[] array, int firstIndex, int lastIndex) {
		int left = firstIndex;
		int right = lastIndex;
		int pivot = array[(firstIndex + lastIndex) / 2];
		while(right >= left) {
			while(array[left] < pivot) {
				left++;
			}
			while(array[right] > pivot) {
				right--;
			}
				
			if(right >= left) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
			
		}
			
		if(left < lastIndex) {
			doQuickSort(array, left, lastIndex);
		}
			
		if(right > firstIndex) {
			doQuickSort(array, firstIndex, right);
		}
			
	}// end doQuickSort
			
}
