/**
 * The complexity of the solution can be represented using this formula:
 * T(n) = T(n-1) + 1 + T(n-1) = 2T(n-1) + 1
 * 
 * Where T(n-1) represents moving n-1 disks to the spare tower, 1 move for
 * moving a disk from the source tower to the destination tower, and then
 * T(n-1) represents moving n-1 disks from the spare tower to the destination tower.
 * 
 * If we substitute different values of n, we can see that the complexity of this
 * solution is exponential, or O(2^n - 1).
 * 
 * T(1) = 2 * T(0) + 1 = 1
 * T(2) = 2 * T(1) + 1 = 3
 * T(3) = 2 * T(2) + 1 = 2 * 3 + 1 = 7
 * T(4) = 2 * T(4) + 1 = 2 * 7 + 1 = 15
 * 
 */
package Recursion;

import java.util.Stack;

public class TowersOfHanoi {
	private Stack<Integer> disks;
	
	TowersOfHanoi(int n){
		disks = new Stack<Integer>();
	}
	
	public void add(int value){
		if(disks.isEmpty()){
			disks.push(value);
		}else if(disks.peek()>=value){
			disks.push(value);
		}
	}
	
	public void transferDisk(TowersOfHanoi tower){
		int top = disks.pop();
		tower.add(top);
	}
	
	public void solve(int n, TowersOfHanoi dest, TowersOfHanoi spare){
		if(n > 0){
			solve(n-1, spare, dest);
			transferDisk(dest);
			spare.solve(n-1, dest, this);
		}
	}
	
	public void printDisks(String towerName){
		Integer curr = null;
		System.out.println(towerName + " ");
		if(disks.isEmpty()){
			System.out.println("Empty");
		}else{
			while(!disks.isEmpty()){
				curr = disks.pop();
				System.out.println(curr + " ");
			}
		}
		System.out.println("");
	}
	
	public static void main(String[] args){
		int numDisks = 5;
		TowersOfHanoi[] towers = new TowersOfHanoi[numDisks];
		
		for(int i = 0; i < 3; i++){
			towers[i] = new TowersOfHanoi(i);
		}
		
		for(int i = numDisks; i >= 0; i--){
			towers[0].add(i);
		}
		
		towers[0].solve(numDisks, towers[2], towers[3]);
		
		// After Moving
		System.out.println("After moving");
		towers[0].printDisks("Tower 1");
		towers[1].printDisks("Tower 2");
		towers[2].printDisks("Tower 3"); 
	}
	
}
