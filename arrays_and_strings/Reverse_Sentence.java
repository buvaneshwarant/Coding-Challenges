/**
 * When we are looping through the array and storing the characters
 * into an ArrayList, we are doing that n times. When we print out the 
 * results, we are iterating through the list a total of n times.
 * If we count the printing time, this results in a O(2n) = O(n) time complexity.
 * 
 * How could this be implemented using a stack? 
 * 
 * 'cat' --> s.push(c) s.push(a) s.push(t)
 * 
 * while(!s.isEmpty()){
 * s.pop(); 
 * }
 */
package arrays_and_strings;

import java.util.ArrayList;

public class Reverse_Sentence {
	
	String input;
	
	Reverse_Sentence(String i){
		input = i; 
	}
	
	public void reverse(){
		ArrayList<Character> tap = new ArrayList<Character>();
		
		for(int i = input.length() -1; i >= 0; i--){
			tap.add(input.charAt(i)); 
		}
		
		printResult(tap); 
		
	}
	
	public void printResult(ArrayList<Character> List){
		for(int i = 0; i < List.size(); i++){
			System.out.println(List.get(i)); 
		}
	}
	
	public static void main(String[] args){
		Reverse_Sentence sentence = new Reverse_Sentence("Make America Great Again");
		sentence.reverse();
	}

}
