/**
 * Because you are doing an in place reversal, and iterating
 * through the list only once, the time complexity of reversing a 
 * SLL(Singly Linked List) is O(n).
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

class ReverseLinkedList {

	Node head = null; 
	
	ReverseLinkedList(Node input){
		head = input; 
	}
	
	public void solve(){
		Node prev = null; 
		Node curr = head; 
		
		while(curr != null){
			Node tmp = curr.next; 
			curr.next = prev; 
			prev = curr; 
			curr = tmp; 
			
			if(prev.value == null){
				head = prev; 
			}
		}
	
		printResult(); 
	}
	
	public void printResult(){
		Node curr = head; 
		while(curr != null){
			System.out.println(curr.value+ " ");
			curr = curr.next; 
		}
		System.out.println(" ");
	}
	
	

}

public class ReverseList{
	
	public static void main(String[] args){
		Node a = new Node("A", null); 
		Node b = new Node("B", null); 
		Node c = new Node("C", null); 
		Node tail = new Node(null, null); 
		a.next = b; 
		b.next = c; 
		c.next = tail; 
		ReverseLinkedList rList = new ReverseLinkedList(a); 
		rList.solve(); 
	}
	
}