package quickSort;

import java.util.Random;

import homework2.LinkedDataStack;
import lab1.ArrayBag;


public class QuickSort {

	public static void main(String[] args) {
		ArrayBag<Integer> a1 = new ArrayBag<>(100000);
		ArrayBag<Integer> a2 = new ArrayBag<>(100000);

		Random r = new Random();
		int[] array =new int[100000];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(500);
			a1.add(array[i]);
		}

		System.out.println("quickSortByIteration: ");
		quickSortByIteration(array);
		for(int i = 0; i < array.length; i++) {
			a2.add(array[i]);
			//System.out.println(array[i]);
		}
		
		

		System.out.println("done\n");

		a1.clear();
		a2.clear();
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(500);
			a1.add(array[i]);
		}
		System.out.println("quickSortByRecursion: ");
		
		quickSortByRecursion(array);

		for(int i = 0; i < array.length; i++) {
			a2.add(array[i]);
		}
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				System.out.println("*****Failed");
				break;
			}
		}
		System.out.println("done");

	}
	
	public static void quickSortByIteration(int[] array) {
		
		LinkedDataStack<Integer> stack = new LinkedDataStack<>();
		stack.push(-1);
		stack.push(array.length - 1);
		stack.push(0);
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
	}
	
	
	public static void quickSortByRecursion(int[] array) {

		doQuickSort(array, 0, array.length - 1);
	}

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
			
		}
			
}
