package linked_list;
/**
 * 
 * @author bt
 * When you are iterating the fast/slow pointer forward, if a cycle
 * is present, then you will have fast and slow equal to each other
 * before slow reaches the end of the list. This is n interations, which
 * results in O(n) runtime.
 * 
 * LinkedList:
 * (A --> B --> C --> A)
 * 
 * (Initial)
 * Slow = A
 * Fast = B
 * 
 * (loop 1)
 * Slow = B
 * Fast = C
 * 
 * (loop 2)
 * Slow = C
 * Fast = A
 * 
 * (loop 3)
 * Slow = A
 * Fast = A
 * 
 * Length of Array: 3
 */

class Node{
	String value;
	Node next = null;
	
	Node(String v, Node n){
		value = v; 
		next = n; 
	}
}

class LinkedList{
	Node head; 
	Node tail; 
	
	LinkedList(Node start){
		head = start; 
		tail = start;
	}
	
	void insert(Node e){
		tail.next = e;
		tail = e; 
	}
	
}

class Cycles{
	private LinkedList list = new LinkedList(null); 
	Cycles(LinkedList input){
		list = input; 
	}
	
	void solve(){
		Node result = null; 
		Node fast, slow; 
		Node prev = null; 
		slow = list.head; 
		fast = list.head; 
		boolean loop = true; 
		
		while(loop){
			// advance the pointers
			slow = slow.next; 
			if(fast.next != null){
				prev = fast.next; 
				fast = fast.next.next; 
			}else{
				loop = false;
				result = null;
			}
			
			if(slow == fast && loop){
				result = prev; 
				loop = false;
			}else if(slow == null || fast == null){
				result = null; 
				loop = false; 
			}
		}
		
		printResult(result); 
	}
	
	void printResult(Node result){
		if(result != null){
			System.out.println("Cycle detected at: " + result.value);
		} else {
			System.out.println("No cycle detected.");
		}
	}
}


public class DetectingCycles {
	public static void main(String[] args){
		Node c = new Node("C", null); 
		Node b = new Node("B", null); 
		Node a = new Node("A", null); 
		a.next = b; 
		b.next = c; 
		c.next = a; 
		LinkedList list = new LinkedList(a); 
		list.insert(b);
		list.insert(c);
		list.insert(a);
		
		Cycles cycle = new Cycles(list);
		cycle.solve(); 
	}
}
