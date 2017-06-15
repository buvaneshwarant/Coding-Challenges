/**
 * Merging Two Arrays
 * 
 * You have 2 arrays that are in sorted order, Merge this tow arrays into a 
 * larger array that has the integers of both in sorted order.
 * 
 * For example:
 * 
 * {1, 3, 4, 5} merged with {2, 6, 8} will result in:
 * {1, 2, 3, 4, 5, 6, 8}
 * 
 * MergeArrays Time Complexity
 * 
 * A simplified time complexity of this function would be O(n) if we
 * assume that the two arrays are of the same length. We'll assume
 * they're of different lengths and we don't know what those are, and
 * we'll call them n and m. Together, the time complexity of MergeArrays 
 * would be O(n+m).
 * 
 * The space complexity would be similar, since we'll be adding the length's
 * of the two arrays to form a larger array.
 * 
 * We are not going to consider the printing of the result as part of what
 * contributes to the time complexity since it's a one time task.
 * 
 * 
 */
package arrays_and_strings;

import java.util.ArrayList;

public class Merge_Arrays {
	void merge(int[] arr1, int[] arr2){
		int p1 = 0; 
		int p2 = 0; 
		
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		
		while(p1 < arr1.length && p2 < arr2.length){
			if(arr1[p1] < arr2[p2]){
				result.add(arr1[p1]); 
				p1++; 
			}else if( arr1[p1] >= arr2[p2]){
				result.add(arr2[p2]); 
				p2++; 
			}
		}
		
		if(p1 < arr1.length){
			while(p1 < arr1.length){
				result.add(arr1[p1]); 
				p1++;
			}
		}
		
		if(p2 < arr2.length){
			while(p2 < arr2.length){
				result.add(arr2[p2]);
				p2++; 
			}
		}
		
		printResult(result); 
	}
	
	void printResult(ArrayList<Integer> result){
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i) + " ");
		}
		
		System.out.println(" ");
	}
	
	public static void main(String args[]){
		int[] first = new int[]{1, 3, 4};
		int[] second = new int[]{2, 5, 6}; 
		
		Merge_Arrays obj = new Merge_Arrays(); 
		obj.merge(first, second);
	}

}
