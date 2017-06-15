/**
 * Remove Kth Element Problem Statement
 * 
 * You're given an array of Linked List nodes, how would you
 * remove the Kth to last element in the list?
 * 
 * Example
 * Input:
 * A -- > B --> C --> D --> E
 * k = 3
 * 
 * Output: 
 * A --> B --> D -->E
 * 
 * The time complexity here is equal to the number of iterations
 * over the array, which is at most n, because the second pointer
 * has to reach the end of the list. Therefore, the overall
 * time complexity is O(n).
 * 
 */

package linked_list;

class Node{
	String value; 
	Node next = null; 
	
	Node(String v, Node n){
		value = v; 
		next = n;
	}
}

class KthSolver{
	Node head = null; 
	
	KthSolver(Node input){
		head  = input; 
	}
	
	void solve(int k){
		Node p1 = head;
		Node p2 = head; 
		
		while(k > 0){
			p2 = p2.next; 
			k--; 
		}
		
		while(p2 != null){
			p1 = p1.next; 
			p2 = p2.next; 
		}
		
		// p1 contains Kth to last element
		Node tmp = p1.next; 
		if(tmp == null){
			p1.value = null; 
			p1.next = null; 
		} else {
			p1.value = tmp.value; 
			p1.next = tmp.next; 
		}
		
		printResult(); 
	 
	}
	
	void printResult(){
		Node curr = head; 
		while(curr != null){
			System.out.println(curr.value + " "); 
			curr = curr.next; 
		}
		System.out.println(" ");
	}
}

public class RemoveKthElement {
	
	public static void main(String[] args){
		Node a = new Node("A", null); 
		Node b = new Node("B", null); 
		Node c = new Node("C", null); 
		Node d = new Node("D", null); 
		Node e = new Node("E", null); 
		
		a.next = b; 
		b.next = c; 
		c.next = d; 
		d.next = e;
		e.next = null;
		
		KthSolver obj = new KthSolver(a); 
		obj.solve(3);
		
	}
}
