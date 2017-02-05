package quickSort;

import java.util.Random;

import lab1.ArrayBag;

public class QuickSort {

	public static void main(String[] args) {
		ArrayBag<Integer> a1 = new ArrayBag<>(10);
		ArrayBag<Integer> a2 = new ArrayBag<>(10);

		Random r = new Random();
		int[] array =new int[10];
		System.out.println("random integers: ");
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(500);
			a1.add(array[i]);
		}
		System.out.println("quickSortByIteration: ");
		quickSortByIteration(array);
		for(int i = 0; i < array.length; i++) {
			a2.add(array[i]);
		}
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				System.out.println("*****Failed");
				break;
			}
		}
		System.out.println(a1.equals(a2));
	}
	
	public static void quickSortByIteration(int[] array) {
		int left = 1;
		int right = array.length - 1;
		int pivot = array[0];
		while(true) {
			while(array[left] < pivot) {
				left++;
				if(left >= array.length) {
					left--;
					break;
				}
				
			}
			while(right > 0 && array[right] > pivot) {
				right--;
				if(right < 0) {
					right++;
					break;
				}
			}
			if((array[left] >= pivot) && (array[right] <= pivot) && right > left) {
				
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				if(array[left] == array[right])
					left++;
			}
			if((right - left) <= 0) {
				int temp = array[right];
				array[right] = array[0];
				array[0] = temp;
				break;
			}
			
		}//end while
		sort (array, 0, right);
		sort (array, right + 1, array.length - 1);
		
	}
	
	private static void sort (int[] array, int first, int last) {
		for (int i = first; i <= last; i++) {
			int j = i;
			while((j > first) && (array[j] < array[j-1])) {
				int temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;
				j--;
			}//end while
		}//end for
	}//end sort

}
