package breadth_first_search;

// This is Generics Queue;


public class Queue <T>{

	public class Node<T>{
		
		T data;
		Node <T>next;
		
		public Node(T data) {
			this.data = data;
			next = null;
		}
		
	}
	Node<T> head;
	
	public void display() {
		Node<T> myNode = head;
		System.out.println("New List: ");
		while(myNode!=null) {
			System.out.println(myNode.data);
			myNode = myNode.next;
		}
	}
	
	public boolean empty() {
		if(head == null) return true;
		return false;
	}
	
	public void instantiate(T newData) {
		head = new Node<T>(newData);
		head.next = null;
	}
	
	public void push_back(T newData) {
		if(empty()) {
			instantiate(newData);
			return;
		}
		Node<T> myNode = head;
		Node<T> newNode = new Node<T>(newData);
		newNode.next = null;
		while(myNode.next!=null) {
			myNode = myNode.next;
		}
		myNode.next = newNode;
	}
	
	public void pop() {
		head = head.next;
	}
	
	public T front() { // generic class; instead returning the integer(int) type simply, 
							// I return object. 
		return head.data;
	}
	
}
