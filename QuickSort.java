package quickSort;

import java.util.Random;

import lab1.ArrayBag;

public class QuickSort {

	public static void main(String[] args) {
		ArrayBag<Integer> a1 = new ArrayBag<>(1000);
		ArrayBag<Integer> a2 = new ArrayBag<>(1000);

		Random r = new Random();
		int[] array =new int[1000];
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
		int indexOfPivot = firstIndex;
		int pivot = array[firstIndex];
		if((lastIndex - firstIndex) > 0) {
			while(true) {
				System.out.println("left: " + left + " right : " + right + " pivot: " + pivot);
				System.out.println("left value: " + array[left] + " right value: " + array[right]);
				while(array[left] < pivot) {
					left++;
					if(left >= lastIndex) {
						left--;
						break;
					}
				}
				while(right > firstIndex && array[right] > pivot) {
					right--;
					if(right < firstIndex) {
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
					array[right] = array[indexOfPivot];
					array[indexOfPivot] = temp;
					break;
				}
			}//end while
		}
		return right;
	}
	
	public static void quickSortByRecursion(int[] array) {

		doQuickSort(array, 0, array.length - 1);
		}

		private static void doQuickSort(int[] array, int firstIndex, int lastIndex) {
		if(lastIndex > firstIndex) {
			System.out.println(firstIndex + "   " +lastIndex);
			int indexOfPivot = partition(array, firstIndex, lastIndex);
			
			System.out.println("indexOfPivot: "+indexOfPivot + "  array[indexOfPivot] : "+ array[indexOfPivot]);
			for(int i = 0; i < array.length; i++) {
				if(i == indexOfPivot) {
					System.out.println(array[i]+ " <-----pivot");
					continue;
				}
				System.out.println(array[i]);
			}
			System.exit(0);
			doQuickSort(array, firstIndex, indexOfPivot);
			doQuickSort(array, indexOfPivot + 1, lastIndex);
		}
			

		}

}
