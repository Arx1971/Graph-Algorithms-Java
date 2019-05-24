package queue_bfs;

public class Queue_list {
	
	Node head;
	
	class Node{
		int data;
		Node next;
		public Node(){
			
		}
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	public void print_list(){
		Node myNode = head;
		System.out.println("List: ");
		if(list_empty()){
			System.out.println("List Is empty: ");
			return;
		}
		while(myNode!=null){
			System.out.println(myNode.data);
			myNode = myNode.next;
		}
	}
	public void instantiate(int d){
		head = new Node(d);
		head.next = null;
	}
	public void q_push(int d){
		Node myNode;
		Node current = new Node(d);
		current.next = null;
		
		if(head == null) {
			instantiate(d);
			return;
		}
		
		myNode = head;
		while(myNode.next!=null){
			myNode = myNode.next;
		}
		myNode.next = current;
	}
	public void q_pop(){
		Node myNode = head;
		if(head!=null){
			head = myNode.next;
			return;
		}
	}
	public boolean list_empty(){
		if(head == null){
			return true;
		}
		return false;
	}
	public int list_size(){
		Node myNode = head;
		int count = 0;
		while(myNode!=null){
			count++;
			myNode = myNode.next;
		}
		return count;
	}
}
