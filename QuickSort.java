package quickSort;

import java.util.Random;

import lab1.ArrayBag;

public class QuickSort {

	public static void main(String[] args) {
		ArrayBag<Integer> a1 = new ArrayBag<>(50000);
		ArrayBag<Integer> a2 = new ArrayBag<>(50000);

		Random r = new Random();
		int[] array =new int[50000];
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
		
		a1.clear();
		a2.clear();
		
		System.out.println("random integers: ");
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(500);
			a1.add(array[i]);
		}
		System.out.println("mergeSortByRecursion: ");
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
		System.out.println(a1.equals(a2));

	}
	
	public static void quickSortByIteration(int[] array) {
		
		int indexOfPivot = partition(array, 0, array.length - 1);
		sort (array, 0, indexOfPivot);
		sort (array, indexOfPivot + 1, array.length - 1);
		
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
	
	
	private static int partition(int[] array, int firstIndex, int lastIndex) {
		int left = firstIndex;
		int right = lastIndex;
		int pivot = array[(firstIndex + lastIndex) / 2];
		while(left <= right) {
			while(array[left] < pivot) {
				left++;
			}
			while(array[right] > pivot) {
				right--;

			}
			if(left <= right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}//end while
		return right;
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
