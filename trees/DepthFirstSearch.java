package trees;

import java.util.Stack;

public class DepthFirstSearch {
	private Node root;
	
	DepthFirstSearch(Node first){
		root = first;
		System.out.println("Iterative");
		traverseIterative();
		System.out.println("\nRecursive");
		traverseRecursive(root);
	}

	void traverseIterative(){
		if(root == null){
			return;
		}
		Stack<Node> s = new Stack<Node>();
		root.visited = true;
		System.out.print(root.value + " ");
		s.push(root);
		Node curr = root;
		
		while(!s.isEmpty()){
			for(Node n: curr.children()){
				if(n != null && !n.visited){
					n.visited = true;
					System.out.println(n.value + " ");
					s.push(n);
				}
			}
			curr = s.pop();
		}
	}
	
	
	private void traverseRecursive(Node curr) {
		// TODO Auto-generated method stub
		if(curr == null){
			return;
		}
		
		curr.visited = true;
		System.out.println(curr.value + " ");
		traverseRecursive(curr.left);
		traverseRecursive(curr.right);
		
	}
	
	public static void main(String[] args){
		Node three_first = new Node(3,null,null);
		Node two = new Node(2,null,null);
		Node three = new Node(3,null,null);
		Node four = new Node(4,null,null);
		Node six = new Node(6,null,null);
		
		three_first.left = two;
		three_first.right = four;
		four.left = three;
		four.right = six;
		
		DepthFirstSearch perm = new DepthFirstSearch(three_first);
	}
}
