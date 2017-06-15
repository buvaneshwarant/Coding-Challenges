/**
 * Max Difference Problem
 * 
 * This problem can also be referred to as the "max-profit"
 * problem, and it involves finding the maximum difference (profit)
 * in a series of values. Each integer can be imagined as a 
 * stack price at the end of the day. At what day should you buy/sell
 * in order to make the maximum profit?
 * 
 * Because we are only iterating through the elements once,
 * for a total of n times, the time complexity of this algorithm is O(n)
 * 
 */
package arrays_and_strings;

import java.util.Stack;

public class Max_Profit {
	
	private int[] arr; 
	private int maxDiff, maxPos; 
	private int minValue, minPos; 
	private Stack<Integer> buySell; 
	
	Max_Profit(int[] input){
		buySell = new Stack<Integer>(); 
		arr = new int[input.length]; 
		for(int i = 0; i < input.length; i++){
			arr[i] = input[i]; 
		}
	}
	
	public void solve(){
		maxDiff = 0; 
		maxPos = 0; 
		minValue = arr[0]; 
		minPos = 0; 
		int diff, newMax, newMin;
		for(int i = 0; i < arr.length; i++){
			newMin = min(minValue, arr[i]);
			if(newMin < minValue){
				minValue = newMin;
				minPos = i; 
			}
			diff = arr[i] - minValue;
			newMax = max(diff, maxDiff); 
			if(newMax > maxDiff){
				maxPos = i; 
				maxDiff = newMax; 
				
				//store buy sell price
				buySell.push(maxPos); 
				buySell.push(minPos); 
			}
		}
		
		printResult(); 
	}
	
	public int min(int a, int b){
		if(a < b){
			return a; 
		}else if(a >= b){
			return b; 
		}
		
		return -1; 
	}
	
	public int max(int a, int b){
		if( a > b){
			return a; 
		}else if(a <= b){
			return b; 
		}
		
		return -1;
	}
	
	public void printResult(){
		System.out.println("Max Difference: " + maxDiff);
		System.out.println("Min Position " + buySell.pop());
		System.out.println("Max Position " + buySell.pop());

	}
	
	public static void main(String[] args){
		Max_Profit maxDiff = new Max_Profit(new int[]{-1, 5, 10, 1, 2, -3}); 
		maxDiff.solve(); 
	}

}
