package deapth_first_search;


public class Stack <T>{

	class Node <T>{
		T data;
		Node<T> next;
		
		public Node(T data) {
			this.data = data;
			next = null;
		}
	}
	
	Node <T>head;
	
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
	
	public void push(T newData) {
		if(empty()) {
			instantiate(newData);
			return;
		}
		Node<T>myNode = head;
		Node<T>newNode = new Node<T>(newData);
		newNode.next = null;
		while(myNode.next!=null) {
			myNode = myNode.next;
		}
		myNode.next = newNode;
	}
	
	public T top() {
		
		Node<T> myNode = head;
		
		while(myNode.next!=null) {
			myNode = myNode.next;
		}
		return myNode.data;
	}
	
	public void clear() {
		head = null;
		
		return;
	}
	
	public void pop() {
		Node<T>myNode = head;
		if(myNode.next == null) {
			head = null;
			return;
		}
		while(myNode.next.next!=null) {
			myNode = myNode.next;
		}
		myNode.next = null;
	}
	
	
}
