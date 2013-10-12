package ch2_linked_lists;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Linked in data structure implement
 * @author weiqi
 *
 * @param <E>
 */
public class LinkedList<E> {
	
	private Node<E> head;
	private int numElements;
	public LinkedList(){
		head = null;
		numElements = 0;
	}
	
	public int size(){
		return this.numElements;
	}
	
	private void addFirst(E item){
		head = new Node(item, head);// mistake ! :this.head.item = item;
		this.numElements++;
	}
	
	private E getFirst(){
		if (head==null){
			throw new NoSuchElementException();
		}
		return head.item;
	}
	
	private E removeFirst(){
		if (head==null){
			throw new NoSuchElementException();
		}
		E oldData = head.item;
		head = head.next;
		numElements--;
		return oldData;
	}
	
	public String toString(){
		if(head==null) return "";
		if(head.item == null) return "";
		String s = head.item.toString();
		Node<E> pointer = head.next;
		while (pointer != null){
			s = s + "=>" + pointer.item.toString();
			pointer = pointer.next;
		}
		return s;
	}
	
	public boolean add(Object obj){
		E addItem = (E) obj;
		if (head==null){
			addFirst(addItem);
			return true;
		}
		Node<E> pointer = head.next;
		while (pointer.next != null){
			pointer.next = pointer;
		}
		pointer.next = new Node(addItem, null);
		numElements++;
		return true;
	}
	
	public void add(int index, E element){
		if (index < 0 || index > numElements) {
			throw new IndexOutOfBoundsException("" + index);
		}

		if (index == 0) {
			addFirst(element);
			return;
		}

		Node<E> nodeBefore = head;
		for (int i = 0; i < index-1; i++) {
			nodeBefore = nodeBefore.next;
		}
		nodeBefore.next = new Node<E>(element, nodeBefore.next);
		numElements++;
	}
	
	public E remove(int index){
		if (index < 0 || index >= numElements) {
			throw new IndexOutOfBoundsException("" + index);
		}
		
		if (index == 0) return removeFirst();
		
		Node<E> nodeBefore = head;
		for (int i = 0; i < index-1; i++) {
			nodeBefore = nodeBefore.next;
		}
		Node<E> nodeToRemove = nodeBefore.next;
		nodeBefore.next = nodeToRemove.next;
		numElements--;
		return nodeToRemove.item;
	}
	
	public E set(int index, E element){
		if (index < 0 || index >= numElements) {
			throw new IndexOutOfBoundsException("" + index);
		}

		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		E oldData = current.item;
		current.item = element;
		return oldData;
	}
	
	public E get(int index){
		if (index < 0 || index >= numElements) {
			throw new IndexOutOfBoundsException("" + index);
		}

		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		E oldData = current.item;
		return oldData;
	}
	
	private static class Node<E>{
		private E item;
		private Node<E> next;
		
		public Node(E element, Node<E> nodeRef){
			item = element;
			next = nodeRef;
		}
	}
	
	/** Exercise Part **/
	
	/**
	 * Method to remove the duplicate
	 */
	public void removeDup(){
		Node<E> pointer1 = head;
		if (pointer1==null|numElements==1) return;
		Node<E> pointer2;
		while(pointer1!=null){
			pointer2 = pointer1;
			while(pointer2.next!=null){
				if(pointer1.item.equals(pointer2.next.item) && (pointer2.next.next!=null)){
					pointer2.next = pointer2.next.next;
				} else if (pointer1.item.equals(pointer2.next.item)){
					pointer2.next=null;
				} else {
					pointer2 = pointer2.next;
				}
			}
			pointer1=pointer1.next;
		}
 	}
	
	/**
	 * Use an two pointer to find the element
	 * @param n
	 * @return
	 */
	public E findNthToLast(int n){
		Node<E> pointer1 = head;
		Node<E> pointer2 = head;
		for(int i=0; i<n;i++){
			if (pointer1==null){
				return null;
			}
			pointer1 = pointer1.next;
		}
		while(pointer1!=null){
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return pointer2.item;
	}
	
	/**
	 * Implement an algorithm to delete a node in the middle of a single linked list, 
	 * given only access to that node.
	 * mistake: return value (delete should return if deleted)
	 * @param pointer
	 */
	public boolean delMiddle(Node<E> pointer){
		if (pointer==null || pointer.next==null){
			pointer=null;
			return false;
		} else {
			pointer.item = pointer.next.item;
			pointer.next = pointer.next.next;
			return true;
		}
		
	}
	
	/** !!!!!!!!!!!!!!!!!!
	 * Using recursion to solve this
	 * @param a
	 * @param b
	 * @return
	 */
	public Node<Integer> addition(int carry, Node<Integer> p1, Node<Integer> p2){
		if(p1 == null && p2 == null){
			return null;
		}
		Node<Integer> result = new Node(carry, null);
		int value = carry;
		value += (p1==null ? 0 : p1.item);
		value += (p2==null ? 0 : p2.item);
		result.item = value%10;
		Node<Integer> nextResult = addition(value>=10? 1:0, 
									p1==null?null:p1.next,
									p2==null?null:p2.next);
		
		result.next = nextResult;
		return result;
	}
	
	/**
	 * Simply test in main
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedList<String> nameList = new LinkedList<String>();

		nameList.addFirst("Dave");
		nameList.add(0, "Ann");
		nameList.add(1, "Bob");
		nameList.add(2, "Tom");
		nameList.add(3, "Margaret");
		nameList.addFirst("Dave");
		nameList.addFirst("Weiqi");
		nameList.addFirst("Bob");
		nameList.add(8, "Bob");
		nameList.add(9, "Bob");
		System.out.println(nameList);
		
		System.out.println(nameList.findNthToLast(3).toString());
		
		nameList.removeDup();
		System.out.println(nameList);
		
		LinkedList<String> nameList2 = new LinkedList<String>();
		nameList2.removeDup();
		System.out.println(nameList2);
		nameList2.addFirst("Bob");
		System.out.println(nameList2);
		nameList2.addFirst("Bob");
		nameList2.removeDup();
		System.out.println(nameList2);
		
		LinkedList<Integer> a = new LinkedList<Integer>(); // caution
		LinkedList<Integer> b = new LinkedList<Integer>(); 
		a.addFirst(3);
		a.addFirst(5);
		a.addFirst(1);
		a.addFirst(3);
		b.addFirst(2);
		b.addFirst(9);
		b.addFirst(5);
		System.out.println(a);
		System.out.println(b);

		Node<Integer> p1 = a.head;
		Node<Integer> p2 = b.head;
		Node<Integer> result;
		result = a.addition(0, p1, p2);
		String s = result.item.toString();
		while (result.next!=null){
			s = s + "=>" + result.next.item.toString();
			result = result.next;
		}
		System.out.println(s);
		
//		System.out.println(nameList.size());
//
//		System.out.println(nameList.getFirst());
//		System.out.println(nameList.get(1));
//		nameList.set(3, "Davide");
//		System.out.println(nameList.get(3));
//
//		nameList.remove(0);
//		System.out.println(nameList);
//		nameList.remove(2);
//		System.out.println(nameList);
//		nameList.removeFirst();
//		System.out.println(nameList);
//		nameList.remove(1);
//		System.out.println(nameList);
//		nameList.remove(0);
//		System.out.println(nameList);		
	}
}
